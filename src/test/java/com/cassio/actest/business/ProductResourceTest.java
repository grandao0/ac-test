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
import com.cassio.actest.web.ProductResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductResourceTest {
	@Autowired
	private ProductResource productResource;

	@Test
	public void getAllProductsReturnsDataFromDatabase() throws Exception {
		List<Product> products = productResource.findAll();
		assertFalse(products.isEmpty());
		assertEquals(5, products.size());
	}
	
	@Test
	public void getProductById() throws Exception {
		Product product = productResource.findById(1L);
		assertFalse(product == null);
		assertEquals("mouse", product.getName());
	}
	
	@Test
	public void deleteProductById() throws Exception {
		productResource.deleteById(1L);
		Product product = productResource.findById(1L);
		assertFalse(product != null);
	}
}