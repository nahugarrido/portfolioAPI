package com.portfoliov2.app.portfolioAPI.Service;

import com.portfoliov2.app.portfolioAPI.Entity.Experience;
import com.portfoliov2.app.portfolioAPI.Entity.Person;
import com.portfoliov2.app.portfolioAPI.Interface.IExperienceService;
import com.portfoliov2.app.portfolioAPI.Interface.IPersonService;
import com.portfoliov2.app.portfolioAPI.Repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpExperienceService implements IExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    IPersonService iPersonService;

    @Override
    public List<Experience> getExperiences() {
        return experienceRepository.findAll();
    }

    @Override
    public String saveExperience(Experience experience, Long user_id) {
        Person person = iPersonService.getPersonById(user_id);
        person.getExperiences().add(experience);
        experience.setPerson(person);
        experienceRepository.save(experience);
        return "Saved experience";
    }

    @Override
    public String updateExperience(long id, Experience experience) {
        Experience updatedExperience = experienceRepository.findById(id).orElse(null);
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
        Experience deletedExperience = experienceRepository.getReferenceById(id);
        experienceRepository.delete(deletedExperience);
        return "Deleted experience";
    }
}
