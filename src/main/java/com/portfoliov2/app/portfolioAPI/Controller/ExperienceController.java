package com.portfoliov2.app.portfolioAPI.Controller;

import com.portfoliov2.app.portfolioAPI.Entity.Experience;
import com.portfoliov2.app.portfolioAPI.Interface.IExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExperienceController {
    @Autowired
    IExperienceService iExperienceService;

    @GetMapping(value = "/experience")
    public List<Experience> getExperiences() {
        return iExperienceService.getExperiences();
    }

    @PostMapping(value = "/experience/{user_id}/create")
    public String saveExperience(@RequestBody Experience experience, @PathVariable Long user_id) {
        return iExperienceService.saveExperience(experience, user_id);
    }

    @PutMapping(value = "experience/update/{id}")
    public String updateExperience(@PathVariable long id, @RequestBody Experience experience) {
        return iExperienceService.updateExperience(id, experience);
    }
    @DeleteMapping(value = "experience/delete/{id}")
    public String deleteExperience(@PathVariable long id) {
        return iExperienceService.deleteExperience(id);
    }

}
