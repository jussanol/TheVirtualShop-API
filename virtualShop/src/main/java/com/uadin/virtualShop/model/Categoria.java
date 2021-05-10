package com.uadin.virtualShop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "tipo_imagen")
    private String tipoImagen;

    @Column(name = "imagen")
    @Lob
    private byte[] imagen;

    public Categoria() {
    }

    public Categoria(Long id, String titulo, String categoria, String tipoImagen, byte[] imagen) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.tipoImagen = tipoImagen;
        this.imagen = imagen;
    }
}
