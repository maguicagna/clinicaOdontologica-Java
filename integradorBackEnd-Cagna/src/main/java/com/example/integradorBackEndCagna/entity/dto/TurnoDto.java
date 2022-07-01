package com.example.integradorBackEndCagna.entity.dto;

import com.example.integradorBackEndCagna.entity.Odontologo;
import com.example.integradorBackEndCagna.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Time;
import java.time.LocalDate;

public class TurnoDto {
    private Integer id;
    private LocalDate fecha;
    private Time hora;
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Paciente paciente;
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler"})
    private Odontologo odontologo;

    public TurnoDto() {
    }

    public TurnoDto(LocalDate fecha, Time hora, Paciente paciente, Odontologo odontologo) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
}
