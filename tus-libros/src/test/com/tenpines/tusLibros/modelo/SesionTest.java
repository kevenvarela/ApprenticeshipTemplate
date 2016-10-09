package com.tenpines.tusLibros.modelo;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;


public class SesionTest {

    Cliente cliente = Cliente.crearCliente("1234");
    Carrito carrito = Carrito.crearCarrito();
    Cliente clienteNull;
    Carrito carritoNull;
    RelojDePrueba reloj = new RelojDePrueba(12,30);
    Sesion sesion = Sesion.crearSesion(carrito,cliente);
    Libro libro = Libro.crearLibro("el principito", "123123123", 45);

    @Test
    public void tratoDeCrearUnaSesionConUnClienteEnNullYMeTiraUnaExcepcion(){
        try {Sesion.crearSesion(carrito,clienteNull);
        } catch (RuntimeException excepcionNoCrearSesionSinCliente) {
            assertThat(excepcionNoCrearSesionSinCliente.getMessage()).isEqualTo(Sesion.mensajeDeErrorCuandoQuieroCrearUnCarritoConUsuarioInvalido());
        }
    }

    @Test
    public void unaSesionSeVenceAlPasarMasDe30Minutos(){
        reloj.setearHoraYMinutos(10,0);
        Sesion sesion = Sesion.crearSesion(carrito,cliente);
        sesion.setUltimoUso(reloj.horaActual());
        reloj.setearHoraYMinutos(10,40);

        try {sesion.chequearSesionExpirada(reloj);
            assertTrue("nunca deberia llegar aca", false);
        } catch (RuntimeException excepcionSesionExpirada) {
            assertThat(excepcionSesionExpirada.getMessage()).isEqualTo(Sesion.mensajeDeErrorSesionExpirada());
        }
    }

    @Test
    public void unaSesionSeVenceAlPasar30MinutosTodaviaNoExpiro() {
        reloj.setearHoraYMinutos(10, 0);
        Sesion sesion = Sesion.crearSesion(carrito, cliente);
        sesion.setUltimoUso(reloj.horaActual());
        reloj.setearHoraYMinutos(10, 30);
        assertThat(sesion.laSesionExpiro(reloj)).isFalse();
    }

    @Test
    public void noSePuedeAgregarUnLibroAUnCarritoDeUnaSesionExpiro() {
        reloj.setearHoraYMinutos(10,0);
        Sesion sesion = Sesion.crearSesion(carrito,cliente);
        sesion.setUltimoUso(reloj.horaActual());
        reloj.setearHoraYMinutos(10,40);
        try {sesion.agregarLibroACarrito(libro, 1, reloj);
            assertTrue("nunca deberia llegar aca", false);
        } catch (RuntimeException excepcionSesionExpirada) {
            assertThat(excepcionSesionExpirada.getMessage()).isEqualTo(Sesion.mensajeDeErrorSesionExpirada());
        }
    }

    @Test
    public void agregarUnLibroAUnCarritoDeUnaSesionYEsta() {
        PackDeLibros packDeLibros = PackDeLibros.nuevoLibroEnCarrito(carrito, libro, 1);
        reloj.setearHoraYMinutos(10, 0);
        Sesion sesion = Sesion.crearSesion(carrito, cliente);
        sesion.setUltimoUso(reloj.horaActual());
        reloj.setearHoraYMinutos(10, 29);
        sesion.agregarLibroACarrito(libro, 1, reloj);
        assertThat(sesion.getCarrito().getItems()).contains(packDeLibros);
    }
}