package com.inditex.prueba_inditex.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inditex.prueba_inditex.dto.AlbumDTO;

@Service
public interface AlbumsService {
	public void saveAlbum();

	public List<AlbumDTO> getAlbum();

	public List<AlbumDTO> getAlbumFromDatabase();

}
