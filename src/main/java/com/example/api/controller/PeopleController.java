package com.example.api.controller;

import com.example.api.kafka.PeopleProducer;
import com.example.api.model.Person;
import com.example.api.service.PeopleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PeopleController {

    private final PeopleService peopleService;
    private final PeopleProducer peopleProducer;


    @GetMapping("/person")
    public List<Person> getPeople() {
        return peopleService.findAll();
    }

    @GetMapping("/person/{id}")
    public Person getPerson(@PathVariable("id") int id) {
        return peopleService.findPerson(id);
    }

    @PostMapping("/person")
    public ResponseEntity<HttpStatus> create(@RequestBody Person person) {
        peopleService.savePerson(person);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/person/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id) {
        peopleService.deletePerson(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/kafka")
    public void kafkaTest(@RequestBody Person person) {
        peopleProducer.send("AAA",person);
    }
}
