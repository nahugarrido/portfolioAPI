package com.portfoliov2.app.portfolioAPI.person.controller;

import com.portfoliov2.app.portfolioAPI.person.dto.PersonDTO;
import com.portfoliov2.app.portfolioAPI.person.dto.PersonSaveDTO;
import com.portfoliov2.app.portfolioAPI.person.service.IPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final IPersonService iPersonService;

    public PersonController(IPersonService iPersonService) {
        this.iPersonService = iPersonService;
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> getPersons() {
        return ResponseEntity.ok().body(iPersonService.getPersons());
    }

    @GetMapping(value = "/{user_id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable Long user_id) {
        return ResponseEntity.ok().body(iPersonService.getPersonById(user_id));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<PersonDTO> savePerson(@RequestBody PersonSaveDTO person) {
        PersonDTO aux = iPersonService.savePerson(person);
        URI location = URI.create("/persons/" + aux.getId());
        return ResponseEntity.created(location).body(aux);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable Long id, @RequestBody PersonDTO person) {
        return ResponseEntity.ok().body(iPersonService.updatePerson(id, person));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        iPersonService.deletePerson(id);
        return ResponseEntity.ok().body("Person deleted.");
    }

}
