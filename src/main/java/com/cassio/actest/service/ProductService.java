package com.cassio.actest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cassio.actest.model.Product;
import com.cassio.actest.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	public List<Product> findAll() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		return productRepository.findOne(id);
	}

	public List<Product> findExcluding() {
		return productRepository.findExcluding();
	}

	public List<Product> findExcludingById(Long id) {
		return productRepository.findExcludingById(id);
	}

	public List<Product> findByParentId(Long id) {
		return productRepository.findByParentId(id);
	}

	public ResponseEntity<Map<String, Object>> save(Product product) {
		try {
			Map<String, Object> result = new HashMap<>();

			productRepository.save(product);
			result.put(SUCCESS, true);

			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> result = new HashMap<>();
			result.put(ERROR, e.getMessage());
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Map<String, Object>> update(Product product, Long id) {
		try {
			Map<String, Object> result = new HashMap<>();

			Product pdct = productRepository.findOne(id);
			pdct.setName(product.getName());
			pdct.setDescription(product.getDescription());
			if (product.getImages() != null) {
				pdct.setImages(product.getImages());
			}
			if (product.getParent() != null) {
				pdct.setParent(product.getParent());
			}
			productRepository.saveAndFlush(pdct);

			result.put(SUCCESS, true);

			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> result = new HashMap<>();
			result.put(ERROR, e.getMessage());
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	public ResponseEntity<Map<String, Object>> deleteById(Long id) {
		try {
			Map<String, Object> result = new HashMap<>();

			productRepository.delete(id);
			result.put(SUCCESS, true);

			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> result = new HashMap<>();
			result.put(ERROR, e.getMessage());
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}