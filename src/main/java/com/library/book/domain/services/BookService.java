package com.library.book.domain.services;

import com.library.book.domain.dtos.BookRequest;
import com.library.book.domain.models.Book;
import com.library.book.infrastructure.repositories.IAuthorRepository;
import com.library.book.infrastructure.repositories.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService {

    private final IBookRepository bookRepository;
    private final AuthService authService;
    private final IAuthorRepository authorRepository;

    public BookService(IBookRepository bookRepository, AuthService authService, IAuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authService = authService;
        this.authorRepository = authorRepository;
    }
    public List<Book> findAll(){
        return this.bookRepository.findAll();
    }

    public Book getById(Long id) {
        //return this.bookRepository.findById(id).get();
    var bookOptional = this.bookRepository.findById(id);
    //no existe
    if (bookOptional.isEmpty()) throw new RuntimeException("Libro no encontrado");
    return bookOptional.get();
    }

    public Book create(Book book) {
        var author = this.authService.getAuthAuth();
        book.setAuthor(author);
        return this.bookRepository.save(book);
    }
    public Book create(BookRequest request) {
        var author = authorRepository.findById(request.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));


       // var author = this.authService.getAuthAuth();
        var book= new Book();
        book.setAuthor(author);
        book.setCoverUrl(request.getCoverUrl());
        book.setTitle(request.getTitle());
        book.setIsLoaned(request.getIsLoaned());
        //book.setAuthor(author);
        return this.bookRepository.save(book);
    }

    public void deleteById(Long id) {
         this.bookRepository.deleteById(id);
    }

    //public Book deleteById(Long id){
        //return this.bookRepository.deleteById(id).get();
    //}
}
