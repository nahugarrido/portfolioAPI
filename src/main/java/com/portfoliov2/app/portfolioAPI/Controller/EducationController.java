package com.portfoliov2.app.portfolioAPI.Controller;

import com.portfoliov2.app.portfolioAPI.Entity.Education;
import com.portfoliov2.app.portfolioAPI.Repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EducationController {

    @Autowired
    private EducationRepository educationRepository;

    @GetMapping(value = "/")
    public String holaMundo() {
        return "Hola mundo!";
    }

    @GetMapping(value = "/education")
    public List<Education> getEducations() {
        return educationRepository.findAll();
    }

    @PostMapping(value = "/education/create")
    public String saveEducation(@RequestBody Education education) {
        educationRepository.save(education);
        return "Saved education";
    }

    @PutMapping(value = "education/update/{id}")
    public String updateEducation(@PathVariable long id, @RequestBody Education education) {
        Education updatedEducation = educationRepository.getReferenceById(id);
        updatedEducation.setTitle(education.getTitle());
        updatedEducation.setDescription(education.getDescription());
        educationRepository.save(updatedEducation);
        return "Updated education";
    }

    @DeleteMapping(value = "education/delete/{id}")
    public String deleteEducation(@PathVariable long id) {
        Education deletedEducation = educationRepository.getReferenceById(id);
        educationRepository.delete(deletedEducation);
        return "deleted education";
    }
}

