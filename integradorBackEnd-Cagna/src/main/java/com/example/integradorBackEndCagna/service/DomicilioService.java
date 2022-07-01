package com.example.integradorBackEndCagna.service;

import com.example.integradorBackEndCagna.entity.Domicilio;
import com.example.integradorBackEndCagna.repository.DomicilioRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService {

    @Autowired
    private DomicilioRepositoryI domicilioIRepository;

    public Domicilio guardar(Domicilio domicilio){
        domicilioIRepository.save(domicilio);
        return domicilio;
    }

    public Optional<Domicilio> buscar(Integer id){
        return Optional.of(domicilioIRepository.getOne(Integer.valueOf(id)));
    }

    public List<Domicilio> buscarTodos(){return domicilioIRepository.findAll();}

    public void eliminarDomicilio(Integer id){domicilioIRepository.deleteById(id);}
}
