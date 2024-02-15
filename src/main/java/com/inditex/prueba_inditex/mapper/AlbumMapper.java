package com.inditex.prueba_inditex.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.inditex.prueba_inditex.daos.Album;
import com.inditex.prueba_inditex.daos.Photo;
import com.inditex.prueba_inditex.dto.AlbumDTO;
import com.inditex.prueba_inditex.dto.PhotoDTO;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

	Album toAlbum(AlbumDTO dto);

	AlbumDTO toAlbumsDTO(Album album);
	@Mapping(target = "album.id", source = "albumId")
	Photo toPhoto(PhotoDTO dto);
	
	@Mapping(target = "albumId", source = "album.id")
	PhotoDTO toPhotoDTO(Photo photo);
}