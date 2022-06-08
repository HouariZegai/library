package com.houarizegai.bookapi.mapper;

import com.houarizegai.bookapi.dto.BookCollectionDto;
import com.houarizegai.bookapi.dto.BookDto;
import com.houarizegai.bookapi.domain.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.data.domain.Page;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface BookMapper {

    default BookCollectionDto toBooksDtos(Page<Book> bookPage) {
        return new BookCollectionDto()
                .books(bookPage.getContent().stream().map(this::toBookDto).collect(Collectors.toList()))
                .totalRecords((int) bookPage.getTotalElements());
    }

    @Mapping(target = "id", expression = "java(com.houarizegai.bookapi.util.StringUtil.uuidToStringSafe(book.getId()))")
    BookDto toBookDto(Book book);

    @Mapping(target = "id", expression = "java(com.houarizegai.bookapi.util.StringUtil.stringToUuidSafe(bookDto.getId()))")
    Book toBook(BookDto bookDto);
}
