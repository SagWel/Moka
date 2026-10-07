package com.moka.moka_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.moka.moka_api.model.Project;
import com.moka.moka_api.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@Service

@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project creatProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }
}
