package com.library.book.infrastructure.repositories;

import com.library.book.domain.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAuthorRepository extends JpaRepository <
    Author, Long> {




}
