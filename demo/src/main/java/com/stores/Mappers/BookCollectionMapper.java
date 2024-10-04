package com.stores.Mappers;

import org.mapstruct.Mapper;

import com.stores.DTOs.dto.BookCollectionDTO;
import com.stores.Entities.BookCollection;

@Mapper(componentModel = "spring")
public interface BookCollectionMapper {
    BookCollectionDTO toDto(BookCollection book);
    BookCollection toEntity(BookCollectionDTO bookDTO);
}
