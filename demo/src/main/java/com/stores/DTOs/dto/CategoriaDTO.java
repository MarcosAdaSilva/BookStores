package com.stores.DTOs.dto;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

    private Long id; 

    @NotBlank(message = "O nome da categoria é obrigatório.")
    private String nome;

    public CategoriaDTO() {}

    public CategoriaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDTO(String string) {

	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
