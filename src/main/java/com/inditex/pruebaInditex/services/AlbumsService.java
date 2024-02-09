package com.inditex.pruebaInditex.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inditex.pruebaInditex.dtos.AlbumDTO;

@Service
public interface AlbumsService {
	public void savePhotoStore();

	public List<AlbumDTO> getPhotoStore();

	public List<AlbumDTO> getPhotoStoreFromDatabase();

}
