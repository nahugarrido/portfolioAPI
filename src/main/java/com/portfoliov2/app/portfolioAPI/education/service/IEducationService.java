package com.portfoliov2.app.portfolioAPI.education.service;

import com.portfoliov2.app.portfolioAPI.education.entity.EducationEntity;
import org.springframework.stereotype.Service;
import java.util.List;

public interface IEducationService {

    // Get all educations
    List<EducationEntity> getEducations();

    // save a new education
    String saveEducation(EducationEntity education, Long user_id);

    // update an existing education
    String updateEducation(long id, EducationEntity education);

    // delete an education
    String deleteEducation(long id);

}
