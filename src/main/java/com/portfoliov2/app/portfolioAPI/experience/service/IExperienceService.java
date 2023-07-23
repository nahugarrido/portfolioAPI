package com.portfoliov2.app.portfolioAPI.experience.service;

import com.portfoliov2.app.portfolioAPI.experience.entity.ExperienceEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IExperienceService {

    List<ExperienceEntity> getExperiences();
    String saveExperience(ExperienceEntity experience, Long user_id);

    String updateExperience(long id, ExperienceEntity experience);

    String deleteExperience(long id);



}
