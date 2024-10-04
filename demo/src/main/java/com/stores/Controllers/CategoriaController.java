package com.stores.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stores.DTOs.dto.CategoriaDTO;
import com.stores.Services.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
@Validated
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody @Valid CategoriaDTO categoriaDTO) {
        CategoriaDTO novaCategoria = categoriaService.criarCategoria(categoriaDTO);
        return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long id, 
                                                           @RequestBody @Valid CategoriaDTO categoriaDTO) {
        CategoriaDTO categoriaAtualizada = categoriaService.atualizarCategoria(id, categoriaDTO);
        return ResponseEntity.ok(categoriaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> listarCategorias() {
        List<CategoriaDTO> categorias = categoriaService.listarCategorias();
        return ResponseEntity.ok(categorias);
    }
}
