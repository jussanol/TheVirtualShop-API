package com.uadin.virtualShop.service.impl;

import com.uadin.virtualShop.model.Carrousel;
import com.uadin.virtualShop.repository.CarrouselRepository;
import com.uadin.virtualShop.service.ICarrouselService;
import com.uadin.virtualShop.service.dto.CarrouselDTO;
import com.uadin.virtualShop.service.mapper.ModelMapperUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarrouselService implements ICarrouselService {

    private CarrouselRepository carrouselRepository;

    public CarrouselService(CarrouselRepository carrouselRepository) {
        this.carrouselRepository = carrouselRepository;
    }

    @Override
    public List<CarrouselDTO> obtenerCarrousels() {
        List<Carrousel> carrousels = this.carrouselRepository.findAll();
        return ModelMapperUtils.mapAll(carrousels, CarrouselDTO.class);
    }

    @Override
    public CarrouselDTO save(CarrouselDTO carrouselDTO) {
        Carrousel carrousel = this.carrouselRepository.save(ModelMapperUtils.map(carrouselDTO, Carrousel.class));
        return ModelMapperUtils.map(carrousel, CarrouselDTO.class);
    }

    @Override
    public CarrouselDTO getCarrousel(Long id) {
        Optional<Carrousel> carrousel = this.carrouselRepository.findById(id);
        if(carrousel.isPresent()){
            return ModelMapperUtils.map(carrousel.get(), CarrouselDTO.class);
        }else {
            return null;
        }
    }

    @Override
    public void deteleCarrousel(Long id) {
        this.carrouselRepository.deleteById(id);
    }
}
