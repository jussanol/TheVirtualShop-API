package com.uadin.virtualShop.service;

import com.uadin.virtualShop.service.dto.BannerDTO;

import java.util.List;

public interface IBannerService {
    List<BannerDTO> obtenerBanners();

    BannerDTO save(BannerDTO bannerDTO);

    BannerDTO getBanner(Long id);

    void deteleBanner(Long id);
}
