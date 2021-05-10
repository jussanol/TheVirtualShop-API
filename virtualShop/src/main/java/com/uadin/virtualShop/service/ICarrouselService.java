package com.uadin.virtualShop.service;

import com.uadin.virtualShop.service.dto.CarrouselDTO;

import java.util.List;

public interface ICarrouselService {

    List<CarrouselDTO> obtenerCarrousels();

    CarrouselDTO save(CarrouselDTO carrouselDTO);

    CarrouselDTO getCarrousel(Long id);

    void deteleCarrousel(Long id);
}
