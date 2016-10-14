package com.tenpines.tusLibros.web;

import com.tenpines.tusLibros.integracion.SpringTestBase;
import com.tenpines.tusLibros.modelo.*;
import com.tenpines.tusLibros.servicios.ServicioDeCarritos;
import com.tenpines.tusLibros.servicios.ServicioDeCatalogo;
import com.tenpines.tusLibros.servicios.ServicioDeCliente;
import com.tenpines.tusLibros.servicios.ServicioDeSesion;
import junit.framework.TestCase;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TestIntegracion extends SpringTestBase {

    @Autowired
    private ServicioDeCarritos servicioDeCarritos;

    @Autowired
    private ServicioDeCliente servicioDeCliente;

    @Autowired
    private ServicioDeSesion servicioDeSesion;

    @Autowired
    private ServicioDeCatalogo servicioDeCatalogo;

    @Test
    public void hayCarritoCreado(){
        assertThat(servicioDeCarritos.mostrarCarritos()).isNotEmpty();
    }

    @Test
    public void noCrearCarritoSinUsuario(){
        try {
            Cliente cliente = null;
            Sesion sesion = servicioDeSesion.crearCarrito(cliente);
            assertTrue("nunca deberia llegar aca", false);
        } catch (RuntimeException excepcionDeCarritoSinUsuario) {
            AssertionsForClassTypes.assertThat(excepcionDeCarritoSinUsuario.getMessage()).isEqualTo(Sesion.mensajeDeErrorCuandoQuieroCrearUnCarritoConUsuarioInvalido());
        }
    }

    @Test
    public void noSePuedeCrearUnCarritoNuevoSiUnUsuarioYPasswordValido() {
        assertFalse(servicioDeCliente.loguearCliente(1L, "1111"));
    }

    @Test
    public void agregarUnItemAUnCarritoYQueLoContenga() throws Exception {
        Cliente cliente = Cliente.crearCliente("1234");
        servicioDeCliente.guardarCliente(cliente);
        Sesion sesion = servicioDeSesion.crearCarrito(cliente);
        Carrito carrito = sesion.getCarrito();
        Libro libro = servicioDeCatalogo.agregarLibroAlCatalogo("Guerra de los mundos", "123456789", 45);

        servicioDeSesion.agregarLibro(sesion, libro.getId(), 1);

        assertThat((servicioDeSesion.mostrarLibrosDeCarrito(carrito.getId())).contains(PackDeLibros.nuevoLibroEnCarrito(carrito,libro,1)));
    }

    @Test
    public void agrego2ItemsAUncarritoYEstanYlugegoAgrego2MasDelMismoDebeHaber4() throws Exception {
        Cliente cliente = Cliente.crearCliente("1234");
        servicioDeCliente.guardarCliente(cliente);
        Sesion sesion = servicioDeSesion.crearCarrito(cliente);
        Carrito carrito = sesion.getCarrito();
        Libro libro = servicioDeCatalogo.agregarLibroAlCatalogo("Guerra de los mundos", "123456789", 45);
        Libro libro2 = servicioDeCatalogo.agregarLibroAlCatalogo("El perfume", "987654321", 75);
        PackDeLibros pack1 = PackDeLibros.nuevoLibroEnCarrito(carrito,libro,1);
        PackDeLibros pack2 = PackDeLibros.nuevoLibroEnCarrito(carrito,libro2,1);

        servicioDeSesion.agregarLibro(sesion, libro.getId(), 1);

        assertThat((servicioDeSesion.mostrarLibrosDeCarrito(sesion.getId_sesion()))).contains(pack1);
        assertThat((servicioDeSesion.mostrarLibrosDeCarrito(sesion.getId_sesion()).size())).isEqualTo(1);

        servicioDeSesion.agregarLibro(sesion, libro2.getId(), 1);

        assertThat((servicioDeSesion.mostrarLibrosDeCarrito(sesion.getId_sesion())).contains(pack1));
        assertThat((servicioDeSesion.mostrarLibrosDeCarrito(sesion.getId_sesion())).contains(pack2));
        assertThat((servicioDeSesion.mostrarLibrosDeCarrito(sesion.getId_sesion()).size())).isEqualTo(2);
    }

    @Test
    public void alQuererAgregarUnItemConUnaSesionExpiradaDebeLanzarUnExcepcionYNoAgregarElItem(){
        Cliente cliente = Cliente.crearCliente("1234");
        servicioDeCliente.guardarCliente(cliente);
        Sesion sesionExpirada = servicioDeSesion.crearCarrito(cliente);
        Carrito carrito = sesionExpirada.getCarrito();
        Libro libro = servicioDeCatalogo.agregarLibroAlCatalogo("Guerra de los mundos", "123456789", 45);

        LocalDateTime relojDeTest = LocalDateTime.now();
        sesionExpirada.setUltimoUso(relojDeTest.minusMinutes(31));

        try {servicioDeSesion.agregarLibro(sesionExpirada, libro.getId(), 1);
        } catch (RuntimeException excepcionDeSesionExpirada) {
            assertThat(excepcionDeSesionExpirada.getMessage()).isEqualTo(Sesion.mensajeDeErrorSesionExpirada());
        }
    }

    @Test
    public void agrego3ItemsAUncarritoYEstanYlugegoAgrego2MasDeOtroMismoYEstanYElTotalEs5() throws Exception {
        Cliente cliente = Cliente.crearCliente("1234");
        servicioDeCliente.guardarCliente(cliente);
        Sesion sesion = servicioDeSesion.crearCarrito(cliente);
        Carrito carrito = sesion.getCarrito();
        Libro libro = servicioDeCatalogo.agregarLibroAlCatalogo("Guerra de los mundos", "123456789", 45);
        Libro libro2 = servicioDeCatalogo.agregarLibroAlCatalogo("El perfume", "987654321", 75);

        servicioDeSesion.agregarLibro(sesion, libro.getId(), 3);

        assertThat((servicioDeSesion.mostrarLibrosDeCarrito(sesion.getId_sesion())).contains(libro));
        assertThat((servicioDeSesion.mostrarLibrosDeCarrito(sesion.getId_sesion()).size())).isEqualTo(3);

        servicioDeSesion.agregarLibro(sesion, libro2.getId(), 2);

        assertThat((servicioDeSesion.mostrarLibrosDeCarrito(sesion.getId_sesion())).contains(libro));
        assertThat((servicioDeSesion.mostrarLibrosDeCarrito(sesion.getId_sesion())).contains(libro2));
        assertThat((servicioDeSesion.mostrarLibrosDeCarrito(sesion.getId_sesion()).size())).isEqualTo(5);
    }

    @Test
    public void alQuererAgregarUnLibroInvalidoAlCatalogoNoLoDebeAgregar() throws Exception {

        try {servicioDeCatalogo.agregarLibroAlCatalogo(null, "123456789", 45);
        } catch (RuntimeException excepcionCuandoElLibroEsInvalido) {
            assertThat(excepcionCuandoElLibroEsInvalido.getMessage()).isEqualTo(Libro.mensajeDeErrorCuandoQuieroCrearUnLibroInvalido());
        }
    }

//    @Test
//    public void cobrarUnCarritoCon1Itemy1Unidad(){
//        carrito.agregarLibro(proveedor.crearLibro(),1);
//        assertThat(cajero.cobrar(carrito)).isEqualTo(45);
//    }
}