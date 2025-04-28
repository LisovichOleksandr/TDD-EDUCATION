package com.scholl.tdd.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(IdeaController.class)
class WebMvcIdeaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getHello_shouldReturnStringAnd200() throws Exception {

        this.mockMvc.perform(get("/api"))
                .andExpect(status().isOk())
                .andExpect(content().string(Matchers.containsString("Hello world")));
    }
 }