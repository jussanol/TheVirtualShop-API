package com.uadin.virtualShop.service.dto;

import lombok.Data;

@Data
public class CategoriaDTO {
    private Long id;
    private String titulo;
    private String categoria;
    private String tipoImagen;
    private byte[] imagen;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Long id, String titulo, String categoria, String tipoImagen, byte[] imagen) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.tipoImagen = tipoImagen;
        this.imagen = imagen;
    }
}
