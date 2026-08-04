package com.spotviper.repositories;

import com.spotviper.entities.UserLikedSong;
import com.spotviper.entities.UserLikedSongId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Join entity given its own repository: like / unlike / "is liked" / "my likes" are direct
 * operations rather than something loaded through a parent aggregate. Keyed by the composite id,
 * so inherited {@code existsById(id)} and {@code deleteById(id)} take a {@link UserLikedSongId}.
 */
@Repository
public interface UserLikedSongRepository extends JpaRepository<UserLikedSong, UserLikedSongId> {

    Page<UserLikedSong> findByUser_Id(UUID userId, Pageable pageable);

    long countBySong_Id(UUID songId);
}
