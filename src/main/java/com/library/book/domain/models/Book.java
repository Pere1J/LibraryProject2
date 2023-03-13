package com.library.book.domain.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name="books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private UUID uuid;
    private boolean isLoaned;
    private String author;
    private String coverUrl;


}
