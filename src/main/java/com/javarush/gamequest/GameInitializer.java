package com.javarush.gamequest;

import com.javarush.gamequest.game_content.*;

import java.util.ArrayList;
import java.util.List;

public class GameInitializer {

    public List<Message> getDefaultMessages() {
        List<Message> messages = new ArrayList<>();

        messages.add(
                Message.builder()
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
                        .build()
        );

        messages.add(
                Message.builder()
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
                        .build()
        );

        messages.add(
                Message.builder()
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
                        .build()
        );

        return messages;
    }

    public List<GameOver> getDefaultGameOver() {
        List<GameOver> gameOvers = new ArrayList<>();
        gameOvers.add(
                GameOver.builder()
                        .id(1)
                        .text("Поражение")
                        .build()
        );

        gameOvers.add(
                GameOver.builder()
                        .id(2)
                        .text("Победа")
                        .build()
        );

        return gameOvers;
    }
}
