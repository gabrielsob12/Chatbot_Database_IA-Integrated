package me.dio.chatbotJava.IA.domain.ports;

public interface GenerativeAiApi {

    String generateContent(String objective, String context);
}
