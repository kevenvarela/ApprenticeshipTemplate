package com.tenpines.starter.modelo;

import java.util.Date;

public class TarjetaDeCredito {

    public Long numero;
    public Date fechaDeExpiracion;
    public String nombreDuenio;

    public static TarjetaDeCredito nuevaTarjeta(Long unNumero, Date unaFechaDeExpiracion, String unNombreDuenio) {
        TarjetaDeCredito tarjetaDeCredito = new TarjetaDeCredito();
        tarjetaDeCredito.setNumero(unNumero);
        tarjetaDeCredito.setFechaDeExpiracion(unaFechaDeExpiracion);
        tarjetaDeCredito.setNombreDuenio(unNombreDuenio);
        return tarjetaDeCredito;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public void setFechaDeExpiracion(Date fechaDeExpiracion) {
        this.fechaDeExpiracion = fechaDeExpiracion;
    }

    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }
}
