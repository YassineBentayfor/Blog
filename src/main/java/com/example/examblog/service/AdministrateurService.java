package com.example.examblog.service;


import com.example.examblog.entity.Administrateur;
import com.example.examblog.entity.Personne;
import com.example.examblog.repository.AdministrateurRepository;
import com.example.examblog.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrateurService {
    @Autowired
    AdministrateurRepository administrateurRepository;

    public Administrateur saveAdmin(Administrateur administrateur){
        return administrateurRepository.save(administrateur);
    }

    public List<Administrateur> getAllAdmin(){
        return administrateurRepository.findAll();
    }

    public Optional<Administrateur> getAdminById(Long adminId){
        return administrateurRepository.findById(adminId);
    }

    public void deleteAdmin(Long adminId){
        administrateurRepository.deleteById(adminId);
    }
}
