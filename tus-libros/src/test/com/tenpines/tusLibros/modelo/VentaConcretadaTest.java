package com.tenpines.tusLibros.modelo;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VentaConcretadaTest {

    public VentaConcretada venta;
    public Libro libro = Libro.crearLibro("asdasd","1234567678",100);
    public Carrito carrito = Carrito.crearCarrito();
    public List<Libro> itemsDeLaCompra = new ArrayList<Libro>();
    public LocalDateTime horaYFecha = LocalDateTime.now();


    @Test
    public void unaVentaConcretadaDebeTenerItemsPrecioTotalYFechanYHoraDeLaMisma(){
        carrito.agregarLibro(libro,1);
        VentaConcretada venta = VentaConcretada.nuevaVentaConcretada(carrito, 70,horaYFecha);

        assertThat(venta.getCarrito().getItems()).isNotEmpty();
        assertThat(venta.getFechaYHoraDeVenta()).isEqualTo(horaYFecha);
        assertThat(venta.getPrecioTotal()).isNotNull();
    }
}
