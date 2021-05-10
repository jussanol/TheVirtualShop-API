package com.uadin.virtualShop.service.dto;

import lombok.Data;

@Data
public class BannerDTO {

    private Long id;
    private String titulo;
    private String descripcion;
    private String tipoImagen;
    private byte[] imagen;

    public BannerDTO() {
    }

    public BannerDTO(Long id, String titulo, String descripcion, String tipoImagen, byte[] imagen) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipoImagen = tipoImagen;
        this.imagen = imagen;
    }
}
