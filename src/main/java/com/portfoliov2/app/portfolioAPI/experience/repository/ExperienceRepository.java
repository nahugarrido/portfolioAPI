package com.portfoliov2.app.portfolioAPI.experience.repository;

import com.portfoliov2.app.portfolioAPI.experience.entity.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Long> {
}
