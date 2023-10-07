package com.javarush.gamequest.game_content;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Message {
    private Integer id;
    private String text;
    private List<Answer> answers;

    @Data
    @AllArgsConstructor
    @Builder
    public static class Answer{
        String text;
        private Integer answerId;
        private Integer nextMessageId;
        private Integer gameOverId;
        @Builder.Default
        private Boolean isFinish = false;
    }
}
