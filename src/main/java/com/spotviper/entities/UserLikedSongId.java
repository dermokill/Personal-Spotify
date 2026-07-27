package com.spotviper.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * Composite key for {@link UserLikedSong}: one entry per (user, song) pair.
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class UserLikedSongId implements Serializable {

    @Column(name = "user_id", columnDefinition = "BINARY(16)")
    private UUID userId;

    @Column(name = "song_id", columnDefinition = "BINARY(16)")
    private UUID songId;

    public UserLikedSongId(UUID userId, UUID songId) {
        this.userId = userId;
        this.songId = songId;
    }
}
