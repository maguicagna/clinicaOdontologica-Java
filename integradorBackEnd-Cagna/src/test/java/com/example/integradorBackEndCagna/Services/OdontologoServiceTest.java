package com.example.integradorBackEndCagna.Services;

import com.example.integradorBackEndCagna.entity.Odontologo;
import com.example.integradorBackEndCagna.entity.dto.OdontologoDto;
import com.example.integradorBackEndCagna.exceptions.ResourceNotFoundException;
import com.example.integradorBackEndCagna.service.OdontologoService;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    private OdontologoService odontologoService;

    public void cargarOdontologos(){
        odontologoService.guardarOdontologo(new OdontologoDto("Carlos", "Perez", "21876543"));
        odontologoService.guardarOdontologo(new OdontologoDto("Julieta", "Gonzales", "20876321"));
        odontologoService.guardarOdontologo(new OdontologoDto("Ramiro", "Lopez", "25321876"));
    }

    @Test
    public void registrarOdontologoYTraerOdontologo() throws ResourceNotFoundException {
        Odontologo o1 = odontologoService.guardarOdontologo(new OdontologoDto("Carlos", "Perez", "21876543"));
        Odontologo o2 = odontologoService.guardarOdontologo(new OdontologoDto("Julieta", "Gonzales", "20876321"));
        Odontologo o3 = odontologoService.guardarOdontologo(new OdontologoDto("Ramiro", "Lopez", "25321876"));
        assertNotNull(odontologoService.buscarOdontologo(o1.getId()));
        assertNotNull(odontologoService.buscarOdontologo(o2.getId()));
        assertNotNull(odontologoService.buscarOdontologo(o3.getId()));
    }

    @Test
    public void traerTodos() {
        cargarOdontologos();
        Set<OdontologoDto> odontologos = odontologoService.traerTodos();
        assertFalse(odontologos.isEmpty());
        System.out.println(odontologos);
    }

    @Test
    public void eliminarOdontologo() throws ResourceNotFoundException {
        boolean ex = false;
        Odontologo o4 = odontologoService.guardarOdontologo(new OdontologoDto("Carlos", "Lopez", "21332889"));
        odontologoService.eliminarOdontologo(o4.getId());
        try{
            odontologoService.buscarOdontologo(o4.getId());
        }catch (Exception e){
            ex = true;
            throw new ResourceNotFoundException(e.getMessage());
        }
        assertTrue(ex);
    }

    @Test
    public void actualizarOdontologo() throws ResourceNotFoundException {
        Odontologo o1 = odontologoService.guardarOdontologo(new OdontologoDto("Carlos", "Lopez", "21332889"));
        OdontologoDto o2 = new OdontologoDto("Carlos", "Lopez", "21332889");
        o2.setId(o1.getId());

        odontologoService.updateOdontologo(o2);
        assertEquals(o2.toString(),odontologoService.buscarOdontologo(o2.getId()).toString());
    }
}