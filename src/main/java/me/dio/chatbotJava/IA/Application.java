package me.dio.chatbotJava.IA;

import me.dio.chatbotJava.IA.application.AskChampionUseCase;
import me.dio.chatbotJava.IA.application.ListChampionsUseCase;
import me.dio.chatbotJava.IA.domain.ports.ChampionsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ListChampionsUseCase provideListChampionsUseCase (ChampionsRepository repository){
		return new ListChampionsUseCase(repository);
	}
	@Bean
	public AskChampionUseCase provideAskChampionsUseCase (ChampionsRepository repository){
		return new AskChampionUseCase(repository);
	}
}
