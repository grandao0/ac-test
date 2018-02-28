package com.cassio.actest.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cassio.actest.model.Image;
import com.cassio.actest.repository.ImageRepository;

public class ImageService {
	@Autowired
	private ImageRepository imageRepository;

	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	public List<Image> findAll() {
		return imageRepository.findAll();
	}

	public Image findById(Long id) {
		return imageRepository.findOne(id);
	}

	public ResponseEntity<Map<String, Object>> save(Image image) {
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

	public ResponseEntity<Map<String, Object>> update(Image image) {
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

	public ResponseEntity<Map<String, Object>> deleteById(Long id) {
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

	public List<Image> findByProductId(Long productId) {
		return imageRepository.findByProductId(productId);
	}
}