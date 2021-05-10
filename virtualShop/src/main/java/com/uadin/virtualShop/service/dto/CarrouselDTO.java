package com.uadin.virtualShop.service.dto;

import lombok.Data;

@Data
public class CarrouselDTO {

    private Long id;
    private String title;
    private byte[] imagen;

    public CarrouselDTO() {
    }

    public CarrouselDTO(Long id, String title, byte[] imagen) {
        this.id = id;
        this.title = title;
        this.imagen = imagen;
    }
}
