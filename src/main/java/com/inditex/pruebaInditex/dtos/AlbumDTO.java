package com.inditex.pruebaInditex.dtos;

import java.util.List;

public class AlbumDTO {
	private int userId;
	private int id;
	private String title;
	private List<PhotosDTO> listPhotos;

	public List<PhotosDTO> getListPhotos() {
		return listPhotos;
	}

	public void setListPhotos(List<PhotosDTO> listPhotos) {
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
