package com.portfoliov2.app.portfolioAPI.person.repository;

import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
