package com.portfoliov2.app.portfolioAPI.controller;

import com.portfoliov2.app.portfolioAPI.entity.Education;
import com.portfoliov2.app.portfolioAPI.interfaces.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EducationController {

    @Autowired
    private IEducationService iEducationService;

    @GetMapping(value = "/education")
    public List<Education> getEducations() {
        return iEducationService.getEducations();
    }

    @PostMapping(value = "/education/{user_id}/create")
    public String saveEducation(@RequestBody Education education, @PathVariable Long user_id) {
        return iEducationService.saveEducation(education, user_id);
    }

    @PutMapping(value = "education/update/{id}")
    public String updateEducation(@PathVariable long id, @RequestBody Education education) {
        return iEducationService.updateEducation(id, education);
    }

    @DeleteMapping(value = "education/delete/{id}")
    public String deleteEducation(@PathVariable long id) {
        return iEducationService.deleteEducation(id);
    }
}

