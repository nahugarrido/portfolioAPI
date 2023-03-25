package com.portfoliov2.app.portfolioAPI.Repository;

import com.portfoliov2.app.portfolioAPI.Entity.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationRepository extends JpaRepository<Education, Long> {
}
