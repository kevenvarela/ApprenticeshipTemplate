package com.tenpines.tusLibros.modelo;


import java.time.LocalDate;
import java.time.Month;

public class ProveedorDeObjetos {


    public Carrito carritoVacio(){
        Cliente cliente = Cliente.crearCliente("1234");
        return Carrito.crearCarrito();
    }

    public Libro crearLibro(){
        Libro elPerfume = Libro.crearLibro("El perfume", "123456789", 45);
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
    private LocalDate fechaDeVencimiento = LocalDate.of(2020, Month.DECEMBER, 1); // 2020-12-1

    private TarjetaDeCredito tarjetaValida = TarjetaDeCredito.nuevaTarjeta(1000200030004000L, fechaDeVencimiento,"Roberto Perez");

    public TarjetaDeCredito tarjetaDeCreditoValida(){
        return tarjetaValida;
    }

}
