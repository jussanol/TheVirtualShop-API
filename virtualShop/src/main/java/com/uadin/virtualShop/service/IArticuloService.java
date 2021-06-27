package com.uadin.virtualShop.service;

import com.uadin.virtualShop.repository.specs.SearchCriteria;
import com.uadin.virtualShop.service.dto.ArticuloDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IArticuloService {

    List<ArticuloDTO> obtenerArticulos();
    Page<ArticuloDTO> obtenerArticulosPaginado(Pageable pageable);
    Page<ArticuloDTO> obtenerArticulosPaginadoSpec(Pageable pageable, SearchCriteria[] criteria);

    ArticuloDTO save(ArticuloDTO articuloDTO);

    ArticuloDTO getArticulo(Long id);

    void delete(Long id);


}
