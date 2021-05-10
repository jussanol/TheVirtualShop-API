package com.uadin.virtualShop.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="carrousel")
public class Carrousel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "imagen")
    @Lob
    private byte[] imagen;

    public Carrousel() {
    }

    public Carrousel(Long id, String title, byte[] imagen) {
        this.id = id;
        this.title = title;
        this.imagen = imagen;
    }
}
