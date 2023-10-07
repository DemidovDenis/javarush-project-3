package com.javarush.gamequest;

import com.javarush.gamequest.game_content.GameOver;
import com.javarush.gamequest.game_content.Message;
import com.javarush.gamequest.repository.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;;

@WebListener
public class AppContextListener implements ServletContextListener {
    private static final Logger LOGGER = LogManager.getLogger(AppContextListener.class);
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        GameInitializer initializer = new GameInitializer();

        LOGGER.info(initializer);
        ServletContext ctx = servletContextEvent.getServletContext();

        ctx.setAttribute("userRepository", new Repository<>());

        Repository<Integer, Message> messageRepository = new Repository<>();

        for (Message message : initializer.getDefaultMessages()) {
            messageRepository.save(message.getId(), message);
        }
        ctx.setAttribute("messageRepository", messageRepository);

        Repository<Integer, GameOver> gameOverRepository = new Repository<>();

        for (GameOver gameOver : initializer.getDefaultGameOver()) {
            gameOverRepository.save(gameOver.getId(), gameOver);
        }
        ctx.setAttribute("gameOverRepository", gameOverRepository);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
    }
}