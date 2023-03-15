package com.library.book.apiService.controllers;

import com.library.book.domain.models.Book;
import com.library.book.domain.services.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping

public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/books")
   ResponseEntity<List<Book>> getAll(){
       return ResponseEntity.ok(this.bookService.findAll());

    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id){
          return ResponseEntity.ok(this.bookService.getById(id));

    }
}
