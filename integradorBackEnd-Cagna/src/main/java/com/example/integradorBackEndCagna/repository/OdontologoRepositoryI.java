package com.example.integradorBackEndCagna.repository;

import com.example.integradorBackEndCagna.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OdontologoRepositoryI extends JpaRepository<Odontologo, Integer> {
}
