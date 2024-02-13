package com.inditex.prueba_inditex.daos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PHOTOS")
public class Photo {
	@Id
	private int id;

	private String title;
	private String url;
	private String thumbnailUrl;

	@ManyToOne
	@JoinColumn(name = "albumId")
	private Album album;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Photos [id=" + id + ", title=" + title + ", url=" + url + ", thumbnailUrl=" + thumbnailUrl + ", album="
				+ album.getId() + "]";
	}



}
