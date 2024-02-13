package com.inditex.prueba_inditex.test.integration;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.inditex.prueba_inditex.controllers.rest.AlbumsController;
import com.inditex.prueba_inditex.service.AlbumsService;

@WebMvcTest(AlbumsController.class)
@AutoConfigureMockMvc
class AlbumIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AlbumsService albumsService;

	@Test
	void testSaveAlbumEndpoint() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/saveAlbum").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string("Save photo store data in database"));

		verify(albumsService, times(1)).saveAlbum();
	}

	@Test
	void testGetAlbumEndpoint() throws Exception {
		when(albumsService.getAlbum()).thenReturn(Collections.emptyList());

		mockMvc.perform(MockMvcRequestBuilders.get("/api/getAlbum").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$").isArray());

		verify(albumsService, times(1)).getAlbum();
	}

	@Test
	void testGetAlbumFromDatabaseEndpoint() throws Exception {
		when(albumsService.getAlbumFromDatabase()).thenReturn(Collections.emptyList());

		mockMvc.perform(MockMvcRequestBuilders.get("/api/getAlbumFromDatabase").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$").isArray());

		verify(albumsService, times(1)).getAlbumFromDatabase();
	}
}
