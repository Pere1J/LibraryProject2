package com.library.book.domain.services;

import com.library.book.domain.models.Author;
import com.library.book.infrastructure.repositories.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private IAuthorRepository authorRepository;

    //Author getAuthAuth(){
      //  return this.authorRepository.findById(1L).get();

    //};

    public List<Author> findAllAuthors(){
        return authorRepository.findAll();
    }

    public Author create(Author author) {
        return this.authorRepository.save(author);
    }
}
