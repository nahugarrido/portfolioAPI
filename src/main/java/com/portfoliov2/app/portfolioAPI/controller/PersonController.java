package com.portfoliov2.app.portfolioAPI.controller;

import com.portfoliov2.app.portfolioAPI.entity.Person;
import com.portfoliov2.app.portfolioAPI.interfaces.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    IPersonService iPersonService;

    @GetMapping
    public List<Person> getPersons() {
        return iPersonService.getPersons();
    }

    @GetMapping(value = "/{user_id}")
    public Person getPersonById(@PathVariable Long user_id) {
        return iPersonService.getPersonById(user_id);
    }

    @PostMapping(value = "/create")
    public String savePerson(@RequestBody Person person) {
        return iPersonService.savePerson(person);
    }

    @PutMapping(value = "/update/{id}")
    public String updatePerson(@PathVariable long id, @RequestBody Person person) {
        return iPersonService.updatePerson(id, person);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deletePerson(@PathVariable long id) {
        return iPersonService.deletePerson(id);
    }



}
