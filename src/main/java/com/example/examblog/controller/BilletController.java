package com.example.examblog.controller;

import com.example.examblog.entity.Billet;
import com.example.examblog.entity.Blog;
import com.example.examblog.service.BilletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("billet")
public class BilletController {

    @Autowired
    BilletService billetService;

    @GetMapping
    public List<Billet> findAll(){
        return billetService.getAllBillet();
    }

    @GetMapping("/{id}")
    public Billet findBilletById(@PathVariable("id") Long billetId){
        return billetService.getBilletById(billetId).get();
    }

    @PostMapping
    public Billet saveBillet(@RequestBody Billet billet){
        return billetService.saveBillet(billet);
    }

    @DeleteMapping("/{id}")
    public void deleteBillet(@PathVariable("id") Long billetId){
        billetService.deleteBillet(billetId);
    }


    @PostMapping("/blog/{blogId}")
    public void assignBlogToBillet(@PathVariable("blogId") Long blogId, @RequestBody Billet billet){
        billetService.assignBlogToBuillet(blogId,billet);
    }


}
