package com.aerolinea.amonic.Dto;

import java.time.LocalDate;

public class BuscarRutas {

     private Integer salidaAeropuerto;
     private Integer destinoAeropuerto;

     private LocalDate inicioVuelo;
     private LocalDate llegadaVuelo;

     public Integer getSalidaAeropuerto() {
          return salidaAeropuerto;
     }

     public void setSalidaAeropuerto(Integer salidaAeropuerto) {
          this.salidaAeropuerto = salidaAeropuerto;
     }

     public Integer getDestinoAeropuerto() {
          return destinoAeropuerto;
     }

     public void setDestinoAeropuerto(Integer destinoAeropuerto) {
          this.destinoAeropuerto = destinoAeropuerto;
     }

     public LocalDate getInicioVuelo() {
          return inicioVuelo;
     }

     public void setInicioVuelo(LocalDate inicioVuelo) {
          this.inicioVuelo = inicioVuelo;
     }

     public LocalDate getLlegadaVuelo() {
          return llegadaVuelo;
     }

     public void setLlegadaVuelo(LocalDate llegadaVuelo) {
          this.llegadaVuelo = llegadaVuelo;
     }
}
