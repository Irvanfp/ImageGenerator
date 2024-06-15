package com.image.generator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${open.ai.key}")
    private String key;
    @Bean
    public WebClient CustomWebClientBuilder() {
        return WebClient.builder().baseUrl("https://api.openai.com/v1").defaultHeader("Authorization", "Bearer ", key).build();
    }

    @Bean
    public RestClient.Builder restClient() {
        return RestClient.builder();
    }

}
