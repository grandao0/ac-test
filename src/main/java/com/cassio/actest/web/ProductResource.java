package com.cassio.actest.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cassio.actest.model.Product;
import com.cassio.actest.service.ProductService;

@RestController
@RequestMapping
public class ProductResource {
	@Autowired
	private ProductService productService;

	@RequestMapping(method = RequestMethod.GET, path = "/products")
	public List<Product> findAll() {
		return productService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/products/{id}")
	public Product findById(@PathVariable("id") Long id) {
		return productService.findById(id);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, path = "/products")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> save(Product product) {
		return productService.save(product);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.PUT, path = "/products")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> update(@RequestBody Product product) {
		return productService.update(product);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.DELETE, path = "/products/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteById(@PathVariable Long id) {
		return productService.deleteById(id);
	}
}