package com.portfoliov2.app.portfolioAPI.person.service;

import com.portfoliov2.app.portfolioAPI.person.dto.PersonDTO;
import com.portfoliov2.app.portfolioAPI.person.dto.PersonSaveDTO;
import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import org.springframework.stereotype.Service;
import java.util.List;

public interface IPersonService {
    // Get all persons
    List<PersonDTO> getPersons();

    // Get a specific person
    PersonDTO getPersonById(Long user_id);
    PersonEntity getPersonEntityById(Long user_id);

    // Save a new person
    PersonDTO savePerson(PersonSaveDTO person);

    // Update an existing person
    PersonDTO updatePerson(Long id, PersonDTO person);

    // Delete a person
    String deletePerson(Long id);

}
