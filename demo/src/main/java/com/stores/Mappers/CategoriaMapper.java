package com.stores.Mappers;

import org.mapstruct.Mapper;

import com.stores.DTOs.dto.CategoriaDTO;
import com.stores.Entities.Categoria;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {
    CategoriaDTO toDto(Categoria categoria);
    Categoria toEntity(CategoriaDTO categoriaDTO);
}
