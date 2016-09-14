package com.tenpines.starter.rest;

import com.tenpines.starter.modelo.Carrito;

public class AgregarRequest {

    private Carrito carrito;

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito unCarrito) {
        this.carrito = unCarrito;
    }
}
