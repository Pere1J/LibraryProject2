package com.library.book.domain.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="authors")
@Data

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;
    private String nacionalidad;

}
