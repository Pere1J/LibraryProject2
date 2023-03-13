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
}
