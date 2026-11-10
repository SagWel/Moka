package com.moka.moka_api.dto;

public record AuthResponseDTO(
        String token,
        UserProfileDTO user) {
}
