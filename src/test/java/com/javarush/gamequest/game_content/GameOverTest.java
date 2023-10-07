package com.javarush.gamequest.game_content;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOverTest {
    /**
     * Тест проверяет, что метод возвращает число, которое было передано первым параметром в конструктор.
     */
    @Test
    void testGetId_ShouldReturnNumber() {
        Integer expected = 0;
        Integer actual = GameOver.builder()
                .id(0)
                .text("Text")
                .build()
                .getId();
        assertEquals(expected,actual);
    }

    /**
     * Тест проверяет, что метод возвращает строку, которая была передана вторым параметром в конструктор.
     */
    @Test
    void testGetText_ShouldReturnString() {
        String expected = "Text";
        String actual = GameOver.builder()
                .id(0)
                .text("Text")
                .build()
                .getText();
        assertEquals(expected,actual);
    }
}