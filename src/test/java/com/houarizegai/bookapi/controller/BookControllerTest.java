package com.houarizegai.bookapi.controller;

import com.houarizegai.bookapi.dto.BookDto;
import com.houarizegai.bookapi.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = BookController.class)
class BookControllerTest {

    @Autowired
    private BookController bookController;

    @MockBean
    private BookService bookService;

    private final BookDto bookDto = new BookDto()
            .id(UUID.randomUUID().toString())
            .title("Effective Java")
            .isbn("0134685997")
            .addAuthorsItem("Joshua Bloch");

    @Test
    void shouldSaveAndReturn() {
        when(bookService.createBook(bookDto)).thenReturn(bookDto);
        var createdBookDto = bookController.createBook(bookDto).getBody();
        Assertions.assertEquals(createdBookDto, bookDto);
    }
}