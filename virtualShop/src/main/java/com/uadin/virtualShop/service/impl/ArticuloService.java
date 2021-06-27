package com.uadin.virtualShop.service.impl;

import com.uadin.virtualShop.model.Articulo;
import com.uadin.virtualShop.repository.ArticuloRepository;
import com.uadin.virtualShop.repository.specs.ArticuloSpecification;
import com.uadin.virtualShop.repository.specs.SearchCriteria;
import com.uadin.virtualShop.service.IArticuloService;
import com.uadin.virtualShop.service.dto.ArticuloDTO;
import com.uadin.virtualShop.service.mapper.ModelMapperUtils;
import org.dom4j.rule.Mode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<ArticuloDTO> obtenerArticulosPaginado(Pageable pageable) {
        Page<Articulo> articulos = this.articuloRepository.findAll(pageable);
        Page<ArticuloDTO> pageDTO = articulos.map(articulo -> ModelMapperUtils.map(articulo, ArticuloDTO.class));
        return pageDTO;
    }

    @Override
    public Page<ArticuloDTO> obtenerArticulosPaginadoSpec(Pageable pageable, SearchCriteria[] criteriaLis) {
        ArticuloSpecification specArticulo = new ArticuloSpecification();
        for (SearchCriteria criteria : criteriaLis){
            specArticulo.add(criteria);
        }
        Page<Articulo> articulos = articuloRepository.findAll(specArticulo, pageable);

        Page<ArticuloDTO> dtoPage = articulos.map(articulo -> ModelMapperUtils.map(articulo, ArticuloDTO.class));
        return dtoPage;
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
