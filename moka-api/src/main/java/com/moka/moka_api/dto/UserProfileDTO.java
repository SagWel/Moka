package com.moka.moka_api.dto;

import com.moka.moka_api.model.UserProfile;

public record UserProfileDTO(
        String id,
        String email,
        String avatarURML) {
    public static UserProfileDTO fromEntity(UserProfile profile) {
        return new UserProfileDTO(
                profile.getId(),
                profile.getEmail(),
                profile.getAvatarUrl());
    }
}
