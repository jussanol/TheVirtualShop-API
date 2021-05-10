package com.uadin.virtualShop.service;

import com.uadin.virtualShop.service.dto.ArticuloDTO;

import java.util.List;

public interface IArticuloService {
    List<ArticuloDTO> obtenerArticulos();

    ArticuloDTO save(ArticuloDTO articuloDTO);

    ArticuloDTO getArticulo(Long id);

    void delete(Long id);
}
