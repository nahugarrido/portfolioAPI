package com.portfoliov2.app.portfolioAPI.social.repository;

import com.portfoliov2.app.portfolioAPI.social.entity.SocialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialRepository extends JpaRepository<SocialEntity, Long> {
}
