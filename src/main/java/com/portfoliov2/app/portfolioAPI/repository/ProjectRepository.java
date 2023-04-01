package com.portfoliov2.app.portfolioAPI.repository;

import com.portfoliov2.app.portfolioAPI.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
