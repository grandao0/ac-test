package com.cassio.actest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassio.actest.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}