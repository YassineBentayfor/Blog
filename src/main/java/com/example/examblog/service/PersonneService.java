package com.example.examblog.service;

import com.example.examblog.entity.Personne;
import com.example.examblog.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneService {
    @Autowired
    PersonneRepository personneRepository;

    public Personne savePersonne(Personne personne){
        return personneRepository.save(personne);
    }

    public List<Personne> getAllPersonne(){
        return personneRepository.findAll();
    }

    public Optional<Personne> getPersonneById(Long personnneId){
        return personneRepository.findById(personnneId);
    }

    public void deletePersonne(Long personneId){
        personneRepository.deleteById(personneId);
    }
}
