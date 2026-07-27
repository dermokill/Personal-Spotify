package com.spotviper.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * An artist account. Extends {@link User} via JOINED inheritance: the row shares its id
 * with the corresponding {@code users} row. The artist's public name is the inherited
 * {@code displayName}/{@code username}.
 */
@Entity
@Table(name = "artists")
@PrimaryKeyJoinColumn(name = "id")
@Getter
@Setter
@NoArgsConstructor
public class Artist extends User {

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(name = "image_key", length = 255)
    private String imageKey;

    public Artist(String username, String email, String passwordHash, String displayName) {
        super(username, email, passwordHash, displayName);
    }
}
