package com.uadin.virtualShop.service.impl;

import com.uadin.virtualShop.model.Categoria;
import com.uadin.virtualShop.repository.CategoriaRepository;
import com.uadin.virtualShop.repository.specs.CategoriaSpecification;
import com.uadin.virtualShop.repository.specs.SearchCriteria;
import com.uadin.virtualShop.service.ICategoriaService;
import com.uadin.virtualShop.service.dto.CategoriaDTO;
import com.uadin.virtualShop.service.mapper.ModelMapperUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<CategoriaDTO> obtenerCategoriasPageable(Pageable pageable) {
        Page<Categoria> categorias = this.categoriaRepository.findAll(pageable);
        Page<CategoriaDTO> pageDTO = categorias.map(categoria -> ModelMapperUtils.map(categoria, CategoriaDTO.class));
        return pageDTO;
    }

    @Override
    public Page<CategoriaDTO> obtenerCategoriasPaginadoSpec(Pageable pageable, SearchCriteria[] criteriaLis) {
        CategoriaSpecification specArticulo = new CategoriaSpecification();
        for (SearchCriteria criteria : criteriaLis){
            specArticulo.add(criteria);
        }
        Page<Categoria> categorias = categoriaRepository.findAll(specArticulo, pageable);

        Page<CategoriaDTO> dtoPage = categorias.map(categoria -> ModelMapperUtils.map(categoria, CategoriaDTO.class));
        return dtoPage;
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
