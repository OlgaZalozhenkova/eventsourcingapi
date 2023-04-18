package com.example.api.service;

import com.example.api.model.Person;
import com.example.api.repositories.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class PeopleService {

    private  final PeopleRepository peopleRepository;


    @Transactional
    public void deletePerson(int id) {
        peopleRepository.deleteById(id);
    }


    @Transactional
    public void savePerson(Person person) {
        peopleRepository.save(person);
    }


    public Person findPerson(int id) {
        Optional<Person> person = peopleRepository.findById(id);
        return person.orElse(null);
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }
}
