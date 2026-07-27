package com.spotviper.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

/**
 * Ordered membership of a {@link Song} within a {@link Playlist}. Position is unique per
 * playlist so tracks keep a stable, explicit order.
 */
@Entity
@Table(
        name = "playlist_songs",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_playlist_songs_position", columnNames = {"playlist_id", "position"})
)
@Getter
@Setter
@NoArgsConstructor
public class PlaylistSong {

    @EmbeddedId
    private PlaylistSongId id;

    @MapsId("playlistId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "playlist_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_playlist_songs_playlist"))
    private Playlist playlist;

    @MapsId("songId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "song_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_playlist_songs_song"))
    private Song song;

    @Column(nullable = false)
    private int position;

    @CreationTimestamp
    @Column(name = "added_at", nullable = false, updatable = false)
    private Instant addedAt;

    public PlaylistSong(Playlist playlist, Song song, int position) {
        this.playlist = playlist;
        this.song = song;
        this.position = position;
        this.id = new PlaylistSongId(playlist.getId(), song.getId());
    }
}
