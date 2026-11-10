package com.moka.moka_api.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.moka.moka_api.dto.AuthResponseDTO;
import com.moka.moka_api.dto.RegisterRequestDTO;
import com.moka.moka_api.dto.UserProfileDTO;
import com.moka.moka_api.model.UserProfile;
import com.moka.moka_api.repository.UserProfileRepository;

@Service

public class AuthService {

    private final UserProfileRepository userProfileRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserProfileRepository userProfileRepository, PasswordEncoder passwordEncoder) {
        this.userProfileRepository = userProfileRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public AuthResponseDTO register(RegisterRequestDTO dto) {
        if (userProfileRepository.findByEmail(dto.email()).isPresent()) {
            throw new IllegalArgumentException("cet email est déjà utilisé");
        }

        String hashedPassword = passwordEncoder.encode(dto.password());

        UserProfile userProfile = UserProfile.builder()
                .email(dto.email())
                .password(hashedPassword)
                .username(dto.username())
                .build();

        String token = "JWT_TOKEN_MOCK";

        UserProfile savedUser = userProfileRepository.save(userProfile);

        UserProfileDTO user = UserProfileDTO.fromEntity(savedUser);

        return new AuthResponseDTO(token, user);
    }
}
