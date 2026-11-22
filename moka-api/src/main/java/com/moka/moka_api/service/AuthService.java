package com.moka.moka_api.service;

import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import com.moka.moka_api.dto.LoginRequestDTO;
import com.moka.moka_api.dto.AuthResponseDTO;
import com.moka.moka_api.dto.RegisterRequestDTO;
import com.moka.moka_api.dto.UserProfileDTO;
import com.moka.moka_api.model.UserProfile;
import com.moka.moka_api.repository.UserProfileRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserProfileRepository userProfileRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Value("${jwt.expiration.refresh}")
    private long refreshTokenExpiration;

    public ResponseCookie generateJwtCookie(UserProfileDTO userProfileDTO) {
        String refreshToken = jwtService.generateRefreshToken(userProfileDTO);
        return ResponseCookie.from("refreshToken", refreshToken)
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(refreshTokenExpiration)
                .sameSite("Strict")
                .build();
    }

    public AuthResponseDTO register(RegisterRequestDTO dto) {
        if (userProfileRepository.findByEmail(dto.email()).isPresent()) {
            throw new IllegalArgumentException("cet email est déjà utilisé");
        }

        String hashedPassword = passwordEncoder.encode(dto.password());

        UserProfile userProfile = UserProfile.builder()
                .email(dto.email())
                .password(hashedPassword)
                .build();

        UserProfile savedUser = userProfileRepository.save(userProfile);

        UserProfileDTO user = UserProfileDTO.fromEntity(savedUser);

        String accessToken = jwtService.generateAccesToken(user);

        return new AuthResponseDTO(accessToken, user);
    }

    public AuthResponseDTO login(LoginRequestDTO dto) {
        if (userProfileRepository.findByEmail(dto.email()).isPresent()) {

            UserProfile loginUser = userProfileRepository.findByEmail(dto.email())
                    .orElseThrow(() -> new IllegalArgumentException("Email inexistant"));

            if (passwordEncoder.matches(dto.password(), loginUser.getPassword())) {
                UserProfileDTO user = UserProfileDTO.fromEntity(loginUser);

                String accessToken = jwtService.generateAccesToken(user);

                return new AuthResponseDTO(accessToken, user);

            } else {
                throw new IllegalArgumentException("mot de passe Incorrect");
            }
        } else {
            throw new IllegalArgumentException("email innexistant");
        }
    }

    public String refreshToken(String refreshToken) {
        String userId = jwtService.extractUserId(refreshToken);

        if (jwtService.isTokenValid(refreshToken, userId)) {
            UserProfile user = userProfileRepository.findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("Utilisateur introuvable"));

            UserProfileDTO userDto = UserProfileDTO.fromEntity(user);
            return jwtService.generateAccesToken(userDto);
        } else {
            throw new IllegalArgumentException("Token invalide. Deconnexion de l'utilisateur");
        }
    }
}
