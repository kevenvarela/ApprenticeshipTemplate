package com.tenpines.tusLibros.modelo;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public class TarjetaDeCredito {

    private static RelojDePrueba reloj = new RelojDePrueba(LocalDateTime.now().getHour(),LocalDateTime.now().getMinute());

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
        if (fechaDeExpiracion.isBefore(ChronoLocalDate.from(reloj.horaActual()))){
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