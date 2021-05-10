package com.uadin.virtualShop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "banner")
public class Banner {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "descripcion")
    private String descripcion;

    @Column (name = "tipo_imagen")
    private String tipoImagen;

    @Column (name = "imagen")
    @Lob
    private byte[] imagen;

    public Banner() {
    }

    public Banner(Long id, String titulo, String descripcion, String tipoImagen, byte[] imagen) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.tipoImagen = tipoImagen;
        this.imagen = imagen;
    }
}
