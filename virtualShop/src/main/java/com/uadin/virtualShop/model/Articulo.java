package com.uadin.virtualShop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table (name = "articulo")
public class Articulo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "tipo_imagen")
    private String tipoImagen;

    @Column(name = "imagen", nullable = false, unique = true)
    @Lob
    private byte[] imagen;

    @Column(name = "precio", nullable = false)
    private int precio;

    @Column(name = "favorito")
    private boolean favorito;

    @Column(name = "precio_oferta")
    private int precioOferta;

    public Articulo() {
    }

    public Articulo(Long id, String nombre, String categoria, String tipoImagen, byte[] imagen, int precio, boolean favorito, int precioOferta) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.tipoImagen = tipoImagen;
        this.imagen = imagen;
        this.precio = precio;
        this.favorito = favorito;
        this.precioOferta = precioOferta;
    }
}
