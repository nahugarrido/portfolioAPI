package com.portfoliov2.app.portfolioAPI.project.service;

import com.portfoliov2.app.portfolioAPI.project.entity.ProjectEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IProjectService {
    // get all projects
    List<ProjectEntity> getProjects();

    // Save a new project
    String saveProject(ProjectEntity project, Long user_id);

    // Delete a project
    String deleteProject(Long id);

    // Update an existing project
    String updateProject(Long id, ProjectEntity project);
}
