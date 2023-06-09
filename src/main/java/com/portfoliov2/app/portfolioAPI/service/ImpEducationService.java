package com.portfoliov2.app.portfolioAPI.service;

import com.portfoliov2.app.portfolioAPI.entity.Education;
import com.portfoliov2.app.portfolioAPI.entity.Experience;
import com.portfoliov2.app.portfolioAPI.entity.Person;
import com.portfoliov2.app.portfolioAPI.exceptions.PortfolioExceptions;
import com.portfoliov2.app.portfolioAPI.interfaces.IEducationService;
import com.portfoliov2.app.portfolioAPI.interfaces.IPersonService;
import com.portfoliov2.app.portfolioAPI.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ImpEducationService implements IEducationService {

    @Autowired
    EducationRepository educationRepository;

    @Autowired
    IPersonService iPersonService;

    //Date format
    //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

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
        Education updatedEducation = educationRepository.findById(id).orElse(null);

        if(updatedEducation == null) {
            throw new PortfolioExceptions("Education not found", HttpStatus.NOT_FOUND);
        }

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
        Education deletedEducation = educationRepository.findById(id).orElse(null);

        if(deletedEducation == null) {
            throw new PortfolioExceptions("Education not found", HttpStatus.NOT_FOUND);
        }


        educationRepository.delete(deletedEducation);
        return "Deleted education";
    }

}
