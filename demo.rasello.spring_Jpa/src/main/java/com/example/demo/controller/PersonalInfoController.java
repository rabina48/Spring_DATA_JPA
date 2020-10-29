package com.example.demo.controller;

import com.example.demo.Repo.PersonalInfoDao;
import com.example.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonalInfoController {

    @Autowired
    private PersonalInfoDao personinfodao;

    public PersonalInfoController(PersonalInfoDao personalInfoDao) {
        this.personinfodao = personalInfoDao;
    }

    @GetMapping(value = "person/getAll")
    public List<Person> findAll() {
       return personinfodao.findAll();

    }

    @GetMapping(value = "person/{name}")
    public Person findByName(@PathVariable String person_name) {
        return personinfodao.findByName(person_name);

    }

    @PostMapping(value = "/person/add")
    public Person addPerson(@RequestBody Person person  ) {
       personinfodao.save(person);
       return personinfodao.findByName(person.getPerson_name());

    }
}



