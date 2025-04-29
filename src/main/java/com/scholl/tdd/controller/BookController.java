package com.scholl.tdd.controller;

import com.scholl.tdd.entity.Book;
import com.scholl.tdd.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getAllBooks();
    }

    @PostMapping
    public ResponseEntity<Book> saveBook(@RequestBody Book requestBook) {
        Book savedBook = bookService.save(requestBook);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Custom-Header", "value")
                .body(savedBook);

    }
}
