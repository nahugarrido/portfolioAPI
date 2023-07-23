package com.portfoliov2.app.portfolioAPI.person.service;

import com.portfoliov2.app.portfolioAPI.exceptions.PortfolioException;
import com.portfoliov2.app.portfolioAPI.person.dto.PersonDTO;
import com.portfoliov2.app.portfolioAPI.person.dto.PersonSaveDTO;
import com.portfoliov2.app.portfolioAPI.person.entity.PersonEntity;
import com.portfoliov2.app.portfolioAPI.person.repository.PersonRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImpPersonService implements IPersonService {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    ModelMapper modelMapper;

    ///@Autowired
    ///ISocialService iSocialService;

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

        PersonDTO dto = modelMapper.map(person, PersonDTO.class);

        return dto;
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
        ///iSocialService.saveSocial(personEntity.getId());
        PersonDTO dto = modelMapper.map(personEntity, PersonDTO.class);

        return dto;
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
        personRepository.save(aux);

        PersonDTO dto = modelMapper.map(aux, PersonDTO.class);
        return dto;
    }

    @Override
    public String deletePerson(Long id) {
        Optional<PersonEntity> deletedPerson = personRepository.findById(id);

        if(deletedPerson.isEmpty()) {
            throw new PortfolioException("Person not found", HttpStatus.NOT_FOUND);
        }

        PersonEntity aux = deletedPerson.get();
        personRepository.delete(aux);

        return "Deleted Person with id " + aux.getId();
    }
}
