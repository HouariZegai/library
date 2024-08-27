package com.houarizegai.library.service;

import com.houarizegai.library.domain.Book;
import com.houarizegai.library.dto.BookCollectionDto;
import com.houarizegai.library.dto.BookDto;
import com.houarizegai.library.mapper.BookMapper;
import com.houarizegai.library.repository.BookRepository;
import com.houarizegai.library.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(value = SpringExtension.class)
class BookServiceTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @Mock
    private BookRepository bookRepository;
    @Mock
    private BookMapper bookMapper;

    private final Book book = Book.builder()
            .id(UUID.randomUUID())
            .title("Effective Java")
            .isbn("0134685997")
            .authors(List.of("Joshua Bloch"))
            .build();

    private final BookDto bookDto = new BookDto()
            .id(book.getId().toString())
            .title(book.getTitle())
            .isbn(book.getIsbn())
            .authors(book.getAuthors());

    private final Page<Book> books = new PageImpl<>(List.of(book));
    private final BookCollectionDto bookCollectionDto = new BookCollectionDto()
            .books(List.of(bookDto))
            .totalRecords((int) books.getTotalElements());

    @Test
    void shouldCreateBook() {
        when(bookRepository.save(any())).thenReturn(book);
        when(bookMapper.toBooksDtos(books)).thenReturn(bookCollectionDto);

        var bookDto = bookMapper.toBookDto(book);
        var savedBookDto = bookService.createBook(bookDto);
        assertEquals(savedBookDto, bookDto);
    }

    @Test
    void shouldGetBooksList() {
        var offset = 0;
        var limit = 1;
        when(bookRepository.findAll(PageRequest.of(offset, limit))).thenReturn(books);
        when(bookMapper.toBooksDtos(any())).thenReturn(bookCollectionDto);

        var bookCollectionDtoResponse = bookService.getBooks(offset, limit);
        assertEquals(bookCollectionDtoResponse, bookCollectionDto);
    }
}