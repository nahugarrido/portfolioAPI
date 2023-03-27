package com.portfoliov2.app.portfolioAPI.Repository;

import com.portfoliov2.app.portfolioAPI.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
