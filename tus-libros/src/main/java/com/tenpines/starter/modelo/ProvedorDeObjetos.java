package com.tenpines.starter.modelo;


import com.tenpines.starter.modelo.Carrito;

public class ProvedorDeObjetos {

    public Carrito carritoVacio(){
        return new Carrito();
    }

    public Carrito carritoConUnLibro(){
        Carrito unCarrito = new Carrito();
        unCarrito.agregarLibro("Guerra de los mundos", 1);
        return unCarrito;
    }
}
