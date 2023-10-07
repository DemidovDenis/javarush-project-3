package com.javarush.gamequest;

import com.javarush.gamequest.game_content.User;
import com.javarush.gamequest.repository.Repository;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/start")
public class StartServlet extends HttpServlet {
    private Repository<String, User> userRepository;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext servletContext = config.getServletContext();
        userRepository = (Repository<String, User>) servletContext.getAttribute("userRepository");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        User user;
        int visitCount;
        if (session.getAttribute("user") != null && userRepository.isExists(username)){
            user = userRepository.getById(username);
            visitCount = user.getGameCounter() + 1;
            user.setGameCounter(visitCount);

            session.setAttribute("visitCount", visitCount);
            session.setAttribute("user", user);

            getServletContext()
                    .getRequestDispatcher("/dialog")
                    .forward(request, response);
            return;
        }

        if (!userRepository.isExists(username)){
            visitCount = 0;
            user = new User();

            user.setUsername(username);
            visitCount = visitCount + 1;
            user.setGameCounter(visitCount);
            userRepository.save(username, user);

            session.setAttribute("visitCount", visitCount);
            session.setAttribute("user", user);
        }

        getServletContext()
                .getRequestDispatcher("/dialog")
                .forward(request, response);
    }
}
