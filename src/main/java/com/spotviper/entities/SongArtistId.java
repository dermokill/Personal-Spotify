package com.spotviper.entities;

import com.spotviper.entities.enums.ArtistRole;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * Composite key for {@link SongArtist}. Role is part of the key so the same artist can
 * appear on a song under multiple roles (e.g. MAIN and REMIX).
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class SongArtistId implements Serializable {

    @Column(name = "song_id", columnDefinition = "BINARY(16)")
    private UUID songId;

    @Column(name = "artist_id", columnDefinition = "BINARY(16)")
    private UUID artistId;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", length = 20)
    private ArtistRole role;

    public SongArtistId(UUID songId, UUID artistId, ArtistRole role) {
        this.songId = songId;
        this.artistId = artistId;
        this.role = role;
    }
}
