package com.uadin.virtualShop.repository;

import com.uadin.virtualShop.model.Articulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long>, JpaSpecificationExecutor<Articulo> {

    Page<Articulo> findAll(Pageable pageable);
    Page<Articulo> findAll(Specification<Articulo> specArticulo, Pageable pageable);
}
