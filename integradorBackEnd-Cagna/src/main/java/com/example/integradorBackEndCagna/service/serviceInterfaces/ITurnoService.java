package com.example.integradorBackEndCagna.service.serviceInterfaces;

import com.example.integradorBackEndCagna.entity.Turno;
import com.example.integradorBackEndCagna.entity.dto.TurnoDto;

import java.util.Set;

public interface ITurnoService {
    public Turno crearTurno(TurnoDto turnoDto);
    public TurnoDto leerTurno(Integer id);
    public Turno updateTurno(TurnoDto turnoDto);
    public void eliminarTurno(Integer id);
    public Set<TurnoDto> leerTodos();
}
