package com.uadin.virtualShop.resource;

import com.uadin.virtualShop.service.IArticuloService;
import com.uadin.virtualShop.service.dto.ArticuloDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ArticuloResource {

    private IArticuloService articuloService;

    public ArticuloResource(IArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/articulos")
    public List<ArticuloDTO> getAllArticulos(){
        List<ArticuloDTO> articulos = this.articuloService.obtenerArticulos();
        return articulos;
    }

    @PostMapping("/articulos")
    public ArticuloDTO postArticulo(@RequestBody ArticuloDTO articuloDTO){
        ArticuloDTO articulo = this.articuloService.save(articuloDTO);
        return articulo;
    }

    @PutMapping("articulos")
    public ArticuloDTO updateArticulo(@RequestBody ArticuloDTO articuloDTO){
        ArticuloDTO articulo = this.articuloService.save(articuloDTO);
        return articulo;
    }

    @GetMapping("/articulo/{id}")
    public ArticuloDTO getArticulo(@PathVariable Long id){
        ArticuloDTO articulo = this.articuloService.getArticulo(id);
        return  articulo;
    }

    @DeleteMapping("articulo/{id}")
    public void deleteArticulo(@PathVariable Long id){
        this.articuloService.delete(id);
    }

}
