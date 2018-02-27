package com.cassio.actest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cassio.actest.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {
	public List<Image> findByProductId(Long productId);
}