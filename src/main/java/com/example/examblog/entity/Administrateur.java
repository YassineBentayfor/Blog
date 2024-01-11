package com.example.examblog.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue(value = "Administrateur")
public class Administrateur extends Personne{

    @OneToOne
    @JoinColumn(name= "blog_id")
    private Blog blog;


    public void attributRole(){

    }

}
