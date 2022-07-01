package com.example.integradorBackEndCagna.service;

import com.example.integradorBackEndCagna.entity.Paciente;
import com.example.integradorBackEndCagna.entity.dto.PacienteDto;
import com.example.integradorBackEndCagna.repository.DomicilioRepositoryI;
import com.example.integradorBackEndCagna.repository.PacienteRepositoryI;
import com.example.integradorBackEndCagna.service.serviceInterfaces.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService {

    protected final static Logger logger = Logger.getLogger(PacienteService.class);

    @Autowired
    private PacienteRepositoryI pacienteRepository;
    @Autowired
    private DomicilioRepositoryI domicilioIRepository;
    @Autowired
    ObjectMapper mapper;

    public Paciente guardarPaciente(PacienteDto pacienteDto){
        Paciente paciente = mapper.convertValue(pacienteDto,Paciente.class);
        logger.info("Odontologo registrado correctamente: "+ pacienteDto);
        return pacienteRepository.save(paciente);
    }

    @Override
    public PacienteDto traerPaciente(Integer id) {
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        PacienteDto pacienteDto = null;
        if(paciente.isPresent()){
            pacienteDto = mapper.convertValue(paciente,PacienteDto.class);
            logger.info("Se encontro el paciente: " + pacienteDto);
        }

        return pacienteDto;
    }

    @Override
    public Paciente updatePaciente(PacienteDto pacienteDto) {
        logger.info("Paciente actualizado correctamente: "+ pacienteDto);
        return guardarPaciente(pacienteDto);


    }


    public void eliminarPaciente(Integer id){
        pacienteRepository.deleteById(id);
        logger.info("Se elimino al paciente correctamente");

    }

    @Override
    public Set<PacienteDto> traerTodos() {
        List<Paciente> pacientes = pacienteRepository.findAll();
        Set<PacienteDto> pacientesDto = new HashSet<>();

        for (Paciente p : pacientes) {
            pacientesDto.add(mapper.convertValue(p,PacienteDto.class));
        }

        logger.info("La busqueda fue exitosa: "+ pacientesDto);
        return pacientesDto;
    }
}
