package com.example.examblog.repository;

import com.example.examblog.entity.Blog;
import com.example.examblog.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository  extends JpaRepository<Blog, Long> {
}
