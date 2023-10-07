package com.javarush.gamequest.repository;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {

    public Map<Integer, String> getUp() {
        Map<Integer, String> repositoryTest = new HashMap<>();
        repositoryTest.put(1,"Text1");
        repositoryTest.put(2,"Text2");
        repositoryTest.put(3,"Text3");
        return repositoryTest;
    }

    /**
     * Тест проверяет, что метод сохраняет объекты в репозиторий.
     */
    @Test
    void testSaveRepository() {
        Repository<Integer,String> actual = new Repository<>();
        actual.save(1,"Text1");
        actual.save(2,"Text2");
        actual.save(3,"Text3");

        for (Map.Entry<Integer, String> pair : actual.repository.entrySet()) {
            Integer key = pair.getKey();
            String text = pair.getValue();

            assertEquals(getUp().get(key),text);
        }
    }

    /**
     * Тест проверяет, что метод возвращает содержимое репозитория по id.
     */
    @Test
    void testGetByIdRepository() {
        Repository<Integer,String> actual = new Repository<>();
        actual.save(1,"Text1");
        actual.save(2,"Text2");
        actual.save(3,"Text3");

        for (Map.Entry<Integer, String> pair : actual.repository.entrySet()) {
            Integer key = pair.getKey();

            assertEquals(getUp().get(key),actual.getById(key));
        }
    }

    /**
     * Тест проверяет, существует ли содержимое репозитория по id.
     */
    @Test
    void testIsExistsRepository() {
        Repository<Integer,String> actual = new Repository<>();
        actual.save(1,"Text1");
        actual.save(2,"Text2");
        actual.save(3,"Text3");
        boolean isExistsKey = actual.isExists(1);

        assertTrue(isExistsKey);
    }

    /**
     * Тест проверяет на пустоту репозитория.
     */
    @Test
    void testIsEmptyRepository() {
        Repository<Integer,String> actual = new Repository<>();
        actual.save(1,"Text1");
        actual.save(2,"Text2");
        actual.save(3,"Text3");
        actual.repository.clear();

        assertTrue(actual.isEmpty());
    }
}