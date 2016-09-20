package com.tenpines.starter.api;

import com.tenpines.starter.integracion.RESTTestBase;
import com.tenpines.starter.modelo.Carrito;
import com.tenpines.starter.modelo.Cliente;
import com.tenpines.starter.modelo.Libro;
import com.tenpines.starter.servicios.ServicioDeCarritos;
import com.tenpines.starter.servicios.ServicioDeCliente;
import com.tenpines.starter.web.Endpoints;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;

import static com.tenpines.starter.modelo.ProveedorDeObjetos.UN_PRECIO_BIEN_CONOCIDO;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class APITest extends RESTTestBase {

    @MockBean
    private ServicioDeCarritos servicioDeCarritos;

    @Test
    public void agregarCarritoYQueNoSeaNullElContenidoDeLaTabla() throws Exception {
        Cliente cliente1 = Cliente.crearCliente("1234");
        Carrito carrito1 = Carrito.crearCarrito(cliente1);

        Mockito.when(servicioDeCarritos.mostrarCarritos()).thenReturn(Arrays.asList(carrito1));

        this.mockClient.perform(get(Endpoints.OBTENER_CARRITO))
                .andExpect(content().contentType(JSON_CONTENT_TYPE))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$..id").value(notNullValue()));

    }

    @Test
        public void agregar1CarritoYQueDevuelvaElJson() throws Exception {
        Cliente cliente1 = Cliente.crearCliente("1234");
        Carrito carrito1 = Carrito.crearCarrito(cliente1);

        Mockito.when(servicioDeCarritos.mostrarCarritos()).thenReturn(Arrays.asList(carrito1));


        this.mockClient.perform(get(Endpoints.OBTENER_CARRITO))
                .andExpect(content().contentType(JSON_CONTENT_TYPE))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$[0]['cliente']['password']").value((cliente1.getPassword())));

        Mockito.verify(servicioDeCarritos, Mockito.times(1)).mostrarCarritos();
        Mockito.verifyNoMoreInteractions(servicioDeCarritos);
    }

    @MockBean
    private ServicioDeCliente servicioDeCliente;

    @Test
    public void agregarClienteYQueLaTablaNoSeaNull() throws Exception {
        Cliente cliente1 = Cliente.crearCliente("1234");


        Mockito.when(servicioDeCliente.mostrarClientes()).thenReturn((Arrays.asList(cliente1)));

        this.mockClient.perform(get(Endpoints.OBTENER_CLIENTE))
                .andExpect(content().contentType(JSON_CONTENT_TYPE))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$..cliente").value(notNullValue()));
    }

    @Test
    public void agregarClienteYMeDevuelvaLaListaConLoMismo() throws Exception {
        Cliente cliente1 = Cliente.crearCliente("1234");

        Mockito.when(servicioDeCliente.mostrarClientes()).thenReturn((Arrays.asList(cliente1)));

        this.mockClient.perform(get(Endpoints.OBTENER_CLIENTE))
                .andExpect(content().contentType(JSON_CONTENT_TYPE))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$[0]['password']").value((cliente1.getPassword())));
    }
}
