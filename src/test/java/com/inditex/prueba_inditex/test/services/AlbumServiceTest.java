package com.inditex.prueba_inditex.test.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.inditex.prueba_inditex.daos.Album;
import com.inditex.prueba_inditex.dto.AlbumDTO;
import com.inditex.prueba_inditex.dto.PhotoDTO;
import com.inditex.prueba_inditex.mapper.AlbumMapper;
import com.inditex.prueba_inditex.repository.AlbumRepository;
import com.inditex.prueba_inditex.service.AlbumsServiceImpl;
import com.inditex.prueba_inditex.test.utils.TestUtils;

@RunWith(MockitoJUnitRunner.class)
public class AlbumServiceTest {

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private AlbumRepository albumRepository;

	@Mock
	private AlbumMapper albumMapper;

	@InjectMocks
	private AlbumsServiceImpl albumsService;

	@Test
	public void testSaveAlbum() {
		AlbumDTO[] albums = TestUtils.albumsDTO;
		PhotoDTO[] photos = TestUtils.photosDTO1;

		when(restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", PhotoDTO[].class))
				.thenReturn(photos);
		when(restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums", AlbumDTO[].class))
				.thenReturn(albums);
		when(albumMapper.toAlbum(any(AlbumDTO.class))).thenReturn(TestUtils.getMockAlbum().get(0));
		when(albumMapper.toPhoto(any(PhotoDTO.class))).thenReturn(TestUtils.getListMockPhoto().get(0));
		albumsService.saveAlbum();

		verify(albumRepository, times(1)).saveAll(any());
	}

	@Test
	public void testGetAlbum() {
		AlbumDTO[] albums = TestUtils.albumsDTO;
		PhotoDTO[] photos = TestUtils.photosDTO1;

		when(restTemplate.getForObject("https://jsonplaceholder.typicode.com/albums", AlbumDTO[].class))
				.thenReturn(albums);
		when(restTemplate.getForObject("https://jsonplaceholder.typicode.com/photos", PhotoDTO[].class))
				.thenReturn(photos);

		List<AlbumDTO> result = albumsService.getAlbum();

		assertEquals(Arrays.asList(albums), result);
	}

	@Test
	public void testGetAlbumFromDatabase() {
		List<Album> albums = TestUtils.getMockAlbum();
		when(albumRepository.count()).thenReturn((long) albums.size());
		when(albumRepository.findAll()).thenReturn(albums);
		List<AlbumDTO> expectedAlbumDTOs = TestUtils.getMockAlbumDTO();
		when(albumMapper.toAlbumsDTO(any())).thenReturn(expectedAlbumDTOs.get(0));
		List<AlbumDTO> actualAlbumDTOs = albumsService.getAlbumFromDatabase();
		assertEquals(expectedAlbumDTOs.size(), actualAlbumDTOs.size());
	}

}