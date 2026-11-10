package com.moka.moka_api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.moka.moka_api.model.Project;

public interface ProjectRepository extends MongoRepository<Project, String> {
    List<Project> findByAccountId(String accountId);
}
