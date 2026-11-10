package com.moka.moka_api.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moka.moka_api.model.UserProfile;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
    Optional<UserProfile> findByEmail(String email);
}