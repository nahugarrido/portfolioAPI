package com.portfoliov2.app.portfolioAPI.controller;

import com.portfoliov2.app.portfolioAPI.entity.Project;
import com.portfoliov2.app.portfolioAPI.interfaces.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("showcase")
public class ProjectController {

    @Autowired
    IProjectService iProjectService;

    @GetMapping
    public List<Project> getProjects1() {
        return iProjectService.getProjects();
    }

    @PostMapping(value = "/{user_id}/create")
    public String saveProject(@RequestBody Project project, @PathVariable Long user_id) {
        return iProjectService.saveProject(project, user_id);
    }

    @PutMapping(value = "/update/{id}")
    public String updateProject(@PathVariable Long id, @RequestBody Project project) {
        return iProjectService.updateProject(id, project);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        return iProjectService.deleteProject(id);
    }

}
