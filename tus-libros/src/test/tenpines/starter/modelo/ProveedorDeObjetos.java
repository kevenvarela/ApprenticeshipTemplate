package com.tenpines.starter.modelo;


public class ProveedorDeObjetos {

    public static final int UN_PRECIO_BIEN_CONOCIDO = 45;

    public Carrito carritoVacio(){
        return new Carrito();
    }

    public Libro crearLibro(){
        Libro elPerfume = Libro.crearLibro("El perfume", "123456789", UN_PRECIO_BIEN_CONOCIDO);
        return elPerfume;
    }

    public Libro crearOtroLibro(){
        Libro guerraDeLosMundos = Libro.crearLibro("Guerra de los mundos", "987654321", 95);
        return guerraDeLosMundos;
    }

    public Libro crearLibroInvalido(){
        Libro libroInvalido = Libro.crearLibro("INVALIDO", "192837465", 100);
        return libroInvalido;
    }

    public Carrito carritoConUnLibro(){
        Carrito unCarrito = new Carrito();
        unCarrito.agregarLibro(this.crearLibro(), 1);
        return unCarrito;
    }
}
