package com.inditex.pruebaInditex.mapper;

import org.mapstruct.Mapper;

import com.inditex.pruebaInditex.daos.Album;
import com.inditex.pruebaInditex.dtos.AlbumDTO;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

	Album toAlbum(AlbumDTO dto);

	AlbumDTO toAlbumsDTO(Album album);
}