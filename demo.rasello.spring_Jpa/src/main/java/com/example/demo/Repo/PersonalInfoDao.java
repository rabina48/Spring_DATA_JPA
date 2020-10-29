package com.example.demo.Repo;

import com.example.demo.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public interface PersonalInfoDao extends JpaRepository<Person, Integer> {
    Person findByName(String person_name);

}
