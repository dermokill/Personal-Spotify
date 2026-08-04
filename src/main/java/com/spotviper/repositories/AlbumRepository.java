package com.spotviper.repositories;

import com.spotviper.entities.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AlbumRepository extends JpaRepository<Album, UUID> {

    List<Album> findByPrimaryArtist_Id(UUID artistId);

    Page<Album> findByTitleContainingIgnoreCase(String query, Pageable pageable);
}
