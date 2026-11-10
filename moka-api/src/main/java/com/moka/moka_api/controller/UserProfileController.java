package com.moka.moka_api.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.moka.moka_api.dto.UserProfileDTO;

import com.moka.moka_api.service.UserProfileService;

@RestController
@RequestMapping("/api/profile")

@CrossOrigin(origins = "*")
public class UserProfileController {

    private final UserProfileService profileService;

    public UserProfileController(UserProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileDTO> getProfile(@PathVariable String id) {
        return ResponseEntity.ok(profileService.getProfileById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDTO> updateProfile(
            @PathVariable String id,
            @RequestBody UserProfileDTO profileDTO) {
        return ResponseEntity.ok(profileService.updateProfile(id, profileDTO));
    }
}
