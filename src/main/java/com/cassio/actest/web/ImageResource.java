package com.cassio.actest.web;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cassio.actest.model.Image;
import com.cassio.actest.service.ImageService;

@RestController
@RequestMapping("/images")
public class ImageResource {
	@Autowired
	private ImageService imageService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Image> findAll() {
		return imageService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}")
	public Image findById(@PathVariable("id") Long id) {
		return imageService.findById(id);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> save(@RequestBody Image image) {
		return imageService.save(image);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> update(@RequestBody Image image, @PathVariable Long id) {
		return imageService.update(image, id);
	}

	@Transactional
	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> deleteById(@PathVariable Long id) {
		return imageService.deleteById(id);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/products/{productId}")
	public List<Image> findByProductId(@PathVariable Long productId) {
		return imageService.findByProductId(productId);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = { EmptyResultDataAccessException.class, EntityNotFoundException.class })
	public void handleNotFound() {
		// returns HttpStatus.BAD_REQUEST when emptyResultData or EntityNotFound
		// Exceptions
	}
}