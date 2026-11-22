package com.moka.moka_api.controller;

import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;

import com.moka.moka_api.dto.AuthResponseDTO;
import com.moka.moka_api.dto.LoginRequestDTO;
import com.moka.moka_api.dto.RegisterRequestDTO;
import com.moka.moka_api.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")

@CrossOrigin(origins = "*")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDTO> register(@Valid @RequestBody RegisterRequestDTO dto) {
        AuthResponseDTO response = authService.register(dto);
        ResponseCookie cookie = authService.generateJwtCookie(response.user());
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginRequestDTO dto) {
        AuthResponseDTO response = authService.login(dto);
        ResponseCookie cookie = authService.generateJwtCookie(response.user());
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(response);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        ResponseCookie cookie = ResponseCookie.from("refreshToken", "")
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(0)
                .build();
        return ResponseEntity.ok()
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
    }

    @PostMapping("/refresh")
    public ResponseEntity<String> refreshToken(
            @CookieValue(name = "refreshToken", defaultValue = "") String refreshToken) {
        if (refreshToken.isEmpty()) {
            return ResponseEntity.status(401).body("Token manquant ou invalide");
        }
        String accessToken = authService.refreshToken(refreshToken);

        return ResponseEntity.ok()
                .body(accessToken);
    }

}
