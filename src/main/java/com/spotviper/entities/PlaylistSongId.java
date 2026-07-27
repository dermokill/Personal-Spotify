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
 * Composite key for {@link PlaylistSong}: one entry per (playlist, song) pair.
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PlaylistSongId implements Serializable {

    @Column(name = "playlist_id", columnDefinition = "BINARY(16)")
    private UUID playlistId;

    @Column(name = "song_id", columnDefinition = "BINARY(16)")
    private UUID songId;

    public PlaylistSongId(UUID playlistId, UUID songId) {
        this.playlistId = playlistId;
        this.songId = songId;
    }
}
