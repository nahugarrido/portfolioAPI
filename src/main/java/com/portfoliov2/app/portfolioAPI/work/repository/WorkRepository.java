package com.portfoliov2.app.portfolioAPI.work.repository;

import com.portfoliov2.app.portfolioAPI.work.entity.WorkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Long> {
}
