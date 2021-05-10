package com.uadin.virtualShop.service;

import com.uadin.virtualShop.service.dto.CategoriaDTO;

import java.util.List;

public interface ICategoriaService {
    List<CategoriaDTO> obtenerCategorias();

    CategoriaDTO save(CategoriaDTO categoriaDTO);

    CategoriaDTO getCategoria(Long id);

    void deleteCategoria(Long id);
}
