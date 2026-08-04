package com.spotviper.repositories;

import com.spotviper.entities.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SongRepository extends JpaRepository<Song, UUID> {

    List<Song> findByAlbum_IdOrderByTrackNumberAsc(UUID albumId);

    Page<Song> findByTitleContainingIgnoreCase(String query, Pageable pageable);

    /** Atomic play-count bump; avoids a read-modify-write race. */
    @Modifying
    @Query("update Song s set s.playCount = s.playCount + 1 where s.id = :id")
    int incrementPlayCount(@Param("id") UUID id);
}
