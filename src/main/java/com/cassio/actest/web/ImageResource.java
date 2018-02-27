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

import com.cassio.actest.model.Image;
import com.cassio.actest.repository.ImageRepository;

@RestController
@RequestMapping
public class ImageResource {
	@Autowired
	private ImageRepository imageRepository;

	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	@RequestMapping(method = RequestMethod.GET, path = "/images")
	public List<Image> findAll() {
		return imageRepository.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/images/{id}")
	public Image findById(@PathVariable("id") Long id) {
		return imageRepository.findOne(id);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST, path = "/images")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> save(@RequestBody Image image) {
		try {
			Map<String, Object> result = new HashMap<>();

			imageRepository.saveAndFlush(image);
			result.put(SUCCESS, true);

			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> result = new HashMap<>();
			result.put(ERROR, e.getMessage());
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	@RequestMapping(method = RequestMethod.PUT, path = "/images")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> update(@RequestBody Image image) {
		try {
			Map<String, Object> result = new HashMap<>();

			imageRepository.saveAndFlush(image);
			result.put(SUCCESS, true);

			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> result = new HashMap<>();
			result.put(ERROR, e.getMessage());
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Transactional
	@RequestMapping(method = RequestMethod.DELETE, path = "/images/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteById(@PathVariable Long id) {
		try {
			Map<String, Object> result = new HashMap<>();

			imageRepository.delete(id);
			imageRepository.flush();
			result.put(SUCCESS, true);

			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			Map<String, Object> result = new HashMap<>();
			result.put(ERROR, e.getMessage());
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/images/products/{productId}")
	public List<Image> findByProductId(@PathVariable Long productId) {
		return imageRepository.findByProductId(productId);
	}
}