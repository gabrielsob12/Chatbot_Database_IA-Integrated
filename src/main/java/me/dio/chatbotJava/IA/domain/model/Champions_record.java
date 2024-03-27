package me.dio.chatbotJava.IA.domain.model;

public record Champions_record(
        Long id,
        String name,
        String role,
        String lore,
        String imageUrl
) {
    public String generateContextByQuestion(String question) {
        return """
            Pergunta: %s
            Nome do campeão: %s
            Função: %s
            Lore: %s
            """.formatted(question, this.name, this.role, this.lore);
    }
}

