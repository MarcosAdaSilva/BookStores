package com.stores.BookServiceTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stores.DTOs.dto.CategoriaDTO;
import com.stores.Entities.Categoria;
import com.stores.Mappers.CategoriaMapper;
import com.stores.Repository.CategoriaRepository;
import com.stores.Services.CategoriaService;

public class CategoriaServiceTest {

    @InjectMocks
    private CategoriaService categoriaService;

    @Mock
    private CategoriaRepository categoriaRepository;

    @Mock
    private CategoriaMapper categoriaMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

  

    @Test
    public void testCriarCategoriaJaExistente() {
        CategoriaDTO categoriaDTO = new CategoriaDTO("Romance");

        when(categoriaRepository.existsByNome(categoriaDTO.getNome())).thenReturn(true);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            categoriaService.criarCategoria(categoriaDTO);
        });

        String expectedMessage = "Categoria já existente.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        verify(categoriaRepository, never()).save(any(Categoria.class));
    }

    

    @Test
    public void testAtualizarCategoriaNaoExistente() {
        Long id = 1L;
        CategoriaDTO categoriaDTO = new CategoriaDTO("Aventura");

        when(categoriaRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> {
            categoriaService.atualizarCategoria(id, categoriaDTO);
        });

        verify(categoriaRepository, never()).save(any(Categoria.class));
    }

    @Test
    public void testDeletarCategoriaSucesso() {
        Long id = 1L;

        when(categoriaRepository.existsById(id)).thenReturn(true);

        categoriaService.deletarCategoria(id);

        verify(categoriaRepository, times(1)).deleteById(id);
    }

    @Test
    public void testDeletarCategoriaNaoExistente() {
        Long id = 1L;

        when(categoriaRepository.existsById(id)).thenReturn(false);

        assertThrows(EntityNotFoundException.class, () -> {
            categoriaService.deletarCategoria(id);
        });

        verify(categoriaRepository, never()).deleteById(anyLong());
    }

   
    @Test
    public void testListarCategoriasVazio() {
        when(categoriaRepository.findAll()).thenReturn(Collections.emptyList());

        List<CategoriaDTO> result = categoriaService.listarCategorias();

        assertTrue(result.isEmpty());
        verify(categoriaRepository, times(1)).findAll();
    }
    
    @Test
    public void testCriarCategoriaFalhaMapeamento() {
        CategoriaDTO categoriaDTO = new CategoriaDTO("Romance");

        when(categoriaMapper.toEntity(categoriaDTO)).thenThrow(new RuntimeException("Falha no mapeamento"));

        assertThrows(RuntimeException.class, () -> {
            categoriaService.criarCategoria(categoriaDTO);
        });

        verify(categoriaRepository, never()).save(any(Categoria.class));
    }


}
