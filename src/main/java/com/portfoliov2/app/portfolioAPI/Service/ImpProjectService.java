package com.portfoliov2.app.portfolioAPI.Service;

import com.portfoliov2.app.portfolioAPI.Entity.Person;
import com.portfoliov2.app.portfolioAPI.Entity.Project;
import com.portfoliov2.app.portfolioAPI.Interface.IPersonService;
import com.portfoliov2.app.portfolioAPI.Interface.IProjectService;
import com.portfoliov2.app.portfolioAPI.Repository.ProjectRepository;
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
