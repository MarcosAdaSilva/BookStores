package com.stores.Services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stores.DTOs.dto.CategoriaDTO;
import com.stores.Entities.Categoria;
import com.stores.Mappers.CategoriaMapper;
import com.stores.Repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    public CategoriaDTO criarCategoria(@Valid CategoriaDTO categoriaDTO) {
        if (categoriaRepository.existsByNome(categoriaDTO.getNome())) {
            throw new IllegalArgumentException("Categoria já existente.");
        }
        Categoria categoria = categoriaMapper.toEntity(categoriaDTO);
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        return categoriaMapper.toDto(categoriaSalva);
    }

    public CategoriaDTO atualizarCategoria(Long id, @Valid CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada."));
        categoria.setNome(categoriaDTO.getNome());
        return categoriaMapper.toDto(categoriaRepository.save(categoria));
    }

    public void deletarCategoria(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new EntityNotFoundException("Categoria não encontrada.");
        }
        categoriaRepository.deleteById(id);
    }

    public List<CategoriaDTO> listarCategorias() {
        return categoriaRepository.findAll()
                .stream()
                .map(categoriaMapper::toDto)
                .collect(Collectors.toList());
    }
}

