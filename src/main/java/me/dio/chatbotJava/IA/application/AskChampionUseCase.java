package me.dio.chatbotJava.IA.application;

import me.dio.chatbotJava.IA.domain.exception.ChampionNotFoundException;
import me.dio.chatbotJava.IA.domain.model.Champions_record;
import me.dio.chatbotJava.IA.domain.ports.ChampionsRepository;
import me.dio.chatbotJava.IA.domain.ports.GenerativeAiApi;

public record AskChampionUseCase(ChampionsRepository repository, GenerativeAiApi generativeAiApi) {

    public String askChampion(Long championId, String question) {

        Champions_record championsRecord = repository.findById(championId)
                .orElseThrow(() -> new ChampionNotFoundException(championId));

        String championContext = championsRecord.generateContextByQuestion(question);
        String objective = """
                Atue como assitente com habilidade de se comportar como campeões do Valorant (Vava).
                Responda perguntas incorporando a personalidade e estilo de linguagem de fala de um determinado campeão.
                Segue a pergunta, nome do campeão e sua respectiva lore (história):
                                
                """;

        return generativeAiApi.generateContent(objective, championContext);

    }
}
