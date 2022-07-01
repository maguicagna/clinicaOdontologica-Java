package com.example.integradorBackEndCagna.service;

import com.example.integradorBackEndCagna.entity.Odontologo;
import com.example.integradorBackEndCagna.entity.Paciente;
import com.example.integradorBackEndCagna.entity.Turno;
import com.example.integradorBackEndCagna.entity.dto.TurnoDto;
import com.example.integradorBackEndCagna.repository.OdontologoRepositoryI;
import com.example.integradorBackEndCagna.repository.PacienteRepositoryI;
import com.example.integradorBackEndCagna.repository.TurnoRepositoryI;
import com.example.integradorBackEndCagna.service.serviceInterfaces.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    protected final static Logger logger = Logger.getLogger(TurnoService.class);

    @Autowired
    private TurnoRepositoryI turnoRepository;
    @Autowired
    private PacienteRepositoryI pacienteRepository;
    @Autowired
    private OdontologoRepositoryI odontologoRepository;
    @Autowired
    ObjectMapper mapper;

    @Override
    public Turno crearTurno(TurnoDto turnoDto) {
        Paciente paciente = pacienteRepository.findById(turnoDto.getPaciente().getId()).get();
        Odontologo odontologo = odontologoRepository.findById(turnoDto.getOdontologo().getId()).get();
        turnoDto.setPaciente(paciente);
        turnoDto.setOdontologo(odontologo);
        Turno turno = mapper.convertValue(turnoDto, Turno.class);
        logger.info("Turno registrado correctamente: "+ turnoDto);


        return turno;
    }

    @Override
    public TurnoDto leerTurno(Integer id) {
        Optional<Turno> turno = turnoRepository.findById(id);
        TurnoDto turnoDto = null;
        if(turno.isPresent())
            turnoDto = mapper.convertValue(turno,TurnoDto.class);
        logger.info("La busqueda fue exitosa: id("+id+")");
        return turnoDto;
    }

    @Override
    public Turno updateTurno(TurnoDto turnoDto) {
        logger.info("Turno actualizado correctamente: "+turnoDto);
        return crearTurno(turnoDto);

    }

    @Override
    public void eliminarTurno(Integer id) {
        turnoRepository.deleteById(id);
        logger.info("Se elimino el turno correctamente: "+ "id("+id+")");

    }

    @Override
    public Set<TurnoDto> leerTodos() {
        List<Turno> turnos = turnoRepository.findAll();
        Set<TurnoDto> turnosDto = new HashSet<>();
        for (Turno t: turnos) {
            turnosDto.add(mapper.convertValue(t, TurnoDto.class));

        }
        logger.info("La busqueda fue exitosa: "+ turnosDto);
        return turnosDto;
    }
}
