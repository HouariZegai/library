package com.houarizegai.bookapi.service;

import com.houarizegai.bookapi.dto.BookDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(value = SpringExtension.class)
@SpringBootTest
class BookServiceIT {

    @Autowired
    private BookServiceImpl bookService;

    private final BookDto bookDto = new BookDto()
            .title("Effective Java")
            .isbn("0134685997")
            .authors(List.of("Joshua Bloch"));

    @Test
    void shouldCreateBook() {
        var savedBookDto = bookService.createBook(bookDto);
        assertEquals(savedBookDto.getTitle(), bookDto.getTitle());
        assertEquals(savedBookDto.getIsbn(), bookDto.getIsbn());
        assertEquals(savedBookDto.getAuthors(), bookDto.getAuthors());
    }
}