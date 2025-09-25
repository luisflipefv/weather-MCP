package com.tempobot.previsao_tempo_bot.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient; // O import está correto
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final ChatClient chatClient;

    @GetMapping("/ask")
    public String askWeather(@RequestParam(defaultValue = "Como está o tempo hoje em Vitória - ES?") String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}