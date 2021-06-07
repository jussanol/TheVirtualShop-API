package com.uadin.virtualShop.resource;

import com.uadin.virtualShop.model.Categoria;
import com.uadin.virtualShop.service.ICategoriaService;
import com.uadin.virtualShop.service.dto.CategoriaDTO;
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
