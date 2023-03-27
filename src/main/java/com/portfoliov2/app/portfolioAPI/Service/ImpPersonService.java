package com.portfoliov2.app.portfolioAPI.Service;
import com.portfoliov2.app.portfolioAPI.Entity.Person;
import com.portfoliov2.app.portfolioAPI.Interface.IPersonService;
import com.portfoliov2.app.portfolioAPI.Interface.ISocialService;
import com.portfoliov2.app.portfolioAPI.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return personRepository.findById(user_id).orElse(null);
    }

    @Override
    public String savePerson(Person person) {
        personRepository.save(person);
        return "Saved person";
    }

    @Override
    public String updatePerson(long id, Person person) {
        Person updatedPerson = personRepository.getReferenceById(id);
        updatedPerson.setName(person.getName());
        updatedPerson.setLastName(person.getLastName());
        updatedPerson.setDescription(person.getDescription());
        updatedPerson.setProfileImg(person.getProfileImg());
        updatedPerson.setSeniority(person.getSeniority());
        personRepository.save(updatedPerson);
        return "Updated person";
    }

    @Override
    public String deletePerson(long id) {
        Person deletedPerson = personRepository.getReferenceById(id);
        personRepository.delete(deletedPerson);
        return "Deleted person";
    }
}
