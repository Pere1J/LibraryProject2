package com.library.book.infrastructure.repositories;

import com.library.book.domain.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {
    List<Book> findByIsLoanedFalseOrderByTitleAsc();


}
