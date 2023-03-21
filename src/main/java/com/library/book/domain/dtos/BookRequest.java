package com.library.book.domain.dtos;


import lombok.Data;

@Data
public class BookRequest {

    private String title;
    private String coverUrl;
    private Boolean isLoaned;
    private Long authorId;
}
