package com.example.examblog.controller;

import com.example.examblog.entity.Personne;
import com.example.examblog.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personne")
public class PersonneController {
    @Autowired
    PersonneService personneService;

    @GetMapping
    public List<Personne> findAll(){
        return personneService.getAllPersonne();
    }

    @GetMapping("/{id}")
    public Personne findAll(@PathVariable("id") Long personneId){
        return personneService.getPersonneById(personneId).get();
    }

    @PostMapping
    public Personne savePersonne(@RequestBody Personne personne){
        return personneService.savePersonne(personne);
    }

    @DeleteMapping("/{id}")
    public void deletePersonne(@PathVariable("id") Long personneId){
        personneService.deletePersonne(personneId);
    }
}
