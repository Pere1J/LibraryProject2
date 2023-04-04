package com.library.book.apiService.controllers;

import com.library.book.domain.models.Author;
import com.library.book.domain.services.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

    @RestController
    @CrossOrigin(origins = "*")
    @RequestMapping("/authors")
    public class AuthorController {
        private final AuthorService authorService;

        public AuthorController(AuthorService authorService) {
            this.authorService = authorService;
        }

        /*@GetMapping
        public List<Author> findAllAuthors(){
            return authorService.findAllAuthors();
        }*/
        //Lista ordenada alfabéticamente//
        @GetMapping
        public List<Author> findAllAuthors(){
            List <Author> authors = authorService.findAllAuthors();
            Collections.sort(authors, Comparator.comparing(Author::getName));
            return authors;}
        //fin lista alf./////////

    @PostMapping ("/newAuthor")
    public ResponseEntity<Author> create(@RequestBody Author author){ return ResponseEntity.ok(
            this.authorService.create(author));
    }

}
