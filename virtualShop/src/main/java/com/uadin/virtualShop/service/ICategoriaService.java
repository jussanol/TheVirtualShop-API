package com.uadin.virtualShop.service;

import com.uadin.virtualShop.repository.specs.SearchCriteria;
import com.uadin.virtualShop.service.dto.CategoriaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoriaService {
    List<CategoriaDTO> obtenerCategorias();

    Page<CategoriaDTO> obtenerCategoriasPageable(Pageable pageable);

    Page<CategoriaDTO> obtenerCategoriasPaginadoSpec(Pageable pageable, SearchCriteria[] criteria);

    CategoriaDTO save(CategoriaDTO categoriaDTO);

    CategoriaDTO getCategoria(Long id);

    void deleteCategoria(Long id);
}
