package com.library.book.infrastructure.repositories;

import com.library.book.domain.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  IBookLoanedRepository extends JpaRepository<Book,  Boolean> {


}
