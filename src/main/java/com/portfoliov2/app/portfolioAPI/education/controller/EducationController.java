package com.portfoliov2.app.portfolioAPI.education.controller;

import com.portfoliov2.app.portfolioAPI.education.dto.EducationDTO;
import com.portfoliov2.app.portfolioAPI.education.dto.EducationSaveDTO;
import com.portfoliov2.app.portfolioAPI.education.service.IEducationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educations")
public class EducationController {

    private final IEducationService iEducationService;

    public EducationController(IEducationService iEducationService) {
        this.iEducationService = iEducationService;
    }

    @GetMapping
    public ResponseEntity<List<EducationDTO>> getEducations() {
        return ResponseEntity.status(HttpStatus.CREATED).body(iEducationService.getEducations());
    }

    @PostMapping(value = "/{userId}/create")
    public ResponseEntity<EducationDTO> saveEducation(@RequestBody EducationSaveDTO education, @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iEducationService.saveEducation(education, userId));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<EducationDTO> updateEducation(@RequestBody EducationDTO education, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(iEducationService.updateEducation(education, id));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteEducation(@PathVariable Long id) {
        iEducationService.deleteEducation(id);
        return ResponseEntity.status(HttpStatus.OK).body("Education deleted.");
    }
}

