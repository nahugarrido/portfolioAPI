package com.portfoliov2.app.portfolioAPI.interfaces;

import com.portfoliov2.app.portfolioAPI.entity.Project;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProjectService {
    // get all projects
    List<Project> getProjects();

    // Save a new project
    String saveProject(Project project, Long user_id);

    // Delete a project
    String deleteProject(Long id);

    // Update an existing project
    String updateProject(Long id, Project project);
}
