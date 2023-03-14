package com.library.book.apiService.controllers;

import com.library.book.domain.models.Book;
import com.library.book.domain.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")

public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
   ResponseEntity<List<Book>> getAll(){
       return ResponseEntity.ok(this.bookService.findAll());

    }
}
