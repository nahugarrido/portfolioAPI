package com.portfoliov2.app.portfolioAPI.person.service;

import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IPersonService {
    // Get all persons
    List<PersonEntity> getPersons();

    // Get a specific person
    PersonEntity getPersonById(Long user_id);

    // Save a new person
    String savePerson(PersonEntity person);

    // Update an existing person
    String updatePerson(long id, PersonEntity person);

    // Delete a person
    String deletePerson(long id);

}
