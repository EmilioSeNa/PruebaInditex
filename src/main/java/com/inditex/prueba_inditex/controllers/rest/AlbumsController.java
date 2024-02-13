package com.inditex.prueba_inditex.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.prueba_inditex.dto.AlbumDTO;
import com.inditex.prueba_inditex.service.AlbumsService;

/**
 *
 * A controller to treatment albums
 */
@RestController
@RequestMapping("/api")
public class AlbumsController {

	@Autowired
	private AlbumsService albumService;

	@PostMapping("/saveAlbum")
	public ResponseEntity<String> saveAlbum() {
		albumService.saveAlbum();
		return ResponseEntity.ok("Save photo store data in database");
	}

	@GetMapping("/getAlbum")
	public ResponseEntity<List<AlbumDTO>> getAlbum() {
		List<AlbumDTO> lisAlbumDTOs = albumService.getAlbum();
		return ResponseEntity.ok(lisAlbumDTOs);
	}

	@GetMapping("/getAlbumFromDatabase")
	public ResponseEntity<List<AlbumDTO>> getAlbumFromDatabase() {
		List<AlbumDTO> dataFromDatabase = albumService.getAlbumFromDatabase();
		return ResponseEntity.ok(dataFromDatabase);
	}
}