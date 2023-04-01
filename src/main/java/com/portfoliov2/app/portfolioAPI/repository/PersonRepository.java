package com.portfoliov2.app.portfolioAPI.repository;

import com.portfoliov2.app.portfolioAPI.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
