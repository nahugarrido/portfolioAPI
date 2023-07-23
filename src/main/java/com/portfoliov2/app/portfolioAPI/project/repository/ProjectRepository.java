package com.portfoliov2.app.portfolioAPI.project.repository;

import com.portfoliov2.app.portfolioAPI.project.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
