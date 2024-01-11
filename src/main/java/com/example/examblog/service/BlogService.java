package com.example.examblog.service;

import com.example.examblog.entity.Blog;
import com.example.examblog.entity.Personne;
import com.example.examblog.repository.BlogRepository;
import com.example.examblog.repository.PersonneRepository;
import com.fasterxml.jackson.databind.BeanProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    PersonneRepository personneRepository;

    public Blog saveBlog(Blog blog){
        return blogRepository.save(blog);
    }

    public List<Blog> getAllBlog(){
        return blogRepository.findAll();
    }

    public Optional<Blog> getBlogById(Long blogId){
        return blogRepository.findById(blogId);
    }

    public void deleteBlog(Long blogId){
        blogRepository.deleteById(blogId);
    }

    public void assignBlogToPersonne(Long blogID, Long personneID){
        Optional<Personne> Oppersonne = personneRepository.findById(personneID);
        Optional<Blog> Opblog = blogRepository.findById(blogID);
        if(Oppersonne.isPresent() && Opblog.isPresent()){
            Personne personne = Oppersonne.get();
            Blog blog = Opblog.get();

            List<Personne> personneList = blog.getPersonnes();
            if (personneList == null){
                personneList = new ArrayList<>();
            }
            personneList.add(personne);
            blog.setPersonnes(personneList);
            blogRepository.save(blog);

        }else {
            throw new IllegalArgumentException("Personne or Blog not found");
        }

    }
}