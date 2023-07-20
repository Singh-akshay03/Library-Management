package com.librarymanagement.controllers;

import com.librarymanagement.models.Book;
import com.librarymanagement.request.BookCreateRequest;
import com.librarymanagement.services.BookFilterType;
import com.librarymanagement.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;
    @PostMapping("/book")
    public void createBook(@Valid @RequestBody BookCreateRequest bookCreateRequest){
        bookService.create(bookCreateRequest);
    }

    @GetMapping("/books/search")
    public List<Book> findBooks(@RequestParam("filterType") BookFilterType bookFilterType,
                                @RequestParam("value") String value){
        return bookService.find(bookFilterType,value);
    }
}
