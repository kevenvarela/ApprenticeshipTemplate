package com.tenpines.tusLibros.modelo;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class LibroDeVentasTest {

    private LibroDeVentas libroDeVentas = new LibroDeVentas();
    private Carrito carrito = Carrito.crearCarrito();
    private VentaConcretada venta = VentaConcretada.nuevaVentaConcretada(carrito, 150, LocalDateTime.now());

    @Test
    public void alCrearUnLibroDeVentasSeDebeInicializarVacio(){
        assertThat(libroDeVentas.getVentasConcretadas()).isEmpty();
    }

    @Test
    public void alRegistrarUnaVentaConcretadaDebeContenerla(){
        libroDeVentas.registrarVenta(venta);
        assertThat(libroDeVentas.getVentasConcretadas()).contains(venta);
    }



//    @Test
//    public void noSePuedeCobrarUnCarroVacio(){
//        try {cajero.cobrar(carrito, tarjetaDeCreditoValida);
//            assertTrue("nunca deberia llegar aca", false);
//        } catch (RuntimeException excepcionNoCobrarCarrosVacios) {
//            assertThat(excepcionNoCobrarCarrosVacios.getMessage()).isEqualTo(Cajero.mensajeDeErrorCuandoQuieroCobrarUnCarroVacio());
//        }
//    }
}
