package com.inditex.prueba_inditex.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.inditex.prueba_inditex.daos.Album;
import com.inditex.prueba_inditex.daos.Photo;
import com.inditex.prueba_inditex.dto.AlbumDTO;
import com.inditex.prueba_inditex.dto.PhotoDTO;
import com.inditex.prueba_inditex.mapper.AlbumMapper;
import com.inditex.prueba_inditex.repository.AlbumRepository;

@Service
public class AlbumsServiceImpl implements AlbumsService {
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private AlbumRepository albumRepository;

	@Autowired
	private AlbumMapper albumMapper;

	public void saveAlbum() {
		PhotoDTO[] photosDTO = getPhotosFromExternalAPI();
		AlbumDTO[] albumsDTO = getAlbumsFromExternalAPI();
		List<Album> albumsList = new ArrayList<>();
		Map<Integer, List<PhotoDTO>> photosByAlbumId = orderPhotosByAlbum(photosDTO);
		Arrays.stream(albumsDTO).forEach(albumDTO -> {
			List<PhotoDTO> photosForAlbum = photosByAlbumId.getOrDefault(albumDTO.getId(), Collections.emptyList());
			Album album = albumMapper.toAlbum(albumDTO);
			photosForAlbum.forEach(photoDTO -> {
				Photo photo = albumMapper.toPhoto(photoDTO);
				album.addPhoto(photo);
				albumsList.add(album);
			});
			
		});
		albumRepository.saveAll(albumsList);
	}

	public List<AlbumDTO> getAlbum() {
		PhotoDTO[] photosDTO = getPhotosFromExternalAPI();
		AlbumDTO[] albumsDTO = getAlbumsFromExternalAPI();
		Map<Integer, List<PhotoDTO>> photosByAlbumId = orderPhotosByAlbum(photosDTO);
		Arrays.stream(albumsDTO).forEach(albumDTO -> {
			List<PhotoDTO> photosForAlbum = photosByAlbumId.getOrDefault(albumDTO.getId(), Collections.emptyList());
			albumDTO.setListPhotos(photosForAlbum);
		});

		return Arrays.asList(albumsDTO);
	}

	public List<AlbumDTO> getAlbumFromDatabase() {
		saveAlbumsIfEmpty();
		List<Album> albums = retrieveAlbumsFromDatabase();
		return convertToAlbumDTO(albums);

	}

	private PhotoDTO[] getPhotosFromExternalAPI() {
		return restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", PhotoDTO[].class);
	}

	private AlbumDTO[] getAlbumsFromExternalAPI() {
		return restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums", AlbumDTO[].class);
	}

	private Map<Integer, List<PhotoDTO>> orderPhotosByAlbum(PhotoDTO[] allPhotos) {
		return Arrays.stream(allPhotos).collect(Collectors.groupingBy(PhotoDTO::getAlbumId));
	}
	

	private List<Album> retrieveAlbumsFromDatabase() {
		return albumRepository.findAll();
	}

	private void saveAlbumsIfEmpty() {
		if (albumRepository.count() == 0) {
			saveAlbum();
		}
	}

	private List<AlbumDTO> convertToAlbumDTO(List<Album> albums) {
		return albums.stream().map(albumMapper::toAlbumsDTO).collect(Collectors.toList());
	}

}
