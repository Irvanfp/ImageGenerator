package com.image.generator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.image.generator.model.RequestModel;
import com.image.generator.service.GenerateService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class GeneratorController {
    private final GenerateService generateService;

    @RequestMapping(value = "generator", method = RequestMethod.POST)
    public String generate(@RequestBody RequestModel request) {
        String prompt =request.getPrompt();
        return generateService.generate(prompt);
    }
}
