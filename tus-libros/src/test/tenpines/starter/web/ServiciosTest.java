package com.tenpines.starter.web;

import com.tenpines.starter.integracion.SpringTestBase;
import com.tenpines.starter.modelo.Carrito;
import com.tenpines.starter.modelo.Cliente;
import com.tenpines.starter.modelo.Libro;
import com.tenpines.starter.servicios.ServicioDeCarritos;
import com.tenpines.starter.servicios.ServicioDeCliente;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class ServiciosTest extends SpringTestBase {

    @Autowired
    private ServicioDeCarritos servicioDeCarritos;

    @Autowired
    private ServicioDeCliente servicioDeCliente;

    @Test
    public void hayCarritoCreado(){
        Cliente cliente1 = Cliente.crearCliente("1234");
        Carrito carrito = Carrito.crearCarrito(cliente1);
        servicioDeCarritos.nuevoCarrito(cliente1);
        assertThat(servicioDeCarritos.mostrarCarritos()).isNotEmpty();
    }

    @Test
    public void noCrearCarritoSinUsuario(){
        try {
            Cliente cliente = null;
            Carrito carrito = servicioDeCarritos.nuevoCarrito(cliente);
            assertTrue("nunca deberia llegar aca", false);
        } catch (RuntimeException excepcionDeCarritoSinUsuario) {
            AssertionsForClassTypes.assertThat(excepcionDeCarritoSinUsuario.getMessage()).isEqualTo(ServicioDeCarritos.mensajeDeErrorCuandoQuieroCrearUnCarritoConUsuarioInvalido());
        }
    }

    @Test
    public void noSePuedeCrearUnCarritoNuevoSinUnUsuarioYPasswordValido() {
        assertFalse(servicioDeCliente.loguearCliente(1L, "1111"));    //TODO: Esto se debe mockear
    }

    @Test
    public void agregarUnItemAUnCarritoYQueLoContenga() throws Exception {
        Cliente cliente1 = Cliente.crearCliente("1234");
        Carrito carrito1 = Carrito.crearCarrito(cliente1);
        Libro libro1 = Libro.crearLibro("El perfume", "123456789", 45);

        servicioDeCarritos.agregarLibro(carrito1, libro1, 1);
        assertThat(servicioDeCarritos.mostrarContenidoDeUnCarrito(carrito1.getId())).contains(libro1);
    }
}