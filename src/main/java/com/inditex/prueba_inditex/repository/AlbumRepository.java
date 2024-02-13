package com.inditex.prueba_inditex.repository;


import org.springframework.stereotype.Repository;

import com.inditex.prueba_inditex.daos.Album;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {

}
