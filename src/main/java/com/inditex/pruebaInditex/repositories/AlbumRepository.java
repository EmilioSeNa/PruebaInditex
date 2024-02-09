package com.inditex.pruebaInditex.repositories;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.inditex.pruebaInditex.daos.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
