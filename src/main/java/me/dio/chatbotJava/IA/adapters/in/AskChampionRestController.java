package me.dio.chatbotJava.IA.adapters.in;

import me.dio.chatbotJava.IA.application.AskChampionUseCase;
import me.dio.chatbotJava.IA.application.ListChampionsUseCase;
import me.dio.chatbotJava.IA.domain.model.Champions_record;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/champions")
public record AskChampionRestController(AskChampionUseCase useCase) {

    @PostMapping ("/{championId}/ask")
    public AskChampionResponse askChampion (
            @PathVariable Long championId,
            @RequestBody AskChampionRequest request) {

        String answer = useCase.askChampion(championId, request.question());
        return new AskChampionResponse(answer);
    }
    public record AskChampionRequest(String question) { }
    public record AskChampionResponse(String answer) { }
}