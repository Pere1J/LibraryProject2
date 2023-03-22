package com.library.book.apiService.controllers;

import com.library.book.domain.dtos.BookRequest;
import com.library.book.domain.models.Book;
import com.library.book.domain.services.BookService;
import com.library.book.infrastructure.repositories.IAuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping

public class BookController {
    private final BookService bookService;
    private final IAuthorRepository authorRepository;

    public BookController(BookService bookService, IAuthorRepository authorRepository) {
        this.bookService = bookService;
        this.authorRepository = authorRepository;
    }


    @GetMapping("/books")
   ResponseEntity<List<Book>> getAll(){
       return ResponseEntity.ok(this.bookService.findAll());

    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id){
          return ResponseEntity.ok(this.bookService.getById(id));

    }
    @PostMapping("/books")
    public ResponseEntity<Book> create(@RequestBody BookRequest request){

        return ResponseEntity.ok(this.bookService.create(request));

    }
    @DeleteMapping("/books/{id}")
    public void deleteById(@PathVariable Long id){
         this.bookService.deleteById(id);
    }
}
