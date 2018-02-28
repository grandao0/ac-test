package com.cassio.actest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cassio.actest.model.Product;
import com.cassio.actest.repository.ProductRepository;

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

	public ResponseEntity<Map<String, Object>> update(Product product) {
		try {
			Map<String, Object> result = new HashMap<>();

			productRepository.saveAndFlush(product);
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