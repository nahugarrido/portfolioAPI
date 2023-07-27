package com.portfoliov2.app.portfolioAPI.education.repository;

import com.portfoliov2.app.portfolioAPI.education.entity.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends JpaRepository<EducationEntity, Long> {

}
