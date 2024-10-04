package com.stores.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stores.Entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    boolean existsByNome(String nome);
}
