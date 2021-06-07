package com.uadin.virtualShop.service.impl;

import com.uadin.virtualShop.model.Banner;
import com.uadin.virtualShop.repository.BannerRepository;
import com.uadin.virtualShop.service.IBannerService;
import com.uadin.virtualShop.service.dto.BannerDTO;
import com.uadin.virtualShop.service.mapper.ModelMapperUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BannerService implements IBannerService {

    private BannerRepository bannerRepository;

    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    @Override
    public List<BannerDTO> obtenerBanners() {
        List<Banner> banners = this.bannerRepository.findAll();
        return ModelMapperUtils.mapAll(banners, BannerDTO.class);
    }

    @Override
    public BannerDTO save(BannerDTO bannerDTO) {
        Banner banner = this.bannerRepository.save(ModelMapperUtils.map(bannerDTO, Banner.class));
        return ModelMapperUtils.map(banner, BannerDTO.class);
    }

    @Override
    public BannerDTO getBanner(Long id) {
        Optional<Banner> banner = this.bannerRepository.findById(id);
        if(banner.isPresent()){
            return ModelMapperUtils.map(banner.get(), BannerDTO.class);
        }else{
            return null;
        }
    }

    @Override
    public void deteleBanner(Long id) {
        this.bannerRepository.deleteById(id);
    }
}
