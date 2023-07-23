package com.portfoliov2.app.portfolioAPI.experience.controller;

import com.portfoliov2.app.portfolioAPI.experience.service.IExperienceService;
import com.portfoliov2.app.portfolioAPI.experience.entity.ExperienceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {
    @Autowired
    IExperienceService iExperienceService;

    @GetMapping
    public List<ExperienceEntity> getExperiences() {
        return iExperienceService.getExperiences();
    }

    @PostMapping(value = "/{user_id}/create")
    public String saveExperience(@RequestBody ExperienceEntity experience, @PathVariable Long user_id) {
        return iExperienceService.saveExperience(experience, user_id);
    }

    @PutMapping(value = "/update/{id}")
    public String updateExperience(@PathVariable long id, @RequestBody ExperienceEntity experience) {
        return iExperienceService.updateExperience(id, experience);
    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteExperience(@PathVariable long id) {
        return iExperienceService.deleteExperience(id);
    }

}
