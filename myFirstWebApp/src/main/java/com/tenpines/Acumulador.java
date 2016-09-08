package com.tenpines;

public class Acumulador {

    public Integer acumulador = 20;

    public Integer darNumero(){
        return acumulador;
    }

    public void sumar(int a) {

        this.acumulador += a;
    }
}
