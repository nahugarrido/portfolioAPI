package com.portfoliov2.app.portfolioAPI.service;

import com.portfoliov2.app.portfolioAPI.entity.Experience;
import com.portfoliov2.app.portfolioAPI.entity.Person;
import com.portfoliov2.app.portfolioAPI.exceptions.PortfolioExceptions;
import com.portfoliov2.app.portfolioAPI.interfaces.IPersonService;
import com.portfoliov2.app.portfolioAPI.interfaces.ISocialService;
import com.portfoliov2.app.portfolioAPI.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpPersonService implements IPersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    ISocialService iSocialService;

    @Override
    public List<Person> getPersons() {

        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long user_id) {
        Person person = personRepository.findById(user_id).orElse(null);

        if(person == null) {
            throw new PortfolioExceptions("Person not found", HttpStatus.NOT_FOUND);
        }

        return person;
    }

    @Override
    public String savePerson(Person person) {
        personRepository.save(person);
        iSocialService.saveSocial(person.getId());
        return "Saved person";
    }

    @Override
    public String updatePerson(long id, Person person) {
        Person updatedPerson = personRepository.findById(id).orElse(null);

        if(updatedPerson == null) {
            throw new PortfolioExceptions("Person not found", HttpStatus.NOT_FOUND);
        }

        updatedPerson.setName(person.getName());
        updatedPerson.setLastName(person.getLastName());
        updatedPerson.setDescription(person.getDescription());
        updatedPerson.setProfileImg(person.getProfileImg());
        updatedPerson.setSeniority(person.getSeniority());
        updatedPerson.setSkills(person.getSkills());

        personRepository.save(updatedPerson);
        return "Updated person";
    }

    @Override
    public String deletePerson(long id) {
        Person deletedPerson = personRepository.findById(id).orElse(null);

        if(deletedPerson == null) {
            throw new PortfolioExceptions("Person not found", HttpStatus.NOT_FOUND);
        }

        personRepository.delete(deletedPerson);
        return "Deleted person";
    }
}
