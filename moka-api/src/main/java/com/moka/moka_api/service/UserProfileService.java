package com.moka.moka_api.service;

import org.springframework.stereotype.Service;

import com.moka.moka_api.dto.UserProfileDTO;
import com.moka.moka_api.model.UserProfile;
import com.moka.moka_api.repository.UserProfileRepository;

@Service

public class UserProfileService {

    private final UserProfileRepository profileRepository;

    public UserProfileService(UserProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public UserProfileDTO getProfileById(String id) {
        UserProfile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profil introuvable pour l'ID : " + id));
        return UserProfileDTO.fromEntity(profile);
    }

    public UserProfileDTO updateProfile(String id, UserProfileDTO dto) {
        UserProfile profile = profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profil introuvable pour l'ID : " + id));

        profile.setUsername(dto.username());
        profile.setAvatarUrl(dto.avatarURML());

        UserProfile updated = profileRepository.save(profile);
        return UserProfileDTO.fromEntity(updated);
    }
}
