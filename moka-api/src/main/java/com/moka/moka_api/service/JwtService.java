package com.moka.moka_api.service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.moka.moka_api.dto.UserProfileDTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    private SecretKey getSignInKey() {
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Value("${jwt.expiration.access}")
    private long accessTokenExpiration;

    @Value("${jwt.expiration.refresh}")
    private long refreshTokenExpiration;

    public String generateAccesToken(UserProfileDTO userProfileDTO) {
        long now = System.currentTimeMillis();
        long expiration = now + accessTokenExpiration;

        return Jwts.builder()
                .subject(userProfileDTO.id())
                .issuedAt(new Date(now))
                .expiration(new Date(expiration))
                .signWith(getSignInKey())
                .compact();
    }

    public String generateRefreshToken(UserProfileDTO userProfileDTO) {
        long now = System.currentTimeMillis();
        long expiration = now + refreshTokenExpiration;

        return Jwts.builder()
                .subject(userProfileDTO.id())
                .issuedAt(new Date(now))
                .expiration(new Date(expiration))
                .signWith(getSignInKey())
                .compact();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUserId(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public boolean isTokenExpired(String token) {
        return extractClaim(token, Claims::getExpiration).before(new Date());
    }

    public boolean isTokenValid(String token, String userId) {
        final String extractedUserId = extractUserId(token);
        return (extractedUserId.equals(userId)) && !isTokenExpired(token);
    }
}
