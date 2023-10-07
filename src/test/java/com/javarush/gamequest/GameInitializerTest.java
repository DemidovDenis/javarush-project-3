package com.javarush.gamequest;

import com.javarush.gamequest.game_content.GameOver;
import com.javarush.gamequest.game_content.Message;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameInitializerTest {
    /**
     * Тест проверяет, что метод getDefaultMessages() возвращает список, который содержит те же объекты и в той же последовательности,
     * что и список который был передан в конструктор.
     */
    @Test
    void testGetDefaultMessages_ShouldReturnList(){
        Message testMessage1 = Message.builder()
                .id(1)
                .text("Ты потерял память." + "\n" + "Принять вызов НЛО?")
                .answers(List.of(
                        Message.Answer.builder()
                                .text("Принять вызов")
                                .answerId(1)
                                .nextMessageId(2)
                                .build(),
                        Message.Answer.builder()
                                .text("Отклонить вызов")
                                .answerId(2)
                                .gameOverId(1)
                                .isFinish(true)
                                .build(),
                        Message.Answer.builder()
                                .text("Ты отклонил вызов.")
                                .answerId(3)
                                .build()
                ))
                .build();

        Message testMessage2 = Message.builder()
                .id(2)
                .text("Ты принял вызов." + "\n" + "Поднимешься на мостик капитана?")
                .answers(List.of(
                        Message.Answer.builder()
                                .text("Подняться на мостик")
                                .answerId(1)
                                .nextMessageId(3)
                                .build(),
                        Message.Answer.builder()
                                .text("Отказаться подниматься на мостик")
                                .answerId(2)
                                .gameOverId(1)
                                .isFinish(true)
                                .build(),
                        Message.Answer.builder()
                                .text("Ты не пошел на переговоры.")
                                .answerId(3)
                                .build()
                ))
                .build();

        Message testMessage3 = Message.builder()
                .id(3)
                .text("Ты поднялся на мостик." + "\n" + "Ты кто?")
                .answers(List.of(
                        Message.Answer.builder()
                                .text("Рассказать правду о себе")
                                .answerId(1)
                                .nextMessageId(4)
                                .gameOverId(2)
                                .isFinish(true)
                                .build(),
                        Message.Answer.builder()
                                .text("Солгать о себе")
                                .answerId(2)
                                .gameOverId(1)
                                .build(),
                        Message.Answer.builder()
                                .text("Твою ложь разоблачили.")
                                .answerId(3)
                                .build(),
                        Message.Answer.builder()
                                .text("Тебя вернули домой.")
                                .answerId(4)
                                .build()
                ))
                .build();

        List<Message> actual = List.of(testMessage1,testMessage2,testMessage3);

        List<Message> expected = new GameInitializer().getDefaultMessages();
        assertEquals(expected,actual);
    }

    /**
     * Тест проверяет, что метод getDefaultGameOver() возвращает список, который содержит те же объекты и в той же последовательности,
     * что и список который был передан в конструктор.
     */
    @Test
    void testGetDefaultGameOver_ShouldReturnList() {
        GameOver testGameOver1 = GameOver.builder()
                .id(1)
                .text("Поражение")
                .build();

        GameOver testGameOver2 = GameOver.builder()
                .id(2)
                .text("Победа")
                .build();

        List<GameOver> actual = List.of(testGameOver1,testGameOver2);

        List<GameOver> expected = new GameInitializer().getDefaultGameOver();
        assertEquals(expected,actual);
    }
}