package com.uadin.virtualShop.repository;

import com.uadin.virtualShop.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Page<Categoria> findAll(Pageable pageable);
    Page<Categoria> findAll(Specification<Categoria> specCategoria, Pageable pageable);
}
