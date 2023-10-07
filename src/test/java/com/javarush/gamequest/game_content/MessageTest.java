package com.javarush.gamequest.game_content;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {
    /**
     * Тест проверяет, что метод возвращает число, которое было передано первым параметром в конструктор.
     */
    @Test
    void testGetId_ShouldReturnNumber() {
        Integer expected = 0;
        Integer actual = Message.builder()
                .id(0)
                .text("Text")
                .answers(List.of())
                .build()
                .getId();
        assertEquals(expected,actual);
    }

    /**
     * Тест проверяет, что метод возвращает строку, которая была передана вторым параметром в конструктор.
     */
    @Test
    void  testGetText_ShouldReturnString() {
        String expected = "Text";
        String actual = Message.builder()
                .id(0)
                .text("Text")
                .answers(List.of())
                .build()
                .getText();
        assertEquals(expected,actual);
    }

    /**
     * Тест проверяет, что метод возвращает коллекцию, которая была передана третьим параметром в конструктор.
     */
    @Test
    void testGetAnswer_ShouldReturnList() {
        List<Message.Answer> expected = List.of();
        List<Message.Answer> actual = Message.builder()
                .id(0)
                .text("Text")
                .answers(List.of())
                .build()
                .getAnswers();
        assertEquals(expected,actual);
    }
}