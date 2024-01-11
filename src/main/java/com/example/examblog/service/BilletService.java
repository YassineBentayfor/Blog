package com.example.examblog.service;


import com.example.examblog.entity.Billet;
import com.example.examblog.entity.Blog;
import com.example.examblog.repository.BilletRepository;
import com.example.examblog.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BilletService {


    @Autowired
    BilletRepository billetRepository;
    @Autowired
    BlogRepository blogRepository;

    public Billet saveBillet(Billet billet){
        return billetRepository.save(billet);
    }

    public List<Billet> getAllBillet(){
        return billetRepository.findAll();
    }

    public Optional<Billet> getBilletById(Long billetId){
        return billetRepository.findById(billetId);
    }

    public void deleteBillet(Long billetId){
        billetRepository.deleteById(billetId);
    }

    public void assignBlogToBuillet(Long blogID, Billet billet){

        Optional<Blog> Opblog = blogRepository.findById(blogID);
        if(Opblog.isPresent()){
            billet.setBlog(Opblog.get());
            billetRepository.save(billet);

        }else {
            throw new IllegalArgumentException("Blog not found");
        }

    }
}
