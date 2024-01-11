package com.example.examblog.controller;

import com.example.examblog.entity.Administrateur;
import com.example.examblog.entity.Blog;
import com.example.examblog.service.AdministrateurService;
import com.example.examblog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blog")
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping
    public List<Blog> findAll(){
        return blogService.getAllBlog();
    }

    @GetMapping("/{id}")
    public Blog findBlogById(@PathVariable("id") Long blogId){
        return blogService.getBlogById(blogId).get();
    }

    @PostMapping
    public Blog saveBlog(@RequestBody Blog blog){
        return blogService.saveBlog(blog);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable("id") Long blogId){
        blogService.deleteBlog(blogId);
    }

    @PostMapping("/{blogId}/personne/{personneId}")
    public void assignBlogToPersonne(@PathVariable("blogId") Long blogID, @PathVariable("personneId")Long personneID){
        blogService.assignBlogToPersonne(blogID,personneID);

    }
}
