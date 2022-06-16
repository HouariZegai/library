package com.houarizegai.library.service;

import com.houarizegai.library.dto.BookCollectionDto;
import com.houarizegai.library.dto.BookDto;

public interface BookService {

    BookDto createBook(BookDto bookDto);

    BookCollectionDto getBooks(Integer offset, Integer limit);
}
