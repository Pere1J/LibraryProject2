package com.library.book.domain.services;

import com.library.book.domain.models.Author;
import com.library.book.domain.models.Book;
import com.library.book.infrastructure.repositories.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService {

    private final IBookRepository bookRepository;
    private final AuthService authService;

    public BookService(IBookRepository bookRepository, AuthService authService) {
        this.bookRepository = bookRepository;
        this.authService = authService;
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

    public void deleteById(Long id) {
         this.bookRepository.deleteById(id);
    }

    //public Book deleteById(Long id){
        //return this.bookRepository.deleteById(id).get();
    //}
}
