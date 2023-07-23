package com.portfoliov2.app.portfolioAPI.project.service;

import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import com.portfoliov2.app.portfolioAPI.exceptions.PortfolioException;
import com.portfoliov2.app.portfolioAPI.person.service.IPersonService;
import com.portfoliov2.app.portfolioAPI.project.entity.ProjectEntity;
import com.portfoliov2.app.portfolioAPI.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpProjectService implements IProjectService {

    @Autowired
    ProjectRepository projectRepository;
    @Autowired
    IPersonService iPersonService;

    @Override
    public List<ProjectEntity> getProjects() {
        return projectRepository.findAll();
    }

    @Override
    public String saveProject(ProjectEntity project, Long user_id) {
        PersonEntity person = iPersonService.getPersonEntityById(user_id);
        person.getProjects().add(project);
        project.setPerson(person);
        projectRepository.save(project);
        return "Saved project";
    }

    @Override
    public String deleteProject(Long id) {
        ProjectEntity deletedProject = projectRepository.findById(id).orElse(null);

        if(deletedProject == null) {
            throw new PortfolioException("Project not found", HttpStatus.NOT_FOUND);
        }

        projectRepository.delete(deletedProject);
        return "Deleted project";
    }

    @Override
    public String updateProject(Long id, ProjectEntity project) {
        ProjectEntity updatedProject = projectRepository.findById(id).orElse(null);

        if(updatedProject == null) {
            throw new PortfolioException("Project not found", HttpStatus.NOT_FOUND);
        }

        updatedProject.setDescription(project.getDescription());
        updatedProject.setCategory(project.getCategory());
        updatedProject.setImg(project.getImg());
        updatedProject.setTitle(project.getTitle());
        updatedProject.setRepositoryLink(project.getRepositoryLink());
        updatedProject.setLiveSourceLink(project.getLiveSourceLink());
        updatedProject.setPriority(project.getPriority());
        updatedProject.setHidden(project.isHidden());
        //updatedProject.setShow(project.isShow());

        projectRepository.save(updatedProject);
        return "Updated project";
    }
}
