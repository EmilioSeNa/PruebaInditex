package com.inditex.prueba_inditex.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.inditex.prueba_inditex.dto.AlbumDTO;
import com.inditex.prueba_inditex.dto.PhotoDTO;
import com.inditex.prueba_inditex.test.utils.TestUtils;

class AlbumPhotoDTOTest {
	@Test
	void testPhotoDTO() {
		PhotoDTO photo = TestUtils.getListMockPhotoDTO().get(0);
		assertEquals(1, photo.getId());
		assertEquals("Title 1", photo.getTitle());
		assertEquals("Url 1", photo.getUrl());
		assertEquals("", photo.getThumbnailUrl());
		String expectedToString = "PhotosDTO [albumId=1, id=1, title=Title 1, url=Url 1, thumbnailUrl=]";
		assertEquals(expectedToString, photo.toString());
	}

	@Test
	void testAlbumDTO() {
		AlbumDTO album = TestUtils.getMockAlbumDTO().get(0);
		assertEquals(1, album.getId());
		assertEquals("Album 1", album.getTitle());
		assertEquals(1, album.getUserId());
		assertEquals(2, album.getListPhotos().size());
		String expectedToString = "AlbumsDTO [userId=1, id=1, title=Album 1, listPhotos=[PhotosDTO [albumId=1, id=1, title=Title 1, url=Url 1, thumbnailUrl=], PhotosDTO [albumId=1, id=1, title=Title 2, url=Url 2, thumbnailUrl=]]]";
		assertEquals(expectedToString, album.toString());
	}
}
