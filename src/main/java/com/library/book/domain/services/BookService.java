package com.library.book.domain.services;

import com.library.book.domain.dtos.BookRequest;
import com.library.book.domain.models.Book;
import com.library.book.infrastructure.repositories.IAuthorRepository;
import com.library.book.infrastructure.repositories.IBookLoanedRepository;
import com.library.book.infrastructure.repositories.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BookService {

    private final IBookRepository bookRepository;
    private final AuthorService authorService;
    private final IAuthorRepository authorRepository;
    private final IBookLoanedRepository bookLoanedRepository;

    public BookService(IBookRepository bookRepository, AuthorService authorService, IAuthorRepository authorRepository, IBookLoanedRepository bookLoanedRepository) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.authorRepository = authorRepository;
        this.bookLoanedRepository = bookLoanedRepository;
    }
    public List<Book> findAll(){return this.bookRepository.findAll();
    }



    public Book getById(Long id) {
        //return this.bookRepository.findById(id).get();
    var bookOptional = this.bookRepository.findById(id);
    //no existe
    if (bookOptional.isEmpty()) throw new RuntimeException("Libro no encontrado");
    return bookOptional.get();
    }

    /*public Book create(Book book) {
        var author = this.authService.getAuthAuth();
        book.setAuthor(author);
        return this.bookRepository.save(book);
    }*/
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

    public List<Book> getAllIsLoaned(){
         return this.bookRepository.findByIsLoanedFalseOrderByTitleAsc();
    }


    public void editIsLoaned(long id){

       //obtenemos el book
        Book bookToEdit = this.bookRepository.findById(id).orElseThrow(()->new RuntimeException("book not found"));
        //if (bookToEdit.getIsLoaned()) {
           // bookToEdit.setIsLoaned(false);
        //}else
        //{bookToEdit.setIsLoaned(true);}


        bookToEdit.setIsLoaned(!bookToEdit.getIsLoaned());

        this.bookRepository.save(bookToEdit);

         }


}
