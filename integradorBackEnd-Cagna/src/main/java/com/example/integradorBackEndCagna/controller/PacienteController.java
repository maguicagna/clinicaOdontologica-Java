package com.example.integradorBackEndCagna.controller;

import com.example.integradorBackEndCagna.entity.Paciente;
import com.example.integradorBackEndCagna.entity.dto.PacienteDto;
import com.example.integradorBackEndCagna.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> cargarPaciente(@RequestBody PacienteDto pacienteDto){
        return ResponseEntity.ok(pacienteService.guardarPaciente(pacienteDto));
    }

    @GetMapping
    public ResponseEntity<Set<PacienteDto>> traerPacientes(){
        return ResponseEntity.ok(pacienteService.traerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDto> buscarXid(@PathVariable Integer id){
        ResponseEntity<PacienteDto> response = null;

        if(pacienteService.traerPaciente(id)==null)
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        else
            response = ResponseEntity.ok(pacienteService.traerPaciente(id));

        return response;

    }

    @PutMapping
    public ResponseEntity<Paciente> updatePaciente(@RequestBody PacienteDto pacienteDto){
        ResponseEntity<Paciente> response = null;

        if(pacienteDto.getId() != null && pacienteService.traerPaciente(pacienteDto.getId()) != null)
            response = ResponseEntity.ok(pacienteService.updatePaciente(pacienteDto));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarPaciente(@PathVariable Integer id){
        ResponseEntity response = null;

        if(pacienteService.traerPaciente(id)==null)
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        else{
            pacienteService.eliminarPaciente(id);
            response = ResponseEntity.ok("Se elimino el paciente correctamente.");
        }

        return response;
    }


}
