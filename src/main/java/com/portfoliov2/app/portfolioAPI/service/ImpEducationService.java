package com.portfoliov2.app.portfolioAPI.service;

import com.portfoliov2.app.portfolioAPI.entity.Education;
import com.portfoliov2.app.portfolioAPI.entity.Person;
import com.portfoliov2.app.portfolioAPI.interfaces.IEducationService;
import com.portfoliov2.app.portfolioAPI.interfaces.IPersonService;
import com.portfoliov2.app.portfolioAPI.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpEducationService implements IEducationService {

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    IPersonService iPersonService;

    @Override
    public List<Education> getEducations() {
        return educationRepository.findAll();
    }

    @Override
    public String saveEducation(Education education, Long user_id) {
        Person person = iPersonService.getPersonById(user_id);
        person.getEducations().add(education);
        education.setPerson(person);
        educationRepository.save(education);
        return "Saved education";
    }


    @Override
    public String updateEducation(long id, Education education) {
        Education updatedEducation = educationRepository.getReferenceById(id);
        updatedEducation.setTitle(education.getTitle());
        updatedEducation.setDescription(education.getDescription());
        updatedEducation.setInstitution(education.getInstitution());
        updatedEducation.setStartDate(education.getStartDate());
        updatedEducation.setFinishDate(education.getFinishDate());
        updatedEducation.setImg(education.getImg());
        updatedEducation.setHidden(education.isHidden());
        updatedEducation.setPriority(education.getPriority());
        educationRepository.save(updatedEducation);
        return "Updated education";
    }

    @Override
    public String deleteEducation(long id) {
        Education deletedEducation = educationRepository.getReferenceById(id);
        educationRepository.delete(deletedEducation);
        return "Deleted education";
    }

}
