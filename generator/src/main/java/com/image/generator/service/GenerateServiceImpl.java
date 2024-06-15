package com.image.generator.service;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.image.generator.config.WebClientConfig;

import reactor.core.publisher.Mono;

@Service
public class GenerateServiceImpl implements GenerateService {
    
    private final WebClientConfig webClientConfig = new WebClientConfig();
    

    public String generate(String prompt) {
        String result = "";

        ResponseEntity<String> response = null;

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "dall-e-3");
        requestBody.put("prompt", prompt);
        requestBody.put("n", 1);
        requestBody.put("size", "1792x1024");
        
        WebClient webClient = webClientConfig.CustomWebClientBuilder();
        Mono<ResponseEntity<String>> responseMono = webClient
                .post()
                .uri("/images/generations")
                .bodyValue(requestBody)
                .retrieve().toEntity(String.class);
        response = responseMono.block();
        try{
            JSONObject resultJson = new JSONObject(response.getBody());
            result = resultJson.getJSONArray("data").getJSONObject(0).getString("url");
        }catch(Exception e){
            e.printStackTrace();
        }

        return result;
    }
}
