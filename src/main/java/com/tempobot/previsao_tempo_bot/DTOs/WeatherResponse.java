package com.tempobot.previsao_tempo_bot.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record WeatherResponse(
        @JsonProperty("main") Main main,
        @JsonProperty("weather") List<Weather> weather,
        @JsonProperty("name") String name
) {
    public record Main(double temp) {}

    public record Weather(@JsonProperty("description") String description) {}
}