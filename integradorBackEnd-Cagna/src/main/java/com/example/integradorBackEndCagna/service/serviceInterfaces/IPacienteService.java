package com.example.integradorBackEndCagna.service.serviceInterfaces;

import com.example.integradorBackEndCagna.entity.Paciente;
import com.example.integradorBackEndCagna.entity.dto.PacienteDto;

import java.util.Set;

public interface IPacienteService {
    public Paciente guardarPaciente(PacienteDto pacienteDto);
    public PacienteDto traerPaciente(Integer id);
    public Paciente updatePaciente(PacienteDto pacienteDto);
    public void eliminarPaciente(Integer id);
    public Set<PacienteDto> traerTodos();
}
