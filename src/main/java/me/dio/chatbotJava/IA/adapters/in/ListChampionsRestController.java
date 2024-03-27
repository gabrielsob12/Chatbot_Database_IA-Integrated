package me.dio.chatbotJava.IA.adapters.in;

import me.dio.chatbotJava.IA.application.ListChampionsUseCase;
import me.dio.chatbotJava.IA.domain.model.Champions_record;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase){

    @GetMapping
    public List<Champions_record> findAllChampions() {return useCase.findAll(); }
}
