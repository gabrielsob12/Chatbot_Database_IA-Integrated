package me.dio.chatbotJava.IA.application;

import me.dio.chatbotJava.IA.domain.model.Champions_record;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ListChampionsUseCaseIntegrationTest {

    @Autowired
    private ListChampionsUseCase listChampionsUseCase;

    @Test
    public void testListChampions() {
        List<Champions_record> champions = listChampionsUseCase.findAll();

        Assertions.assertEquals(12, champions.size());
    }

}
