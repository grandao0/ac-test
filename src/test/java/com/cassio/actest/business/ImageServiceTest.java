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
import com.cassio.actest.service.ImageService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ImageServiceTest {
	@Autowired
	private ImageService imageService;

	@Test
	public void getAllImagesReturnsDataFromDatabase() throws Exception {
		List<Image> images = imageService.findAll();
		assertFalse(images.isEmpty());
		assertEquals(7, images.size());
	}

	@Test
	public void getImageByProductId() throws Exception {
		List<Image> images = imageService.findByProductId(1L);
		assertFalse(images.isEmpty());
		assertEquals(2, images.size());
	}

	@Test
	public void getImageById() throws Exception {
		Image image = imageService.findById(1L);
		assertFalse(image == null);
		assertEquals("png", image.getImageType());
	}

	@Test
	public void saveImage() throws Exception {
		Image image = new Image();
		image.setImageType("test");
		imageService.save(image);
		Image img = imageService.findById(8L);
		assertFalse(img == null);
		assertEquals("test", image.getImageType());
	}

	@Test
	public void updateImage() throws Exception {
		Image image = imageService.findById(1L);
		image.setImageType("updated");
		imageService.update(image, 1L);
		Image img = imageService.findById(1L);
		assertFalse(img == null);
		assertEquals("updated", image.getImageType());
	}

	@Test
	public void deleteImageById() throws Exception {
		imageService.deleteById(4L);
		Image image = imageService.findById(4L);
		assertFalse(image != null);
	}
}