package com.example.examblog.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;
    private String nom;

    @ManyToMany
    @JoinTable(
            name = "Map",
            joinColumns = @JoinColumn(name = "blog_Id", referencedColumnName = "blogId"),
            inverseJoinColumns = @JoinColumn(name = "personne_Id", referencedColumnName = "personneId")
    )
    @JsonIgnore
    private List<Personne> personnes;

    @OneToMany(mappedBy = "blog")
    private List<Billet> billets;


    public Blog() {
    }

    public Blog(String nom) {
        this.nom = nom;
    }



    public Blog(String nom, List<Billet> billets) {
        this.nom = nom;
        this.billets = billets;
    }

    public Blog(Long blogId, String nom, List<Personne> personnes, List<Billet> billets) {
        this.blogId = blogId;
        this.nom = nom;
        this.personnes = personnes;
        this.billets = billets;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Personne> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(List<Personne> personnes) {
        this.personnes = personnes;
    }

    public List<Billet> getBillets() {
        return billets;
    }

    public void setBillets(List<Billet> billets) {
        this.billets = billets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Blog blog = (Blog) o;
        return Objects.equals(blogId, blog.blogId) && Objects.equals(nom, blog.nom) && Objects.equals(personnes, blog.personnes) && Objects.equals(billets, blog.billets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blogId, nom, personnes, billets);
    }

    @Override
    public String toString() {
        return "Blog{" +
                "blogId=" + blogId +
                ", nom='" + nom + '\'' +
                ", personnes=" + personnes +
                ", billets=" + billets +
                '}';
    }


}
