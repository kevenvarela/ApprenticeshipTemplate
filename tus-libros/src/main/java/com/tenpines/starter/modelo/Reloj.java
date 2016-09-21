package com.tenpines.starter.modelo;

import java.time.LocalDate;

public class Reloj {

    private final LocalDate horaActual;

    public Reloj(){
        horaActual = LocalDate.now();
    }

    public LocalDate horaActual(){
        return horaActual;
    }
}
