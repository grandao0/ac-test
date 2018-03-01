package com.cassio.actest.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cassio.actest.model.Product;
import com.cassio.actest.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
	@Autowired
	private ProductService productService;

	@Test
	public void getAllProductsReturnsDataFromDatabase() throws Exception {
		List<Product> products = productService.findAll();
		assertFalse(products.isEmpty());
		assertEquals(5, products.size());
	}

	@Test
	public void getProductById() throws Exception {
		Product product = productService.findById(1L);
		assertFalse(product == null);
		assertEquals("mouse", product.getName());
	}

	@Test
	public void deleteProductById() throws Exception {
		productService.deleteById(1L);
		Product product = productService.findById(1L);
		assertFalse(product != null);
	}
}