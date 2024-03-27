package me.dio.chatbotJava.IA.adapters.in;

import me.dio.chatbotJava.IA.domain.exception.ChampionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ChampionNotFoundException.class)
    public ApiError handleDomainException(ChampionNotFoundException domainError){
        return new ApiError(domainError.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ApiError handleDomainException(Exception domainError){
        return new ApiError("Essa não! Ocorreu um erro, estamos tentando resolver!");
    }


    public record ApiError(String message) { }
}
