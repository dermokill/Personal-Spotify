package com.spotviper.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.UUID;

/**
 * A single play event reported by a client, used for history and (later) simple analytics.
 */
@Entity
@Table(
        name = "listening_history",
        indexes = @Index(name = "idx_listening_history_user_played",
                columnList = "user_id, played_at")
)
@Getter
@Setter
@NoArgsConstructor
public class ListeningHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_listening_history_user"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "song_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_listening_history_song"))
    private Song song;

    @CreationTimestamp
    @Column(name = "played_at", nullable = false, updatable = false)
    private Instant playedAt;

    /** Milliseconds actually listened for this play event. */
    @Column(name = "ms_listened", nullable = false)
    private int msListened;
}
