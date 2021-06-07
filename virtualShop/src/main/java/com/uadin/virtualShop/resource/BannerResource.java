package com.uadin.virtualShop.resource;

import com.uadin.virtualShop.service.IBannerService;
import com.uadin.virtualShop.service.dto.BannerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class BannerResource {

    private IBannerService bannerService;

    public BannerResource(IBannerService bannerService) {
        this.bannerService = bannerService;
    }

    @GetMapping("/banners")
    private List<BannerDTO> getAllBanner(){
        List<BannerDTO> banners = bannerService.obtenerBanners();
        return banners;
    }

    @PostMapping("/banners")
    public BannerDTO postBanner(@RequestBody BannerDTO bannerDTO){
        BannerDTO banner = this.bannerService.save(bannerDTO);
        return banner;
    }

    @PutMapping("/banners")
    public BannerDTO updateBanner(@RequestBody BannerDTO bannerDTO){
        BannerDTO banner = this.bannerService.save(bannerDTO);
        return banner;
    }

    @GetMapping("/banner/{id}")
    public BannerDTO getBanner(@PathVariable Long id){
        return this.bannerService.getBanner(id);
    }

    @DeleteMapping("/banner/{id}")
    public void deleteBanner(@PathVariable Long id){
        this.bannerService.deteleBanner(id);
    }
}
