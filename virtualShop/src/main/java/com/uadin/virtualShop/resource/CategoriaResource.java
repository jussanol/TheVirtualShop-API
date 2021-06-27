package com.uadin.virtualShop.resource;

import com.uadin.virtualShop.repository.specs.SearchCriteria;
import com.uadin.virtualShop.service.ICategoriaService;
import com.uadin.virtualShop.service.dto.CategoriaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CategoriaResource {

    private ICategoriaService categoriaService;

    public CategoriaResource(ICategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categorias")
    public List<CategoriaDTO> getAllCategorias(){
        List<CategoriaDTO> categorias = this.categoriaService.obtenerCategorias();
        return categorias;
    }

    @GetMapping("/categorias-pag")
    public Page<CategoriaDTO> getAllCategorias (Pageable pageable){
        return this.categoriaService.obtenerCategoriasPageable(pageable);
    }

    @PostMapping("/categorias-pag-spec")
    public Page<CategoriaDTO> getAllCategoriasSpec (Pageable pageable, @RequestBody SearchCriteria[] criteria){
        return this.categoriaService.obtenerCategoriasPaginadoSpec(pageable, criteria);
    }

    @PostMapping("/categorias")
    public CategoriaDTO postCategoria(@RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO categoria = this.categoriaService.save(categoriaDTO);
        return categoria;
    }

    @PutMapping("/categorias")
    public CategoriaDTO putCategoria(@RequestBody CategoriaDTO categoriaDTO){
        CategoriaDTO categoria = this.categoriaService.save(categoriaDTO);
        return categoria;
    }

    @GetMapping("/categoria/{id}")
    public CategoriaDTO getCategoria(@PathVariable Long id){
        return this.categoriaService.getCategoria(id);
    }

    @DeleteMapping("/categoria/{id}")
    public void deleteCategoria(@PathVariable Long id){
        this.categoriaService.deleteCategoria(id);
    }
}
