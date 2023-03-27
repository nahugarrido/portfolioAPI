package com.portfoliov2.app.portfolioAPI.Service;

import com.portfoliov2.app.portfolioAPI.Entity.Person;
import com.portfoliov2.app.portfolioAPI.Entity.Project;
import com.portfoliov2.app.portfolioAPI.Interface.IProjectService;
import com.portfoliov2.app.portfolioAPI.Repository.PersonRepository;
import com.portfoliov2.app.portfolioAPI.Repository.ProjectRepository;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpProjectService implements IProjectService {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public String saveProject(Project project, Long user_id) {
        Person person = personRepository.findById(user_id).orElse(null);
        person.getProjects().add(project);
        project.setPerson(person);
        personRepository.save(person);
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
        Project UpdatedProject = projectRepository.getReferenceById(id);
        UpdatedProject.setDescription(project.getDescription());
        UpdatedProject.setCategory(project.getCategory());
        UpdatedProject.setImg(project.getImg());
        UpdatedProject.setTitle(project.getTitle());
        UpdatedProject.setRepositoryLink(project.getRepositoryLink());
        UpdatedProject.setLiveSourceLink(project.getLiveSourceLink());
        projectRepository.save(UpdatedProject);
        return "Updated project";
    }
}
