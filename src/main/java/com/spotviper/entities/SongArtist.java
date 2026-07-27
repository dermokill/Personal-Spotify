package com.spotviper.entities;

import com.spotviper.entities.enums.ArtistRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Association between a {@link Song} and a contributing {@link Artist} with a specific
 * {@link ArtistRole}. Carries data (the role), so modeled as an entity rather than @ManyToMany.
 */
@Entity
@Table(name = "song_artists")
@Getter
@Setter
@NoArgsConstructor
public class SongArtist {

    @EmbeddedId
    private SongArtistId id;

    @MapsId("songId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "song_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_song_artists_song"))
    private Song song;

    @MapsId("artistId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artist_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_song_artists_artist"))
    private Artist artist;

    public SongArtist(Song song, Artist artist, ArtistRole role) {
        this.song = song;
        this.artist = artist;
        this.id = new SongArtistId(song.getId(), artist.getId(), role);
    }

    @Transient
    public ArtistRole getRole() {
        return id != null ? id.getRole() : null;
    }
}
