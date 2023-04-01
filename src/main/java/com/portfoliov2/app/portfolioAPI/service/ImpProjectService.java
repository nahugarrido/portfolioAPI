package com.portfoliov2.app.portfolioAPI.service;

import com.portfoliov2.app.portfolioAPI.entity.Person;
import com.portfoliov2.app.portfolioAPI.entity.Project;
import com.portfoliov2.app.portfolioAPI.interfaces.IPersonService;
import com.portfoliov2.app.portfolioAPI.interfaces.IProjectService;
import com.portfoliov2.app.portfolioAPI.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpProjectService implements IProjectService {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    IPersonService iPersonService;

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public String saveProject(Project project, Long user_id) {
        Person person = iPersonService.getPersonById(user_id);
        person.getProjects().add(project);
        project.setPerson(person);
        projectRepository.save(project);
        return "Saved project";
    }

    @Override
    public String deleteProject(Long id) {
        Project deletedProject = projectRepository.getReferenceById(id);
        projectRepository.delete(deletedProject);
        return "Deleted project";
    }

    @Override
    public String updateProject(Long id, Project project) {
        Project updatedProject = projectRepository.getReferenceById(id);
        updatedProject.setDescription(project.getDescription());
        updatedProject.setCategory(project.getCategory());
        updatedProject.setImg(project.getImg());
        updatedProject.setTitle(project.getTitle());
        updatedProject.setRepositoryLink(project.getRepositoryLink());
        updatedProject.setLiveSourceLink(project.getLiveSourceLink());
        updatedProject.setPriority(project.getPriority());
        updatedProject.setHidden(project.isHidden());
        projectRepository.save(updatedProject);
        return "Updated project";
    }
}
