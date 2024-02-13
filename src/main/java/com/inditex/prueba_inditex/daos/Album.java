package com.inditex.prueba_inditex.daos;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ALBUM")
public class Album {

	@Id
	private int id;
	private String title;
	private int userId;

	@OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Photo> listPhotos = new ArrayList<>();

	public void addPhoto(Photo photo) {
		listPhotos.add(photo);
		photo.setAlbum(this);
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

	public List<Photo> getListPhotos() {
		return listPhotos;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", userId=" + userId + ", listPhotos=" + listPhotos + "]";
	}

}
