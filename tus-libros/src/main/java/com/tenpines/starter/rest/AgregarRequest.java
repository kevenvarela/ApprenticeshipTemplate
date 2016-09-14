package com.tenpines.starter.rest;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;
import com.tenpines.starter.modelo.Carrito;

import java.util.ArrayList;

public class AgregarRequest {

    private Carrito carrito;

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito unCarrito) {
        this.carrito = unCarrito;
    }

    public ArrayList<String> getCarritoContenido() {
        return carrito.contenido();
    }

    public void agregarItem(String unItem) {
        this.carrito.agregarItem(unItem);
    }


}
