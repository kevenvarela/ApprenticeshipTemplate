package com.tenpines.starter.modelo;

public class Cajero {



    public Integer cobrar(Carrito unCarrito){
        if (unCarrito.estaVacio()) {
            throw new RuntimeException(mensajeDeErrorCuandoQuieroCobrarUnCarroVacio());
        }
        return precioTotalCompra(unCarrito);
    }

    private Integer precioTotalCompra(Carrito unCarrito) {

        int precioTotal = unCarrito.getItems().stream().mapToInt(Libro::getPrecio).sum();

        return precioTotal;
    }

    public static String mensajeDeErrorCuandoQuieroCobrarUnCarroVacio() {
        return "No se puede cobrar un carro que esta vacio";
    }
}