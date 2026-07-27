package com.spotviper.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

/**
 * A user's "liked" mark on a song.
 */
@Entity
@Table(name = "user_liked_songs")
@Getter
@Setter
@NoArgsConstructor
public class UserLikedSong {

    @EmbeddedId
    private UserLikedSongId id;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_liked_songs_user"))
    private User user;

    @MapsId("songId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "song_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_user_liked_songs_song"))
    private Song song;

    @CreationTimestamp
    @Column(name = "liked_at", nullable = false, updatable = false)
    private Instant likedAt;

    public UserLikedSong(User user, Song song) {
        this.user = user;
        this.song = song;
        this.id = new UserLikedSongId(user.getId(), song.getId());
    }
}
