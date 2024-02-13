package com.inditex.prueba_inditex.test.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.inditex.prueba_inditex.daos.Album;
import com.inditex.prueba_inditex.daos.Photo;
import com.inditex.prueba_inditex.test.utils.TestUtils;

class AlbumPhotoEntityTest {
	@Test
	 void testPhotoEntity() {
		Photo photo = TestUtils.getListMockPhoto().get(0);
		assertEquals(1, photo.getId());
		assertEquals("Title 1", photo.getTitle());
		assertEquals("Url 1", photo.getUrl());
		assertEquals("", photo.getThumbnailUrl());
		String expectedToString = "Photos [id=1, title=Title 1, url=Url 1, thumbnailUrl=, album=1]";
        assertEquals(expectedToString, photo.toString());
	}

	@Test
	 void testAlbumEntity() {
		Album album = TestUtils.getMockAlbum().get(0);
		assertEquals(1, album.getId());
		assertEquals("Album 1", album.getTitle());
		assertEquals(1, album.getUserId());
		assertEquals(2, album.getListPhotos().size());
        String expectedToString = "Album [id=1, title=Album 1, userId=1, listPhotos=[Photos [id=1, title=Title 1, url=Url 1, thumbnailUrl=, album=1], Photos [id=1, title=Title 2, url=Url 2, thumbnailUrl=, album=1]]]";
        assertEquals(expectedToString, album.toString());
	}
}
