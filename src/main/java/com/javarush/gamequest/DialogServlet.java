package com.javarush.gamequest;

import com.javarush.gamequest.game_content.GameOver;
import com.javarush.gamequest.game_content.Message;
import com.javarush.gamequest.repository.Repository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/dialog")
public class DialogServlet extends HttpServlet {

    private Repository<Integer, Message> messageRepository;
    private Repository<Integer, Message.Answer> answerRepository = new Repository<>();
    private Repository<Integer, GameOver> gameOverRepository;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        messageRepository = (Repository<Integer, Message>) servletContext.getAttribute("messageRepository");
        gameOverRepository = (Repository<Integer, GameOver>) servletContext.getAttribute("gameOverRepository");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int messageId;
        if (request.getParameter("message") != null) {
            messageId = Integer.parseInt(request.getParameter("message"));
        } else {
            messageId = 1;
        }

        Message message = messageRepository.getById(messageId);
        request.setAttribute("message", message);

        String answerSelected = request.getParameter("answers");
        int answerSelectedId;
        if ("1".equals(answerSelected)) {
            answerSelectedId = Integer.parseInt(answerSelected);

            for (Message.Answer answer:message.getAnswers()) {
                answerRepository.save(answer.getAnswerId(), answer);
            }
            Message.Answer answer = answerRepository.getById(answerSelectedId);

            if (answer.getIsFinish()){
                request.setAttribute("answers", answer);

                if (answer.getGameOverId() == 2) {
                    request.setAttribute("gameOver", gameOverRepository.getById(answer.getGameOverId()));
                }
                getServletContext()
                        .getRequestDispatcher("/game_over.jsp")
                        .forward(request, response);
                return;
            }
            request.setAttribute("message", messageRepository.getById(answer.getNextMessageId()));
        }

        if ("2".equals(answerSelected)){
            answerSelectedId = Integer.parseInt(answerSelected);

            for (Message.Answer answer:message.getAnswers()) {
                answerRepository.save(answer.getAnswerId(), answer);
            }

            Message.Answer answer = answerRepository.getById(answerSelectedId);
            request.setAttribute("answers", answerRepository.getById(answerSelectedId));
            request.setAttribute("message", message);

            if (answer.getGameOverId() == 1) {
                request.setAttribute("gameOver", gameOverRepository.getById(answer.getGameOverId()));
            }

            getServletContext()
                    .getRequestDispatcher("/game_over.jsp")
                    .forward(request, response);
            return;
        }

        getServletContext()
                .getRequestDispatcher("/dialog.jsp")
                .forward(request, response);
    }
}
