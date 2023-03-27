package com.portfoliov2.app.portfolioAPI.Repository;

import com.portfoliov2.app.portfolioAPI.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education, Long> {

}
