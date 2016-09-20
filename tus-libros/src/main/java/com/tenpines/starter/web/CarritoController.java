package com.tenpines.starter.web;

import com.tenpines.starter.modelo.Carrito;
import com.tenpines.starter.modelo.Libro;
import com.tenpines.starter.modelo.Cliente;
import com.tenpines.starter.servicios.ServicioDeCarritos;
import com.tenpines.starter.servicios.ServicioDeCatalogo;
import com.tenpines.starter.servicios.ServicioDeCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class CarritoController {
    private ServicioDeCarritos servicioCarrito;

    private ServicioDeCliente servicioDeCliente;
    private ServicioDeCatalogo servicioCatalogo;

    Carrito carrito;
    Cliente unCliente;

    @Autowired
    public CarritoController(ServicioDeCarritos servicioDeCarritos, ServicioDeCliente servicioDeClientes, ServicioDeCatalogo servicioDeCatalogo) {
        this.servicioCarrito = servicioDeCarritos;
        this.servicioCatalogo = servicioDeCatalogo;
        this.servicioDeCliente = servicioDeClientes;

    }

    @RequestMapping(Endpoints.HOME)
    String home(Model model) {
        model.addAttribute("carrito", obtenerUnCarrito());
        model.addAttribute("cliente", unCliente);
        model.addAttribute("libros", catalogo());
        return "nuevaCompra";
    }

    @RequestMapping(value = Endpoints.AGREGAR_CARRITO, method = RequestMethod.POST)
    void crearUnCarrito(HttpServletResponse response) throws IOException {
        carrito = servicioCarrito.nuevoCarrito(unCliente);
        response.sendRedirect(Endpoints.HOME);

    }

    @RequestMapping(value = Endpoints.AGREGAR_ITEM, method = RequestMethod.POST)
    void agregarUnLibro(@RequestParam(value = "libro") Libro unLibro, HttpServletResponse response) throws IOException {
        carrito.agregarLibro(unLibro, 1);
        servicioCarrito.almacenar(carrito);
        response.sendRedirect(Endpoints.HOME);
    }


    @RequestMapping(value = Endpoints.LOGUEAR_CLIENTE, method = RequestMethod.POST)
    private void loguearCliente( @RequestParam Map<String,String> requestParams , HttpServletResponse response) throws IOException {
        Long idUsuario = Long.valueOf(requestParams.get("nombre"));
        String password = requestParams.get("password");
        unCliente = servicioDeCliente.clienteLogueado(idUsuario, password);
        response.sendRedirect(Endpoints.HOME);
    }

    @RequestMapping(value=Endpoints.OBTENER_CLIENTE, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    List<Cliente> obtenerCliente(){
        return servicioDeCliente.mostrarClientes();
    }

    private Carrito obtenerUnCarrito(){
        if (carrito != null ){
        return servicioCarrito.buscarElCarrito(carrito.getId());}
        return carrito;
    }

    @RequestMapping(value=Endpoints.OBTENER_CARRITO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    List<Carrito> obtenerCarritos(){
        return servicioCarrito.mostrarCarritos();
    }

    private Iterable<Libro> catalogo(){
        return servicioCatalogo.mostrarCatalogo();
    }
}
