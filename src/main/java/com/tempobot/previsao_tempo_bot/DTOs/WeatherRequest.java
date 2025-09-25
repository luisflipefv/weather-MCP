package com.tempobot.previsao_tempo_bot.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;

public record WeatherRequest(
        @JsonProperty("city") String city
) {}
