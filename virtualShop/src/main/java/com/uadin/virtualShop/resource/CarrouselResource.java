package com.uadin.virtualShop.resource;

import com.uadin.virtualShop.service.ICarrouselService;
import com.uadin.virtualShop.service.dto.CarrouselDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CarrouselResource {

    private ICarrouselService carrouselService;

    public CarrouselResource(ICarrouselService carrouselService) {
        this.carrouselService = carrouselService;
    }

    @GetMapping("/carrousels")
    private List<CarrouselDTO> getAllCarrousel(){
        List<CarrouselDTO> carrousels = carrouselService.obtenerCarrousels();
        return carrousels;
    }

    @PostMapping("/carrousels")
    public CarrouselDTO postCarrousel(@RequestBody CarrouselDTO carrouselDTO){
        CarrouselDTO carrousel = this.carrouselService.save(carrouselDTO);
        return carrousel;
    }

    @PutMapping("/carrousels")
    public CarrouselDTO updateCarrousel(@RequestBody CarrouselDTO carrouselDTO){
        CarrouselDTO carrousel = this.carrouselService.save(carrouselDTO);
        return carrousel;
    }

    @GetMapping("/carrousel/{id}")
    public CarrouselDTO getCarrousel(@PathVariable Long id){
        return this.carrouselService.getCarrousel(id);
    }

    @DeleteMapping("/carrousel/{id}")
    public void deleteCarrousel(@PathVariable Long id){
        this.carrouselService.deteleCarrousel(id);
    }

}
