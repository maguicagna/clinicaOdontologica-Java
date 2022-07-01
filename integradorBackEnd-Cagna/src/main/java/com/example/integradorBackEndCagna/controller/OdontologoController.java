package com.example.integradorBackEndCagna.controller;

import com.example.integradorBackEndCagna.entity.Odontologo;
import com.example.integradorBackEndCagna.entity.dto.OdontologoDto;
import com.example.integradorBackEndCagna.exceptions.BadRequestException;
import com.example.integradorBackEndCagna.exceptions.ResourceNotFoundException;
import com.example.integradorBackEndCagna.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<Odontologo> cargarOdontologo(@RequestBody OdontologoDto odontologoDto) throws BadRequestException {
        try{
            return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologoDto));
        }catch (Exception e){
            throw  new BadRequestException(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<Set<OdontologoDto>> traerTodos(){
        return ResponseEntity.ok(odontologoService.traerTodos());
    }

    @GetMapping("/{id}")
    public OdontologoDto buscarXid(@PathVariable Integer id) throws ResourceNotFoundException {
        try{
            return odontologoService.buscarOdontologo(id);
        }catch (Exception e ){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Odontologo> updatePaciente(@RequestBody OdontologoDto odontologoDto) throws BadRequestException, ResourceNotFoundException{
        try{
            return ResponseEntity.ok(odontologoService.updateOdontologo(odontologoDto));
        }catch (Exception e){
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarOdontologo(@PathVariable Integer id){
        ResponseEntity response = null;
        if(odontologoService.buscarOdontologo(id) == null)
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        else{
            odontologoService.eliminarOdontologo(id);
            response = ResponseEntity.ok("Se elimino el odontologo correctamente");

        }
        return response;
    }
}
