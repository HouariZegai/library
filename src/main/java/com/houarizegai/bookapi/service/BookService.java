package com.houarizegai.bookapi.service;

import com.houarizegai.bookapi.domain.dto.BookCollectionDto;
import com.houarizegai.bookapi.domain.dto.BookDto;

public interface BookService {

    BookDto createBook(BookDto bookDto);

    BookCollectionDto getBooks(Integer offset, Integer limit);
}
