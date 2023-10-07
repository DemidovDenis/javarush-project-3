package com.javarush.gamequest.game_content;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class GameOver {
    private Integer id;
    private String text;
}
