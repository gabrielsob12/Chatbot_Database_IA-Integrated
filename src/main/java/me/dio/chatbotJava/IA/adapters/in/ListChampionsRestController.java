package me.dio.chatbotJava.IA.adapters.in;

import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.chatbotJava.IA.application.ListChampionsUseCase;
import me.dio.chatbotJava.IA.domain.model.Champions_record;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Campeões", description = "Endpoints do domínio de Campeões do Lol.")
@RestController
@RequestMapping("/champions")
public record ListChampionsRestController(ListChampionsUseCase useCase){

    @GetMapping
    public List<Champions_record> findAllChampions() {
        return useCase.findAll(); }
}
