package com.example.integradorBackEndCagna.service.serviceInterfaces;

import com.example.integradorBackEndCagna.entity.Odontologo;
import com.example.integradorBackEndCagna.entity.dto.OdontologoDto;

import java.util.Set;

public interface IOdontologoService {
    public Odontologo guardarOdontologo(OdontologoDto odontologoDto);
    public OdontologoDto buscarOdontologo(Integer id);
    public Odontologo updateOdontologo(OdontologoDto odontologoDto);
    public void eliminarOdontologo(Integer id);
    public Set<OdontologoDto> traerTodos();
}
