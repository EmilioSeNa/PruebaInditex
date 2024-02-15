package com.inditex.prueba_inditex.test.integration;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.inditex.prueba_inditex.repository.AlbumRepository;
import com.inditex.prueba_inditex.test.utils.TestUtils;

@SpringBootTest
@AutoConfigureMockMvc
class AlbumIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AlbumRepository albumRepository;

	@Test
	void testSaveAlbumEndpoint() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/api/saveAlbum").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().string("Save photo store data in database"));

	}

	@Test
	void testGetAlbumEndpoint() throws Exception {
		when(albumRepository.findAll()).thenReturn(TestUtils.getMockAlbum());
		mockMvc.perform(MockMvcRequestBuilders.get("/api/getAlbum").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$").isArray());

	}

	@Test
	void testGetAlbumFromDatabaseEndpoint() throws Exception {
		when(albumRepository.findAll()).thenReturn(TestUtils.getMockAlbum());
		mockMvc.perform(MockMvcRequestBuilders.get("/api/getAlbumFromDatabase").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(jsonPath("$").isArray());

	}
}
