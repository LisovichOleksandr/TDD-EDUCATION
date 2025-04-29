package com.scholl.tdd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scholl.tdd.entity.Book;
import com.scholl.tdd.service.BookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private BookService bookService;

    @Test
    void getBooks_shouldReturnListBooks() throws Exception {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Lisovych", "In free"));
        books.add(new Book("Shevchenko", "Kateryna"));

        Mockito.when(bookService.getAllBooks()).thenReturn(books);

        this.mockMvc.perform(get("/api/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", is(2)));
    }

    @Test
    void saveBook_shouldSaveNewBook_whenPostRequest() throws Exception {
        Book book = new Book("Moaecz", "In free time");
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonRequest = objectMapper.writeValueAsString(book);

        Mockito.when(bookService.save(any(Book.class))).thenReturn(book);

        this.mockMvc.perform(post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonRequest))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.author").value(book.getAuthor()));
    }

}