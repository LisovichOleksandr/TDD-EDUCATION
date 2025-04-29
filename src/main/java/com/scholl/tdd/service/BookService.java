package com.scholl.tdd.service;

import com.scholl.tdd.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookService {

    private List<Book> books = new ArrayList<>();

    {
        books.add(new Book("Lisovych", "In free"));
        books.add(new Book("Shevchenko", "Kateryna"));
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book save(Book book) {
        books.add(book);
        return book;
    }
}
