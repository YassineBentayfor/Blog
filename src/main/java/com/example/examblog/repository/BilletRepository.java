package com.example.examblog.repository;

import com.example.examblog.entity.Billet;
import com.example.examblog.entity.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilletRepository  extends JpaRepository<Billet, Long> {
}
