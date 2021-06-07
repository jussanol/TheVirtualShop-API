package com.uadin.virtualShop.service.dto;

import lombok.Data;


@Data
public class ArticuloDTO {

    private Long id;
    private String titulo;
    private String tipoImagen;
    private byte[] imagen;
    private int precio;
    private boolean favorito;
    private int precioOferta;

    public ArticuloDTO() {
    }

    public ArticuloDTO(Long id, String titulo, String tipoImagen, byte[] imagen, int precio, boolean favorito, int precioOferta) {
        this.id = id;
        this.titulo = titulo;
        this.tipoImagen = tipoImagen;
        this.imagen = imagen;
        this.precio = precio;
        this.favorito = favorito;
        this.precioOferta = precioOferta;
    }
}
