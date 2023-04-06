package com.library.book.apiService.controllers;

import com.library.book.domain.dtos.BookRequest;
import com.library.book.domain.models.Book;
import com.library.book.domain.services.BookService;
import com.library.book.infrastructure.repositories.IAuthorRepository;

import jakarta.persistence.OrderBy;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
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


   /* @GetMapping("/books")
   ResponseEntity<List<Book>> getAll(){
       return ResponseEntity.ok(this.bookService.findAll());
    }*/


    /////////////opción filter V V V V

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAll(@RequestParam(name = "title", required = false) String title) {

        List<Book> books;

        if (title != null) {
            books = bookService.findByTitleContainingIgnoreCase(title);
        } else {
            books = bookService.findAll();
        }
        //List ordenada alfabéticamente
        Collections.sort(books, Comparator.comparing(Book::getTitle));

        return ResponseEntity.ok(books);
    }
    ///////////////fin filter /////////////////////////


    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getById(@PathVariable Long id){
          return ResponseEntity.ok(this.bookService.getById(id));

    }
    @PostMapping("/books")
    //----> añadimos la necesidad de usuario autorizado
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Book> create(@RequestBody BookRequest request){

        return ResponseEntity.ok(this.bookService.create(request));

    }
    @DeleteMapping("/books/{id}")
    //----> añadimos la necesidad de usuario autorizado
    @PreAuthorize("hasAuthority('USER')")
    public void deleteById(@PathVariable Long id){
         this.bookService.deleteById(id);
    }

    @GetMapping("/books/isLoaned")
    public  ResponseEntity<List<Book>> getAllIsLoaned(){
        return  ResponseEntity.ok(this.bookService.getAllIsLoaned());
    }

    @PutMapping("/books/{id}")
    //----> añadimos la necesidad de usuario autorizado
    @PreAuthorize("hasAuthority('USER')")
    public void editIsLoaned(@PathVariable Long id){this.bookService.editIsLoaned(id);}



}
