package com.portfoliov2.app.portfolioAPI.person.service;

import com.portfoliov2.app.portfolioAPI.exceptions.PortfolioException;
import com.portfoliov2.app.portfolioAPI.person.dto.PersonDTO;
import com.portfoliov2.app.portfolioAPI.person.dto.PersonSaveDTO;
import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import com.portfoliov2.app.portfolioAPI.person.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImpPersonService implements IPersonService {

    private final PersonRepository personRepository;

    private final ModelMapper modelMapper;

    public ImpPersonService(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<PersonDTO> getPersons() {
        List<PersonEntity> listEntities = personRepository.findAll();

        List<PersonDTO> listDTO = new ArrayList<>();

        for(PersonEntity item : listEntities) {
            PersonDTO aux = modelMapper.map(item, PersonDTO.class);
            listDTO.add(aux);
        }

        return listDTO;
    }

    @Override
    public PersonDTO getPersonById(Long user_id) {
        Optional<PersonEntity> person = personRepository.findById(user_id);

        if(person.isEmpty()) {
            throw new PortfolioException("Person not found", HttpStatus.NOT_FOUND);
        }

        return modelMapper.map(person, PersonDTO.class);
    }

    @Override
    public PersonEntity getPersonEntityById(Long user_id) {
        Optional<PersonEntity> person = personRepository.findById(user_id);

        if(person.isEmpty()) {
            throw new PortfolioException("Person not found", HttpStatus.NOT_FOUND);
        }

        return person.get();
    }

    @Override
    public PersonDTO savePerson(PersonSaveDTO savedPerson) {
        PersonEntity personEntity = modelMapper.map(savedPerson, PersonEntity.class);
        personRepository.save(personEntity);

        return modelMapper.map(personEntity, PersonDTO.class);
    }

    @Override
    public PersonDTO updatePerson(Long id, PersonDTO person) {
        Optional<PersonEntity> updatedPerson = personRepository.findById(id);

        if(updatedPerson.isEmpty()) {
            throw new PortfolioException("Person not found", HttpStatus.NOT_FOUND);
        }

        PersonEntity aux = updatedPerson.get();
        aux.setName(person.getName());
        aux.setLastName(person.getLastName());
        aux.setDescription(person.getDescription());
        aux.setProfile(person.getProfile());
        aux.setBanner(person.getBanner());
        aux.setSeniority(person.getSeniority());
        aux.setEmail(person.getEmail());
        aux.setGithub(person.getGithub());
        aux.setLinkedin(person.getLinkedin());
        personRepository.save(aux);

        return modelMapper.map(aux, PersonDTO.class);
    }

    @Override
    public void deletePerson(Long id) {
        Optional<PersonEntity> deletedPerson = personRepository.findById(id);

        if(deletedPerson.isEmpty()) {
            throw new PortfolioException("Person not found", HttpStatus.NOT_FOUND);
        }

        PersonEntity aux = deletedPerson.get();
        personRepository.delete(aux);
    }
}
