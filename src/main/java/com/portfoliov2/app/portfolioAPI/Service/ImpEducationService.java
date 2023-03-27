package com.portfoliov2.app.portfolioAPI.Service;

import com.portfoliov2.app.portfolioAPI.Entity.Education;
import com.portfoliov2.app.portfolioAPI.Entity.Person;
import com.portfoliov2.app.portfolioAPI.Interface.IEducationService;
import com.portfoliov2.app.portfolioAPI.Repository.EducationRepository;
import com.portfoliov2.app.portfolioAPI.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpEducationService implements IEducationService {

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Education> getEducations() {
        return educationRepository.findAll();
    }

    @Override
    public String saveEducation(Education education, Long user_id) {
        Person person = personRepository.findById(user_id).orElse(null);
        person.getEducations().add(education);
        education.setPerson(person);
        personRepository.save(person);
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
