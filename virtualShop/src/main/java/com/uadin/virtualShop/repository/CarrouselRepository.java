package com.uadin.virtualShop.repository;

import com.uadin.virtualShop.model.Carrousel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrouselRepository extends JpaRepository<Carrousel, Long> {
}
