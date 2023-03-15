package com.library.book.domain.services;

import com.library.book.domain.models.Book;
import com.library.book.infrastructure.repositories.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService {

    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
}
