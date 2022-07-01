package com.example.integradorBackEndCagna.repository;

import com.example.integradorBackEndCagna.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositoryI extends JpaRepository<Paciente,Integer> {
}
