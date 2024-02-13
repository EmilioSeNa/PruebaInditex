package com.inditex.prueba_inditex.test.utils;

import java.util.Arrays;
import java.util.List;

import com.inditex.prueba_inditex.daos.Album;
import com.inditex.prueba_inditex.daos.Photo;
import com.inditex.prueba_inditex.dto.AlbumDTO;
import com.inditex.prueba_inditex.dto.PhotoDTO;

public class TestUtils {

	public static PhotoDTO[] photosDTO1 = { new PhotoDTO(1, 1, "Title 1", "Url 1", ""),
			new PhotoDTO(1, 2, "Title 2", "Url 2", "") };
	public static PhotoDTO[] photosDTO2 = { new PhotoDTO(2, 3, "Title 3", "Url 3", ""),
			new PhotoDTO(1, 2, "Title 4", "Url 4", "") };
	public static AlbumDTO[] albumsDTO = { new AlbumDTO(1, 1, "Album 1", Arrays.asList(photosDTO1)),
			new AlbumDTO(2, 2, "Album 2", Arrays.asList(photosDTO2)) };

	public static List<Photo> getListMockPhoto() {
		Photo photo = new Photo();
		photo.setId(1);
		photo.setThumbnailUrl("");
		photo.setUrl("Url 1");
		photo.setTitle("Title 1");
		Album album = new Album();
		album.setId(1);
		photo.setAlbum(album);
		Photo photo2 = new Photo();
		photo2.setId(1);
		photo2.setThumbnailUrl("");
		photo2.setUrl("Url 2");
		photo2.setTitle("Title 2");
		photo2.setAlbum(album);
		return List.of(photo,photo2);
	}

	public static List<Album> getMockAlbum() {
		Album album = new Album();
		album.setId(1);
		album.setTitle("Album 1");
		album.setUserId(1);
		album.addPhoto(getListMockPhoto().get(0));
		album.addPhoto(getListMockPhoto().get(1));
		return List.of(album);
	}
	
	public static List<PhotoDTO> getListMockPhotoDTO() {
		PhotoDTO photo = new PhotoDTO();
		photo.setId(1);
		photo.setThumbnailUrl("");
		photo.setUrl("Url 1");
		photo.setTitle("Title 1");
		photo.setAlbumId(1);
		PhotoDTO photo2 = new PhotoDTO();
		photo2.setId(1);
		photo2.setThumbnailUrl("");
		photo2.setUrl("Url 2");
		photo2.setTitle("Title 2");
		photo2.setAlbumId(1);
		return List.of(photo,photo2);
	}

	public static List<AlbumDTO> getMockAlbumDTO() {
		AlbumDTO album = new AlbumDTO();
		album.setId(1);
		album.setTitle("Album 1");
		album.setUserId(1);
		album.setListPhotos(getListMockPhotoDTO());
		return List.of(album);
	}
}
