package com.portfoliov2.app.portfolioAPI.interfaces;

import com.portfoliov2.app.portfolioAPI.entity.Person;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IPersonService {
    // Get all persons
    List<Person> getPersons();

    // Get a specific person
    Person getPersonById(Long user_id);

    // Save a new person
    String savePerson(Person person);

    // Update an existing person
    String updatePerson(long id, Person person);

    // Delete a person
    String deletePerson(long id);

}
