package com.spotviper.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * An album owned by a primary artist. Songs may belong to an album or stand alone (singles).
 */
@Entity
@Table(name = "albums")
@Getter
@Setter
@NoArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(nullable = false, length = 200)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "primary_artist_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_albums_primary_artist"))
    private Artist primaryArtist;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "cover_key", length = 255)
    private String coverKey;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @OneToMany(mappedBy = "album", fetch = FetchType.LAZY)
    private List<Song> songs = new ArrayList<>();
}
