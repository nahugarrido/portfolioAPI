package com.portfoliov2.app.portfolioAPI.interfaces;

import com.portfoliov2.app.portfolioAPI.entity.Education;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IEducationService {

    // Get all educations
    List<Education> getEducations();

    // save a new education
    String saveEducation(Education education, Long user_id);

    // update an existing education
    String updateEducation(long id, Education education);

    // delete an education
    String deleteEducation(long id);

}
