package com.portfoliov2.app.portfolioAPI.experience.service;

import com.portfoliov2.app.portfolioAPI.experience.dto.ExperienceDTO;
import com.portfoliov2.app.portfolioAPI.experience.dto.ExperienceSaveDTO;
import com.portfoliov2.app.portfolioAPI.experience.entity.ExperienceEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IExperienceService {
    List<ExperienceDTO> getExperiences();

    ExperienceDTO saveExperience(ExperienceSaveDTO experience, Long user_id);

    ExperienceDTO updateExperience(ExperienceDTO experience, Long id);

    void deleteExperience(Long id);
}
