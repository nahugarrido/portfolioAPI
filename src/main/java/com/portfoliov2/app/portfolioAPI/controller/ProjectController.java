package com.portfoliov2.app.portfolioAPI.controller;

import com.portfoliov2.app.portfolioAPI.entity.Project;
import com.portfoliov2.app.portfolioAPI.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    IProjectService iProjectService;

    @GetMapping(value = "/showcase")
    public List<Project> getProjects1() {
        return iProjectService.getProjects();
    }

    @PostMapping(value = "/showcase/{user_id}/create")
    public String saveProject(@RequestBody Project project, @PathVariable Long user_id) {
        return iProjectService.saveProject(project, user_id);
    }

    @PutMapping(value = "showcase/update/{id}")
    public String updateProject(@PathVariable Long id, @RequestBody Project project) {
        return iProjectService.updateProject(id, project);
    }

    @DeleteMapping(value = "showcase/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        return iProjectService.deleteProject(id);
    }

}
