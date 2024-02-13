package com.inditex.prueba_inditex.dto;

import java.util.List;

public class AlbumDTO {
	private int userId;
	private int id;
	private String title;
	private List<PhotoDTO> listPhotos;
	
	
	public AlbumDTO() {

	}

	public AlbumDTO(int userId, int id, String title, List<PhotoDTO> listPhotos) {
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.listPhotos = listPhotos;
	}

	public List<PhotoDTO> getListPhotos() {
		return listPhotos;
	}

	public void setListPhotos(List<PhotoDTO> listPhotos) {
		this.listPhotos = listPhotos;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "AlbumsDTO [userId=" + userId + ", id=" + id + ", title=" + title + ", listPhotos=" + listPhotos + "]";
	}




}
