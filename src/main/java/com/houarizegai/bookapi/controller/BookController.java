package com.houarizegai.bookapi.controller;

import com.houarizegai.bookapi.domain.dto.BookCollectionDto;
import com.houarizegai.bookapi.domain.dto.BookDto;
import com.houarizegai.bookapi.rest.resource.BooksApi;
import com.houarizegai.bookapi.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class BookController implements BooksApi {

    private final BookService bookService;

    @Override
    public ResponseEntity<BookDto> createBook(BookDto bookDto) {
        var createdBook = bookService.createBook(bookDto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdBook.getId())
                .toUri();

        return ResponseEntity.created(location).body(createdBook);
    }

    @Override
    public ResponseEntity<BookCollectionDto> getBooks(Integer offset, Integer limit) {
        var books = bookService.getBooks(offset, limit);
        return ResponseEntity.ok(books);
    }
}
