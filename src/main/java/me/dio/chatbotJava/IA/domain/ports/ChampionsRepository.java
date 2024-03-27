package me.dio.chatbotJava.IA.domain.ports;

import me.dio.chatbotJava.IA.domain.model.Champions_record;

import java.util.List;
import java.util.Optional;

public interface ChampionsRepository {
    List<Champions_record> findAll();

    Optional<Champions_record> findById(Long id);
}
