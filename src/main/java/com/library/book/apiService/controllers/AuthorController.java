package com.library.book.apiService.controllers;

import com.library.book.domain.models.Author;
import com.library.book.domain.services.AuthService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@CrossOrigin(origins = "*")
@RequestMapping("/authors")
public class AuthorController {
    private final AuthService authService;

    public AuthorController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public List<Author> findAllAuthors(){
        return authService.findAllAuthors();
    }
}
