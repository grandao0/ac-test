package com.cassio.actest.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cassio.actest.model.Product;
import com.cassio.actest.repository.ProductRepository;

@RestController
@RequestMapping(path = "/api/products")
public class ProductResource {
	@Autowired
	private ProductRepository productRepository;

	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	@RequestMapping(method = RequestMethod.GET, path = "/findAll")
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/findById/{id}")
	public Product findById(@PathVariable("id") Long id) {
		return productRepository.findOne(id);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, path = "/save", consumes = {"application/x-www-form-urlencoded"})
	@ResponseBody
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

	@Transactional
	@RequestMapping(method = RequestMethod.POST, path = "/update")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> update(@RequestBody Product product) {
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

	@Transactional
	@RequestMapping(method = RequestMethod.POST, path = "/delete/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteById(@PathVariable Long id) {
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