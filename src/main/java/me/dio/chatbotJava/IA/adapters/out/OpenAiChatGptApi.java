package me.dio.chatbotJava.IA.adapters.out;

import me.dio.chatbotJava.IA.domain.ports.GenerativeAiApi;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "openAiChatGptApi", url = "https://api.openai.com")
public interface OpenAiChatGptApi extends GenerativeAiApi {

    @PostMapping("/v1/chat/completions")
    OpenAiCompletionResponse chatCompletion(OpenAiChatCompletionRequest request);

    @Override
    default String GenerateAiApi(String objective, String context) {
        String model = "gpt-3.5-turbo";
        List<Message> messages = List.of(
                new Message("system", objective),
                new Message("user", context)
        );

        OpenAiChatCompletionRequest request = new OpenAiChatCompletionRequest(model, messages);

        OpenAiCompletionResponse response = chatCompletion(request);

        return response.choices().getFirst().message().content();
    }

    record OpenAiChatCompletionRequest(String model, List<Message> messages) { }
    record Message(String role, String content) { }
    record OpenAiCompletionResponse(List<Choice> choices) { }
    record Choice(Message message) { }

}
