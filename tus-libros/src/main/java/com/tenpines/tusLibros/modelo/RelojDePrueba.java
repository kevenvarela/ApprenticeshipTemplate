package com.tenpines.tusLibros.modelo;

import java.time.LocalDateTime;

public class RelojDePrueba {

    LocalDateTime horaActual;

    public RelojDePrueba(Integer hora, Integer minutos) {
       horaActual = LocalDateTime.now().withHour(hora).withMinute(minutos);
    }

    public LocalDateTime horaActual(){
        return horaActual;
    }

    public Integer obtenerHora() {
        return horaActual.getHour();
    }

    public Integer obtenerMinutos() {
        return horaActual.getMinute();
    }

    public void setearHoraYMinutos(Integer hora, Integer minutos){
        horaActual = horaActual.withHour(hora).withMinute(minutos);
    }
}
