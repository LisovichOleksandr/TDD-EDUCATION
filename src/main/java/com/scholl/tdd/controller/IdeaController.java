package com.scholl.tdd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class IdeaController {

    @GetMapping()
    public String getHello() {
        return "Hello world";
    }
}
