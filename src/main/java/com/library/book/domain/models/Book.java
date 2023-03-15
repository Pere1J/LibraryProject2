package com.library.book.domain.models;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="books")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private boolean isLoaned;
    private String coverUrl;
    @ManyToOne(cascade= CascadeType.PERSIST)
    @JoinColumn(name = "author_id")
    private Author author;



}
