package com.inditex.prueba_inditex.test.advice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import com.inditex.prueba_inditex.controllers.advice.AlbumsControllerAdvice;

class AlbumsControllerAdviceTest {

	private final AlbumsControllerAdvice advice = new AlbumsControllerAdvice();

	@Test
	void testHandleNoSuchElementException() {
		NoSuchElementException exception = new NoSuchElementException("Test NoSuchElementException");
		ResponseEntity<String> response = advice.handleNoSuchElementException(exception);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals("Resource not found: Test NoSuchElementException", response.getBody());
	}

	@Test
	void testHandleHttpClientErrorException() {
		HttpClientErrorException exception = new HttpClientErrorException(HttpStatus.BAD_REQUEST,
				"Test HttpClientErrorException");
		ResponseEntity<String> response = advice.handleHttpClientErrorException(exception);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		assertEquals("HTTP Client Error: 400 Test HttpClientErrorException", response.getBody());
	}

	@Test
	void testHandleRuntimeException() {
		RuntimeException exception = new RuntimeException("Test RuntimeException");
		ResponseEntity<String> response = advice.handleRuntimeException(exception);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
		assertEquals("Internal Server Error: Test RuntimeException", response.getBody());
	}
}