package com.spotviper.entities.enums;

/**
 * The role an artist plays on a given song. Part of the song_artists composite key,
 * so a single artist can appear on the same song under multiple roles.
 */
public enum ArtistRole {
    MAIN,
    FEATURED,
    REMIX
}
