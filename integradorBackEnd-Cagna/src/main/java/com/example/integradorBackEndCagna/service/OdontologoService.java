package com.example.integradorBackEndCagna.service;

import com.example.integradorBackEndCagna.entity.Odontologo;
import com.example.integradorBackEndCagna.entity.dto.OdontologoDto;
import com.example.integradorBackEndCagna.repository.OdontologoRepositoryI;
import com.example.integradorBackEndCagna.service.serviceInterfaces.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService {
    protected final static Logger logger = Logger.getLogger(OdontologoService.class);

    @Autowired
    private OdontologoRepositoryI odontologoRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public Odontologo guardarOdontologo(OdontologoDto odontologoDto) {
        Odontologo odontologo = mapper.convertValue(odontologoDto, Odontologo.class);
        logger.info("Odontologo registrado correctamente: "+ odontologoDto);
        return odontologoRepository.save(odontologo);
    }

    @Override
    public OdontologoDto buscarOdontologo(Integer id) {
        Optional<Odontologo> odontologo = odontologoRepository.findById(id);
        OdontologoDto odontologoDto = null;
        if(odontologo.isPresent())
            odontologoDto = mapper.convertValue(odontologo, OdontologoDto.class);

        logger.info("Se encontro el odontologo correctamente");
        return odontologoDto;
    }

    @Override
    public Odontologo updateOdontologo(OdontologoDto odontologoDto) {
        return null;
    }

    public void eliminarOdontologo(Integer id){
        odontologoRepository.deleteById(id);
        logger.info("Se elimino al odontologo correctamente");

    }

    @Override
    public Set<OdontologoDto> traerTodos() {
        List<Odontologo> odontologos = odontologoRepository.findAll();
        Set<OdontologoDto> odontologosDto = new HashSet<>();

        for (Odontologo o : odontologos) {
            odontologosDto.add(mapper.convertValue(o,OdontologoDto.class));
        }

        logger.info("La busqueda fue exitosa: "+ odontologosDto);
        return odontologosDto;
    }
}
