package me.dio.chatbotJava.IA.domain.exception;

public class ChampionNotFoundException extends RuntimeException {
    public ChampionNotFoundException(Long championId) {
        super("champion %d not found.".formatted(championId));
    }
}
