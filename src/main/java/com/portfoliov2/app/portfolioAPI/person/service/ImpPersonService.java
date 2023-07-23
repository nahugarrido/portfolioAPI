package com.portfoliov2.app.portfolioAPI.person.service;

import com.portfoliov2.app.portfolioAPI.exceptions.PortfolioExceptions;
import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import com.portfoliov2.app.portfolioAPI.person.repository.PersonRepository;
import com.portfoliov2.app.portfolioAPI.social.service.ISocialService;
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
    public List<PersonEntity> getPersons() {

        return personRepository.findAll();
    }

    @Override
    public PersonEntity getPersonById(Long user_id) {
        PersonEntity person = personRepository.findById(user_id).orElse(null);

        if(person == null) {
            throw new PortfolioExceptions("Person not found", HttpStatus.NOT_FOUND);
        }

        return person;
    }

    @Override
    public String savePerson(PersonEntity person) {
        personRepository.save(person);
        iSocialService.saveSocial(person.getId());
        return "Saved person";
    }

    @Override
    public String updatePerson(long id, PersonEntity person) {
        PersonEntity updatedPerson = personRepository.findById(id).orElse(null);

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
        PersonEntity deletedPerson = personRepository.findById(id).orElse(null);

        if(deletedPerson == null) {
            throw new PortfolioExceptions("Person not found", HttpStatus.NOT_FOUND);
        }

        personRepository.delete(deletedPerson);
        return "Deleted person";
    }
}
