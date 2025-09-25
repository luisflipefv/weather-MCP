package com.tempobot.previsao_tempo_bot.Service;

import com.tempobot.previsao_tempo_bot.DTOs.WeatherRequest;
import com.tempobot.previsao_tempo_bot.DTOs.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.client.RestTemplate;

import java.util.function.Function;

@Configuration
public class WeatherService {

    @Value("${app.api.weather.key}")
    private String weatherApiKey;

    @Bean
    @Description("Obtém a previsão do tempo atual para uma cidade específica")
    public Function<WeatherRequest, WeatherResponse> weatherFunction(){
        return request -> {
            RestTemplate restTemplate = new RestTemplate();
            String url = String.format(
                    "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric&lang=pt_br",
                    request.city(), weatherApiKey
            );
            return restTemplate.getForObject(url, WeatherResponse.class);
        };
    }
}