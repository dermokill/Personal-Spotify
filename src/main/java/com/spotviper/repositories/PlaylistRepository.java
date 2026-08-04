package com.spotviper.repositories;

import com.spotviper.entities.Playlist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, UUID> {

    List<Playlist> findByOwner_Id(UUID ownerId);

    Page<Playlist> findByIsPublicTrue(Pageable pageable);
}
