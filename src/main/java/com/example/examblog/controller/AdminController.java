package com.example.examblog.controller;

import com.example.examblog.entity.Administrateur;
import com.example.examblog.entity.Personne;
import com.example.examblog.service.AdministrateurService;
import com.example.examblog.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    AdministrateurService administrateurService;

    @GetMapping
    public List<Administrateur> findAll(){
        return administrateurService.getAllAdmin();
    }

    @GetMapping("/{id}")
    public Administrateur findAdminById(@PathVariable("id") Long adminId){
        return administrateurService.getAdminById(adminId).get();
    }

    @PostMapping
    public Administrateur savePAdmin(@RequestBody Administrateur administrateur){
        return administrateurService.saveAdmin(administrateur);
    }

    @DeleteMapping("/{id}")
    public void deletePAdmin(@PathVariable("id") Long amdinId){
        administrateurService.deleteAdmin(amdinId);
    }
}
