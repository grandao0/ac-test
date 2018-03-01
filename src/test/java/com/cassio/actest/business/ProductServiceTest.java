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
		assertEquals(6, products.size());
	}

	@Test
	public void getAllProductsExcluding() throws Exception {
		List<Product> products = productService.findExcluding();
		assertFalse(products.isEmpty());
		assertEquals(5, products.size());
	}

	@Test
	public void getProductExcludingById() throws Exception {
		List<Product> products = productService.findExcludingById(1L);
		assertFalse(products.isEmpty());
		assertEquals(1, products.size());
	}

	@Test
	public void getParentsById() throws Exception {
		List<Product> products = productService.findByParentId(2L);
		assertFalse(products.isEmpty());
		assertEquals(3, products.size());
	}

	@Test
	public void getProductById() throws Exception {
		Product product = productService.findById(1L);
		assertFalse(product == null);
		assertEquals("mouse", product.getName());
	}

	@Test
	public void saveProduct() throws Exception {
		Product product = new Product();
		product.setDescription("test");
		product.setName("test");
		productService.save(product);
		Product pdc = productService.findById(7L);
		assertFalse(pdc == null);
		assertEquals("test", pdc.getName());
	}

	@Test
	public void updateProduct() throws Exception {
		Product product = productService.findById(1L);
		product.setName("updated");
		productService.update(product, 1L);
		Product pdc = productService.findById(1L);
		assertFalse(pdc == null);
		assertEquals("updated", pdc.getName());
	}

	@Test
	public void deleteProductById() throws Exception {
		productService.deleteById(6L);
		Product product = productService.findById(6L);
		assertFalse(product != null);
	}
}