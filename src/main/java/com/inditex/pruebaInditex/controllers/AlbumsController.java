package com.inditex.pruebaInditex.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.pruebaInditex.dtos.AlbumDTO;
import com.inditex.pruebaInditex.services.AlbumsService;

/**
 *
 * A controller to return greeting text
 */
@RestController
@RequestMapping("/api")
public class AlbumsController {

	@Autowired
	private AlbumsService photoStoreService;

	@PostMapping("/savePhotoStore")
	public ResponseEntity<String> savePhotoStore() {
		photoStoreService.savePhotoStore();
		return ResponseEntity.ok("Save photo store data in database");
	}

	@GetMapping("/getPhotoStore")
	public ResponseEntity<List<AlbumDTO>> getPhotoStore() {
		List<AlbumDTO> lisAlbumDTOs = photoStoreService.getPhotoStore();
		return ResponseEntity.ok(lisAlbumDTOs);
	}

	@GetMapping("/getPhotoStoreFromDatabase")
	public ResponseEntity<List<AlbumDTO>> getPhotoStoreFromDatabase() {
		List<AlbumDTO> dataFromDatabase = photoStoreService.getPhotoStoreFromDatabase();
		return ResponseEntity.ok(dataFromDatabase);
	}
}