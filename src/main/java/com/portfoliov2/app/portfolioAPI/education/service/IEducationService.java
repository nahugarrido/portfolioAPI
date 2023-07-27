package com.portfoliov2.app.portfolioAPI.education.service;

import com.portfoliov2.app.portfolioAPI.education.dto.EducationDTO;
import com.portfoliov2.app.portfolioAPI.education.dto.EducationSaveDTO;
import com.portfoliov2.app.portfolioAPI.education.entity.EducationEntity;
import org.springframework.stereotype.Service;
import java.util.List;

public interface IEducationService {

    // Get all educations
    List<EducationDTO> getEducations();

    // save a new education
    EducationDTO saveEducation(EducationSaveDTO education, Long userId);

    // update an existing education
    EducationDTO updateEducation(EducationDTO education, Long id);

    // delete an education
    void deleteEducation(Long id);

}
