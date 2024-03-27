package me.dio.chatbotJava.IA.application;

import me.dio.chatbotJava.IA.domain.exception.ChampionNotFoundException;
import me.dio.chatbotJava.IA.domain.model.Champions_record;
import me.dio.chatbotJava.IA.domain.ports.ChampionsRepository;

public record AskChampionUseCase(ChampionsRepository repository) {

    public String askChampion(Long championId, String question) {

        Champions_record championsRecord = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = championsRecord.generateContextByQuestion(question);

        return championContext;
    }
}
