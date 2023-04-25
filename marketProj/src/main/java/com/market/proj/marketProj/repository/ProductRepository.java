package com.market.proj.marketProj.repository;

import com.market.proj.marketProj.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    <S extends Product> S save(S entity);
    public Product findByIdx(Long idx);
    List<Product> findByIsEndFalse();

    List<Product> findFirst12ByOrderByCreatedAtDesc();

    @Transactional
    List<Product> findFirst12ByIsEndFalseOrderByCreatedAtDesc();
}
