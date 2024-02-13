package com.inditex.prueba_inditex.mapper;

import org.mapstruct.Mapper;

import com.inditex.prueba_inditex.daos.Album;
import com.inditex.prueba_inditex.daos.Photo;
import com.inditex.prueba_inditex.dto.AlbumDTO;
import com.inditex.prueba_inditex.dto.PhotoDTO;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

	Album toAlbum(AlbumDTO dto);

	AlbumDTO toAlbumsDTO(Album album);

	Photo toPhoto(PhotoDTO dto);

	PhotoDTO toPhotoDTO(Photo photo);
}