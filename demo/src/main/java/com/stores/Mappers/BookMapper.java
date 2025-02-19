package com.stores.Mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.stores.DTOs.dto.BookDTO;
import com.stores.Entities.Book;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "isbn", source = "isbn")
    Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);
}
