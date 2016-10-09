package com.tenpines.tusLibros.modelo;

import java.time.LocalDateTime;

public class Cajero {


    public VentaConcretada cobrar(Carrito unCarrito, TarjetaDeCredito tarjetaDeCreaditoValida){
        validarSiUnCarritoEstaVacio(unCarrito);
        VentaConcretada venta = VentaConcretada.nuevaVentaConcretada(unCarrito, precioTotalCompra(unCarrito), LocalDateTime.now());
        return venta;
    }

    private void validarSiUnCarritoEstaVacio(Carrito unCarrito) {
        if (unCarrito.estaVacio()) {
            throw new RuntimeException(mensajeDeErrorCuandoQuieroCobrarUnCarroVacio());
        }
    }

    private Integer precioTotalCompra(Carrito unCarrito) {

        Integer precioTotal = unCarrito.getItems().stream().mapToInt(libroPorCarrito -> libroPorCarrito.getLibro().getPrecio() * libroPorCarrito.getCantidad()).sum();
        return precioTotal;
    }

    public static String mensajeDeErrorCuandoQuieroCobrarUnCarroVacio() {
        return "No se puede cobrar un carro que esta vacio";
    }
}
