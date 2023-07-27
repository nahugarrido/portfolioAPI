package com.portfoliov2.app.portfolioAPI.experience.controller;

import com.portfoliov2.app.portfolioAPI.experience.dto.ExperienceDTO;
import com.portfoliov2.app.portfolioAPI.experience.dto.ExperienceSaveDTO;
import com.portfoliov2.app.portfolioAPI.experience.service.IExperienceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {
    private final IExperienceService iExperienceService;

    public ExperienceController(IExperienceService iExperienceService) {
        this.iExperienceService = iExperienceService;
    }

    @GetMapping
    public ResponseEntity<List<ExperienceDTO>> getExperiences() {
        return ResponseEntity.status(HttpStatus.CREATED).body(iExperienceService.getExperiences());
    }

    @PostMapping(value = "/{userId}/create")
    public ResponseEntity<ExperienceDTO> saveExperience(@RequestBody ExperienceSaveDTO experience, @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iExperienceService.saveExperience(experience, userId));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<ExperienceDTO> updateExperience(@RequestBody ExperienceDTO experience, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(iExperienceService.updateExperience(experience, id));
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteExperience(@PathVariable Long id) {
        iExperienceService.deleteExperience(id);
        return ResponseEntity.status(HttpStatus.OK).body("Experience deleted.");
    }

}
