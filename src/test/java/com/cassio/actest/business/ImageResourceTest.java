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
	public void getAllImagesReturnsDataFromDatabase() throws Exception {
		List<Image> images = imageResource.findAll();
		assertFalse(images.isEmpty());
		assertEquals(2, images.size());
	}

	@Test
	public void getImageById() throws Exception {
		Image image = imageResource.findById(1L);
		assertFalse(image == null);
		assertEquals("png", image.getImageType());
	}

	@Test
	public void deleteImageById() throws Exception {
		imageResource.deleteById(1L);
		Image image = imageResource.findById(1L);
		assertFalse(image != null);
	}
}