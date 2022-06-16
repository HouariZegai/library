package com.houarizegai.library.controller;

import com.houarizegai.library.controller.rest.BooksApi;
import com.houarizegai.library.dto.BookCollectionDto;
import com.houarizegai.library.dto.BookDto;
import com.houarizegai.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequiredArgsConstructor
public class BookController implements BooksApi {

    private final BookService bookService;

    @Override
    public ResponseEntity<BookDto> createBook(BookDto bookDto) {
        var createdBook = bookService.createBook(bookDto);
        var location = ServletUriComponentsBuilder.fromCurrentRequest()
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
