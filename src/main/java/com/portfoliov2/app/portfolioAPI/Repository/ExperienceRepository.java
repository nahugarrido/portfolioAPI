package com.portfoliov2.app.portfolioAPI.Repository;

import com.portfoliov2.app.portfolioAPI.Entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
