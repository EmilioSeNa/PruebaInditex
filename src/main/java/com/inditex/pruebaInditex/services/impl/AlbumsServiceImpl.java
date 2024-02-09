package com.inditex.pruebaInditex.services.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inditex.pruebaInditex.daos.Album;
import com.inditex.pruebaInditex.dtos.AlbumDTO;
import com.inditex.pruebaInditex.dtos.PhotosDTO;
import com.inditex.pruebaInditex.mapper.AlbumMapper;
import com.inditex.pruebaInditex.repositories.AlbumRepository;
import com.inditex.pruebaInditex.services.AlbumsService;

@Service
public class AlbumsServiceImpl implements AlbumsService {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private AlbumMapper albumMapper;

	public void savePhotoStore() {
		 PhotosDTO[] allPhotos = restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", PhotosDTO[].class);
	        
	        Map<Integer, List<PhotosDTO>> photosByAlbumId = Arrays.stream(allPhotos)
	                .collect(Collectors.groupingBy(PhotosDTO::getAlbumId));

	        AlbumDTO[] allAlbums = restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums", AlbumDTO[].class);
	        
	        Arrays.stream(allAlbums)
	                .forEach(album -> {
	                    List<PhotosDTO> photosForAlbum = photosByAlbumId.getOrDefault(album.getId(), Collections.emptyList());
	                    album.setListPhotos(photosForAlbum);
	                    albumRepository.save(albumMapper.toAlbum(album));
	                });
	}

	public List<AlbumDTO> getPhotoStore() {
	    PhotosDTO[] allPhotos = restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", PhotosDTO[].class);
	    
	    AlbumDTO[] albums = restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums", AlbumDTO[].class);
	    
	    Map<Integer, List<PhotosDTO>> photosByAlbumId = Arrays.stream(allPhotos)
	            .collect(Collectors.groupingBy(PhotosDTO::getAlbumId));

	    Arrays.stream(albums)
	            .forEach(album -> {
	                List<PhotosDTO> photosForAlbum = photosByAlbumId.getOrDefault(album.getId(), Collections.emptyList());
	                album.setListPhotos(photosForAlbum);
	            });

	    return Arrays.asList(albums);
	}

	public List<AlbumDTO> getPhotoStoreFromDatabase() {
		savePhotoStore();
		List<Album> albums = albumRepository.findAll();
		return albums.stream().map(albumMapper::toAlbumsDTO).collect(Collectors.toList());

	}

}
