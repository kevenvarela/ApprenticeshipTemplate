package com.tenpines.tusLibros.api;

import com.tenpines.tusLibros.integracion.RESTTestBase;
import com.tenpines.tusLibros.modelo.Carrito;
import com.tenpines.tusLibros.modelo.Cliente;
import com.tenpines.tusLibros.modelo.Sesion;
import com.tenpines.tusLibros.repositorios.RepositorioDeCarritos;
import com.tenpines.tusLibros.repositorios.RepositorioDeCatalogo;
import com.tenpines.tusLibros.repositorios.RepositorioDeClientes;
import com.tenpines.tusLibros.repositorios.RepositorioDeSesiones;
import com.tenpines.tusLibros.servicios.ServicioDeCarritos;
import com.tenpines.tusLibros.servicios.ServicioDeCliente;
import com.tenpines.tusLibros.servicios.ServicioDeSesion;
import com.tenpines.tusLibros.web.Endpoints;
import com.tenpines.tusLibros.web.TransferObjects.UsuarioPasswordTO;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.NotNull;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.support.NullValue;


import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class APITest extends RESTTestBase {

    @Autowired
    private RepositorioDeCarritos repositorioDeCarrito;

    @Autowired
    private RepositorioDeClientes repositorioDeClientes;

    @Autowired
    private RepositorioDeSesiones repositorioDeSesiones;

    @MockBean
    private ServicioDeCliente servicioDeCliente;

    @MockBean
    private ServicioDeSesion servicioDeSesion;

    private Cliente cliente;
    private Sesion unaSesion;
    private Carrito unCarrito;


    @Before
    public void setUp(){
        repositorioDeClientes.save(Cliente.crearCliente("1234"));
        cliente = repositorioDeClientes.findOne(1L);
        unCarrito = repositorioDeCarrito.save(Carrito.crearCarrito());
        unaSesion = repositorioDeSesiones.save(Sesion.crearSesion(unCarrito,cliente));
    }



//    @Test
//    public void agregarUnItemAlCarritoYQueEsteEnElCarrito() throws Exception {
//        Cliente cliente1 = Cliente.crearCliente("1234");
//        Carrito carrito = Carrito.crearCarrito();
//        Libro libro = Libro.crearLibro("Hola", "9873459234",20);
//
//        this.mockClient.perform(get(Endpoints.MOSTRAR_ITEMS))
//                .andExpect(content().contentType(JSON_CONTENT_TYPE))
//                .andExpect(status().is(200))
//                .andExpect(jsonPath("$[0]['isbn']").value(libro.getIsbn()));
//    }
//

    @Test
    public void agregarClienteYQueLaTablaNoSeaNull() throws Exception {

        Mockito.when(servicioDeCliente.mostrarClientes()).thenReturn((Arrays.asList(cliente)));

        this.mockClient.perform(get(Endpoints.OBTENER_CLIENTE))
                .andExpect(content().contentType(JSON_CONTENT_TYPE))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$..cliente").value(notNullValue()));
    }

    @Test
    public void agregarClienteYMeDevuelvaLaListaConLoMismo() throws Exception {


        Mockito.when(servicioDeCliente.mostrarClientes()).thenReturn((Arrays.asList(cliente)));

        this.mockClient.perform(get(Endpoints.OBTENER_CLIENTE))
                .andExpect(content().contentType(JSON_CONTENT_TYPE))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$[0]['password']").value((cliente.getPassword())));
    }


    @Test
    public void agregoUnCliente() throws Exception {


        Mockito.when(servicioDeCliente.mostrarClientes()).thenReturn((Arrays.asList(cliente)));

        this.mockClient.perform(get(Endpoints.OBTENER_CLIENTE))
                .andExpect(content().contentType(JSON_CONTENT_TYPE))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$[0]['password']").value((cliente.getPassword())));
    }

    @Test
    public void listarVentasParaUnClienteQueNoTieneVentas() throws Exception {
        UsuarioPasswordTO usuarioPasswordTO = UsuarioPasswordTO.crearUsuarioPasswordTO(cliente.getId(), cliente.getPassword());
        Mockito.when(servicioDeCliente.buscarElCliente(usuarioPasswordTO.getIdUsuario())).thenReturn(cliente);
        Mockito.when(servicioDeSesion.crearCarrito(cliente)).thenReturn(unaSesion);
        this.mockClient.perform(post(Endpoints.LISTAR_VENTAS).contentType(APPLICATION_JSON_UTF8_VALUE).content(json(usuarioPasswordTO)))
                .andExpect(content().contentType(JSON_CONTENT_TYPE))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void creoUnCarritoIniciandoLaSesionConUnUsuarioConContraseniaInvalido() throws Exception {
        UsuarioPasswordTO usuarioPasswordTO = UsuarioPasswordTO.crearUsuarioPasswordTO(cliente.getId(), "EstaNoEsLaContrasenia");
        this.mockClient.perform(post(Endpoints.AGREGAR_CARRITO).contentType(APPLICATION_JSON_UTF8_VALUE).content(json(usuarioPasswordTO)))
                .andExpect(content().contentType(JSON_CONTENT_TYPE))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void creoUnCarritoIniciandoLaSesionConUnUsuarioConContraseniaValida() throws Exception {

        UsuarioPasswordTO usuarioPasswordTO = UsuarioPasswordTO.crearUsuarioPasswordTO(cliente.getId(), cliente.getPassword());
        Mockito.when(servicioDeCliente.buscarElCliente(usuarioPasswordTO.getIdUsuario())).thenReturn(cliente);
        Mockito.when(servicioDeSesion.crearCarrito(cliente)).thenReturn(unaSesion);
        this.mockClient.perform(post(Endpoints.AGREGAR_CARRITO).contentType(APPLICATION_JSON_UTF8_VALUE).content(json(usuarioPasswordTO)))
                .andExpect(content().contentType(JSON_CONTENT_TYPE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(notNullValue()));
    }




}
