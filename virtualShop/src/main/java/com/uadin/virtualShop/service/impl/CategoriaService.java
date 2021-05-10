package com.uadin.virtualShop.service.impl;

import com.uadin.virtualShop.model.Categoria;
import com.uadin.virtualShop.repository.CarrouselRepository;
import com.uadin.virtualShop.repository.CategoriaRepository;
import com.uadin.virtualShop.service.ICategoriaService;
import com.uadin.virtualShop.service.dto.CategoriaDTO;
import com.uadin.virtualShop.service.mapper.ModelMapperUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<CategoriaDTO> obtenerCategorias() {
        List<Categoria> categorias = this.categoriaRepository.findAll();
        return ModelMapperUtils.mapAll(categorias, CategoriaDTO.class);
    }

    @Override
    public CategoriaDTO save(CategoriaDTO categoriaDTO) {
        Categoria categoria = this.categoriaRepository.save(ModelMapperUtils.map(categoriaDTO, Categoria.class));
        return ModelMapperUtils.map(categoria, CategoriaDTO.class);
    }

    @Override
    public CategoriaDTO getCategoria(Long id) {
        Optional<Categoria> categoria = this.categoriaRepository.findById(id);
        if(categoria.isPresent()){
            return ModelMapperUtils.map(categoria.get(), CategoriaDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public void deleteCategoria(Long id) {
        this.categoriaRepository.deleteById(id);
    }
}
