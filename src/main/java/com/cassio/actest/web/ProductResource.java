package com.cassio.actest.web;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cassio.actest.model.Product;
import com.cassio.actest.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {
	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Product> findAll() {
		return productService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Product findById(@PathVariable("id") Long id) {
		return productService.findById(id);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/excluding")
	public List<Product> findExcluding() {
		return productService.findExcluding();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/excluding/{id}")
	public List<Product> findExcludingById(@PathVariable("id") Long id) {
		return productService.findExcludingById(id);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/childs/{id}")
	public List<Product> findByParentId(@PathVariable("id") Long id) {
		return productService.findByParentId(id);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> save(@RequestBody Product product) {
		return productService.save(product);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> update(@RequestBody Product product, @PathVariable Long id) {
		return productService.update(product, id);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteById(@PathVariable Long id) {
		return productService.deleteById(id);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { EmptyResultDataAccessException.class, EntityNotFoundException.class })
	public void handleNotFound() {
		// returns HttpStatus.BAD_REQUEST when emptyResultData or EntityNotFound
		// Exceptions
	}
}