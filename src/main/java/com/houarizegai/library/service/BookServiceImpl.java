package com.houarizegai.library.service;

import com.houarizegai.library.dto.BookCollectionDto;
import com.houarizegai.library.dto.BookDto;
import com.houarizegai.library.mapper.BookMapper;
import com.houarizegai.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto createBook(BookDto bookDto) {
        var book = bookRepository.save(bookMapper.toBook(bookDto));
        return bookMapper.toBookDto(book);
    }

    @Override
    public BookCollectionDto getBooks(Integer offset, Integer limit) {
        var books = bookRepository.findAll(PageRequest.of(offset, limit));
        return bookMapper.toBooksDtos(books);
    }
}
