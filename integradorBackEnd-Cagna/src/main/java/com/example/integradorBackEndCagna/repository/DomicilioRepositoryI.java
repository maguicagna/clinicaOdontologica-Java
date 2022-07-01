package com.example.integradorBackEndCagna.repository;

import com.example.integradorBackEndCagna.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepositoryI extends JpaRepository<Domicilio, Integer> {
}
