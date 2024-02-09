package com.inditex.pruebaInditex.daos;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PHOTOS")
public class Photos {
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

	@Override
	public String toString() {
		return "Photos [id=" + id + ", title=" + title + ", url=" + url + ", thumbnailUrl=" + thumbnailUrl + ", album="
				+ album + "]";
	}



}
