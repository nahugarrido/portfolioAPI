package com.portfoliov2.app.portfolioAPI.experience.service;

import com.portfoliov2.app.portfolioAPI.experience.entity.ExperienceEntity;
import com.portfoliov2.app.portfolioAPI.experience.repository.ExperienceRepository;
import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import com.portfoliov2.app.portfolioAPI.exceptions.PortfolioExceptions;
import com.portfoliov2.app.portfolioAPI.person.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpExperienceService implements IExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    IPersonService iPersonService;

    //Date format
    //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public List<ExperienceEntity> getExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public String saveExperience(ExperienceEntity experience, Long user_id) {
        PersonEntity person = iPersonService.getPersonById(user_id);
        person.getExperiences().add(experience);
        experience.setPerson(person);
        experienceRepository.save(experience);
        return "Saved experience";
    }

    @Override
    public String updateExperience(long id, ExperienceEntity experience) {
        ExperienceEntity updatedExperience = experienceRepository.findById(id).orElse(null);

        if(updatedExperience == null) {
            throw new PortfolioExceptions("Experience not found", HttpStatus.NOT_FOUND);
        }

        updatedExperience.setCompany(experience.getCompany());
        updatedExperience.setDescription(experience.getDescription());
        updatedExperience.setFinishDate(experience.getFinishDate());
        updatedExperience.setImg(experience.getImg());
        updatedExperience.setPosition(experience.getPosition());
        updatedExperience.setHidden(experience.isHidden());
        updatedExperience.setStartDate(experience.getStartDate());
        updatedExperience.setPriority(experience.getPriority());

        experienceRepository.save(updatedExperience);
        return "Updated experience";
    }

    @Override
    public String deleteExperience(long id) {
        ExperienceEntity deletedExperience = experienceRepository.findById(id).orElse(null);

        if(deletedExperience == null) {
            throw new PortfolioExceptions("Experience not found", HttpStatus.NOT_FOUND);
        }

        experienceRepository.delete(deletedExperience);
        return "Deleted experience";
    }
}
