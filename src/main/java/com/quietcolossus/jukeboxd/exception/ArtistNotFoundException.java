package com.quietcolossus.jukeboxd.exception;

public class ArtistNotFoundException extends RuntimeException {
    public ArtistNotFoundException(String message) {
        super(message);
    }
}
