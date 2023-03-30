package com.portfoliov2.app.portfolioAPI.Interface;

import com.portfoliov2.app.portfolioAPI.Entity.Experience;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IExperienceService {

    List<Experience> getExperiences();
    String saveExperience(Experience experience, Long user_id);

    String updateExperience(long id, Experience experience);

    String deleteExperience(long id);



}
