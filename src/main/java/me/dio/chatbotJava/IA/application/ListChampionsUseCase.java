package me.dio.chatbotJava.IA.application;

import me.dio.chatbotJava.IA.domain.model.Champions_record;
import me.dio.chatbotJava.IA.domain.ports.ChampionsRepository;

import java.util.List;

public record ListChampionsUseCase (ChampionsRepository repository){

    public List<Champions_record> findAll(){
        return repository.findAll();
    }

}
