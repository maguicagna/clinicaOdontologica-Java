package com.example.integradorBackEndCagna.controller;

import com.example.integradorBackEndCagna.entity.Turno;
import com.example.integradorBackEndCagna.entity.dto.TurnoDto;
import com.example.integradorBackEndCagna.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    private TurnoService turnoService;

    @PostMapping
    public ResponseEntity<Turno> crearTurno(@RequestBody TurnoDto turnoDto){
        return ResponseEntity.ok(turnoService.crearTurno(turnoDto));
    }

    @GetMapping
    public ResponseEntity<Set<TurnoDto>> traerTodos(){return ResponseEntity.ok(turnoService.leerTodos());}

    @GetMapping("/{id}")
    public TurnoDto buscarXId(@PathVariable Integer id){
        return turnoService.leerTurno(id);
    }

    @PutMapping
    public ResponseEntity<Turno> modificarTurno(@RequestBody TurnoDto turnoDto){
        ResponseEntity response = null;
        if (turnoDto.getId() != null && turnoService.leerTurno(turnoDto.getId()) != null)
            response = ResponseEntity.ok(turnoService.updateTurno(turnoDto));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarXId(@PathVariable Integer id){
        ResponseEntity response = null;
        if(turnoService.leerTurno(id)==null)
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        else{
            turnoService.eliminarTurno(id);
            response = ResponseEntity.ok("Se elimino el turno correctamente");
        }

        return  response;
    }


}
