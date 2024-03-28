package me.dio.chatbotJava.IA.adapters.out;

import feign.FeignException;
import feign.RequestInterceptor;
import me.dio.chatbotJava.IA.domain.ports.GenerativeAiApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@ConditionalOnProperty(name = "generative-ai.provider", havingValue = "OPENAI", matchIfMissing = true)
@FeignClient(name = "openAiChatGptApi", url = "${openai.base-url}", configuration = OpenAiChatGptApi.Config.class)
public interface OpenAiChatGptApi extends GenerativeAiApi {

    @PostMapping("/v1/chat/completions")
    OpenAiCompletionResponse chatCompletion(OpenAiChatCompletionRequest request);

    @Override
    default String generateContent(String objective, String context) {
        String model = "gpt-3.5-turbo";
        List<Message> messages = List.of(
                new Message("system", objective),
                new Message("user", context)
        );

        OpenAiChatCompletionRequest request = new OpenAiChatCompletionRequest(model, messages);

        try {
            OpenAiCompletionResponse response = chatCompletion(request);

            return response.choices().getFirst().message().content();
        } catch (FeignException httpErrors) {
            return "Deu Ruim! Erro de comunicação com a API da Open AI";
        } catch (Exception unexpectedError) {
            return "Deu mais ruim ainda! O retorno da API da OpenAI não contém os dados esperados.";
        }


    }

    record OpenAiChatCompletionRequest(String model, List<Message> messages) { }
    record Message(String role, String content) { }
    record OpenAiCompletionResponse(List<Choice> choices) { }
    record Choice(Message message) { }

    class Config {
        @Bean
        public RequestInterceptor apiKeyRequestInterceptor(@Value("${openai.api-key}")String apiKey) {
            return requestTemplate -> requestTemplate.header(
                    HttpHeaders.AUTHORIZATION, "Bearer %s".formatted(apiKey));
        }
    }
}
