package com.tenpines.starter.modelo;


import java.time.LocalDate;

public class TarjetaDeCredito {

    private static Reloj reloj = new Reloj();;
    public Long numero;
    public LocalDate fechaDeExpiracion;
    public String nombreDuenio;

    public static TarjetaDeCredito nuevaTarjeta(Long unNumero, LocalDate unaFechaDeExpiracion, String unNombreDuenio) {
        validadTarjetaNoExpirada(unaFechaDeExpiracion);
        validarNombreDuenioTarjeta(unNombreDuenio);
        TarjetaDeCredito tarjetaDeCredito = new TarjetaDeCredito();
        tarjetaDeCredito.setNumero(unNumero);
        tarjetaDeCredito.setFechaDeExpiracion(unaFechaDeExpiracion);
        tarjetaDeCredito.setNombreDuenio(unNombreDuenio);
        return tarjetaDeCredito;
    }

    public TarjetaDeCredito(){
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public void setFechaDeExpiracion(LocalDate fechaDeExpiracion) {
        this.fechaDeExpiracion = fechaDeExpiracion;
    }

    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }

    public Long getNumero(){
        return numero;
    }

    public LocalDate getFechaDeExpiracion(){
        return fechaDeExpiracion;
    }

    public String getNombreDuenio(){
        return nombreDuenio;
    }

    private static void validarNombreDuenioTarjeta(String nombreDuenio){
        if (nombreDuenio.length() > 30){
            throw new RuntimeException(mensajeDeErrorCuandoElNombreDuenioDeUnaTarjetaEsMuyLargo());
        }
    }

    private static void validadTarjetaNoExpirada(LocalDate fechaDeExpiracion){
        if (fechaDeExpiracion.isBefore(reloj.horaActual())){
            throw new RuntimeException(mensajeDeErrorCuandoLaTarjetaEstaExpirada());
        }
    }

    public static String mensajeDeErrorCuandoElNombreDuenioDeUnaTarjetaEsMuyLargo() {
        return "El nombre del duenio de la tarjeta es demasiado largo, debe ser menor a 30 caracteres";
    }

    public static String mensajeDeErrorCuandoLaTarjetaEstaExpirada() {
        return "La tarjeta de credito esta expirada";
    }
}