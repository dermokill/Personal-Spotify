package com.spotviper.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

/**
 * A playable track. References a storage key (never an absolute path) resolved by the
 * StorageService. Contributing artists are modeled through {@link SongArtist}.
 */
@Entity
@Table(name = "songs")
@Getter
@Setter
@NoArgsConstructor
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false, length = 200)
    private String title;

    /** Nullable: singles have no album. */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id",
            foreignKey = @ForeignKey(name = "fk_songs_album"))
    private Album album;

    @Column(name = "track_number")
    private Integer trackNumber;

    @Column(name = "duration_ms", nullable = false)
    private int durationMs;

    @Column(name = "file_key", nullable = false, length = 255)
    private String fileKey;

    @Column(name = "mime_type", nullable = false, length = 50)
    private String mimeType = "audio/mpeg";

    @Column(name = "size_bytes", nullable = false)
    private long sizeBytes;

    @Column(name = "play_count", nullable = false)
    private long playCount = 0L;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @OneToMany(mappedBy = "song", fetch = FetchType.LAZY)
    private Set<SongArtist> artists = new LinkedHashSet<>();
}
