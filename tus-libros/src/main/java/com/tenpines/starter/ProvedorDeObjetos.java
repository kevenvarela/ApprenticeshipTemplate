package com.tenpines.starter;


public class ProvedorDeObjetos {

    public Carrito carritoVacio(){
        return new Carrito();
    }

    public Carrito carritoConUnLibro(){
        Carrito unCarrito = new Carrito();
        unCarrito.agregarItem("Libro 1");
        return unCarrito;
    }
}
