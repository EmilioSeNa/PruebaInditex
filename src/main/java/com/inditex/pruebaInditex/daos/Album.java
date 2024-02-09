package com.inditex.pruebaInditex.daos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ALBUM")
public class Album {

	@Id
	private int id;
	private String title;
	private int userId;
	
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    private List<Photos> photos;


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
	
	

	public List<Photos> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photos> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", userId=" + userId + ", photos=" + photos + "]";
	}



}
