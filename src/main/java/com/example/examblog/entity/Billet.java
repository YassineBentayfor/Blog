package com.example.examblog.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Billet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billetId;
    private String date;
    private Long num;
    private String titre;
    private String contenu;
    @ManyToOne
    @JoinColumn(name = "blog_id", referencedColumnName = "blogId")
    private Blog blog;

    @OneToOne
    @JoinColumn(name="personne_id")
    private Personne personne;


    public Billet() {
    }

    public Billet(String date, Long num, String titre, String contenu, Blog blog, Personne personne) {
        this.date = date;
        this.num = num;
        this.titre = titre;
        this.contenu = contenu;
        this.blog = blog;
        this.personne = personne;
    }

    public Billet(String date, Long num, String titre, String contenu, Blog blog) {
        this.date = date;
        this.num = num;
        this.titre = titre;
        this.contenu = contenu;
        this.blog = blog;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Billet billet = (Billet) o;
        return Objects.equals(billetId, billet.billetId) && Objects.equals(date, billet.date) && Objects.equals(num, billet.num) && Objects.equals(titre, billet.titre) && Objects.equals(contenu, billet.contenu) && Objects.equals(blog, billet.blog) && Objects.equals(personne, billet.personne);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billetId, date, num, titre, contenu, blog, personne);
    }

    @Override
    public String toString() {
        return "Billet{" +
                "billetId=" + billetId +
                ", date='" + date + '\'' +
                ", num=" + num +
                ", titre='" + titre + '\'' +
                ", contenu='" + contenu + '\'' +
                ", blog=" + blog +
                ", personne=" + personne +
                '}';
    }

    public Long getBilletId() {
        return billetId;
    }

    public void setBilletId(Long billetId) {
        this.billetId = billetId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}

