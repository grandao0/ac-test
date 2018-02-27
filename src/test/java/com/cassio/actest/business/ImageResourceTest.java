package com.cassio.actest.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cassio.actest.model.Image;
import com.cassio.actest.web.ImageResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageResourceTest {
	@Autowired
	private ImageResource imageResource;

	@Test
	public void getAllProductsReturnsDataFromDatabase() throws Exception {
		List<Image> images = imageResource.findAll();
		assertFalse(images.isEmpty());
		assertEquals(2, images.size());

		// If you want to compare all the authors to what we inserted in
		// '02-insert-data-authors.xml'
		images.forEach(System.out::println);
	}
}