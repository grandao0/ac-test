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

import com.cassio.actest.model.Image;
import com.cassio.actest.service.ImageService;

@RestController
@RequestMapping
public class ImageResource {
	@Autowired
	private ImageService imageService;

	@RequestMapping(method = RequestMethod.GET, path = "/images")
	public List<Image> findAll() {
		return imageService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/images/{id}")
	public Image findById(@PathVariable("id") Long id) {
		return imageService.findById(id);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, path = "/images")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> save(@RequestBody Image image) {
		return imageService.save(image);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.PUT, path = "/images")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> update(@RequestBody Image image) {
		return imageService.update(image);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.DELETE, path = "/images/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteById(@PathVariable Long id) {
		return imageService.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/images/products/{productId}")
	public List<Image> findByProductId(@PathVariable Long productId) {
		return imageService.findByProductId(productId);
	}
}