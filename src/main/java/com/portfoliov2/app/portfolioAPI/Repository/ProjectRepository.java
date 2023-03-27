package com.portfoliov2.app.portfolioAPI.Repository;

import com.portfoliov2.app.portfolioAPI.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
