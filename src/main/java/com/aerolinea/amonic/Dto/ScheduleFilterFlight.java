package com.aerolinea.amonic.Dto;

import java.time.LocalDate;

public class ScheduleFilterFlight {

    private Integer origen;
    private Integer destino;
    private LocalDate fecha;

    public Integer getOrigen() {
        return origen;
    }

    public void setOrigen(Integer origen) {
        this.origen = origen;
    }

    public Integer getDestino() {
        return destino;
    }

    public void setDestino(Integer destino) {
        this.destino = destino;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
