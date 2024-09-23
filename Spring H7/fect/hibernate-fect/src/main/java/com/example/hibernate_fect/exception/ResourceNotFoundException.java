package com.example.hibernate_fect.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Pengecualian ini dilempar ketika sumber daya tidak ditemukan.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Konstruktor dengan pesan.
     *
     * @param message Pesan pengecualian
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Konstruktor dengan pesan dan penyebab.
     *
     * @param message Pesan pengecualian
     * @param cause   Penyebab pengecualian
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
