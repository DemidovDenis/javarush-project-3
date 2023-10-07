package com.javarush.gamequest;

import com.javarush.gamequest.game_content.GameOver;
import com.javarush.gamequest.game_content.Message;
import com.javarush.gamequest.game_content.User;
import com.javarush.gamequest.repository.Repository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.servlet.ServletContext;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppContextListenerTest {
    @Mock
    private ServletContext context;
    @Mock
    private GameInitializer newInitializer;
    @Mock
    private Repository<Integer, User> testUserRepository = new Repository<>();
    @Mock
    private Repository<Integer, Message> testMessageRepository = new Repository<>();
    @Mock
    private Repository<Integer, GameOver> testGameOverRepository = new Repository<>();


    @Test
    void testContextInitialized() {

        when(newInitializer.getDefaultMessages()).thenReturn(List.of());
        for (Message message : newInitializer.getDefaultMessages()) {
            testMessageRepository.save(message.getId(), message);
        }
        context.setAttribute("messageRepository", testMessageRepository);

        verify(context).setAttribute("messageRepository", testMessageRepository);
    }

    @Test
    void contextDestroyed() {
    }
}