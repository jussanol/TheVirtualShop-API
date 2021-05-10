package com.uadin.virtualShop.service.impl;

import com.uadin.virtualShop.model.Articulo;
import com.uadin.virtualShop.repository.ArticuloRepository;
import com.uadin.virtualShop.service.IArticuloService;
import com.uadin.virtualShop.service.dto.ArticuloDTO;
import com.uadin.virtualShop.service.mapper.ModelMapperUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloService implements IArticuloService {

    private ArticuloRepository articuloRepository;

    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Override
    public List<ArticuloDTO> obtenerArticulos() {
        List<Articulo> articulos = this.articuloRepository.findAll();
        return ModelMapperUtils.mapAll(articulos, ArticuloDTO.class);
    }

    @Override
    public ArticuloDTO save(ArticuloDTO articuloDTO) {
        Articulo articulo = this.articuloRepository.save(ModelMapperUtils.map(articuloDTO, Articulo.class));
        return ModelMapperUtils.map(articulo, ArticuloDTO.class);
    }

    @Override
    public ArticuloDTO getArticulo(Long id) {
        Optional<Articulo> articulo = this.articuloRepository.findById(id);
        if(articulo.isPresent()){
            return ModelMapperUtils.map(articulo.get(), ArticuloDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public void delete(Long id) {
        this.articuloRepository.deleteById(id);
    }
}
