package com.tenpines.starter.web;

import com.tenpines.starter.modelo.Carrito;
import com.tenpines.starter.modelo.Catalogo;
import com.tenpines.starter.modelo.Cliente;
import com.tenpines.starter.servicios.ServicioDeCarritos;
import com.tenpines.starter.servicios.ServicioDeCatalogo;
import com.tenpines.starter.servicios.ServicioDeClientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@Controller
public class TusLibrosController {
    private ServicioDeCarritos servicioDeCarritos;
    private ServicioDeClientes servicioDeClientes;
    private ServicioDeCatalogo servicioDeCatalogo;

    Carrito carrito = new Carrito();
    Cliente unCliente;

    @Autowired
    public TusLibrosController(ServicioDeCarritos servicioDeCarritos, ServicioDeClientes servicioDeClientes, ServicioDeCatalogo servicioDeCatalogo) {
        this.servicioDeCarritos = servicioDeCarritos;
        this.servicioDeClientes = servicioDeClientes;
        this.servicioDeCatalogo = servicioDeCatalogo;
    }

    @RequestMapping(Endpoints.HOME)
    String home(Model model) {
        model.addAttribute("libros", obtenerCatalogo(1));
        model.addAttribute("carrito", obtenerUnCarrito());
        model.addAttribute("cliente", unCliente);
        return "nuevaCompra";
    }

        //TODO: Assert que haya Cliente, si no hay cliente tirar excepcion y no dejar crear carrito.-
    @RequestMapping(value = Endpoints.AGREGAR_CARRITO, method = RequestMethod.POST)
    void crearUnCarrito(HttpServletResponse response) throws IOException {
        carrito = new Carrito();
        servicioDeCarritos.almacenar(carrito);
        response.sendRedirect(Endpoints.HOME);

    }

    @RequestMapping(value = Endpoints.AGREGAR_ITEM, method = RequestMethod.POST)
    void agregarUnLibro(@RequestParam(value = "libro") String unLibro, HttpServletResponse response) throws IOException {
        carrito.agregarLibro(unLibro, 1); //TODO: DEBERIA PEDIR LA CANTIDAD DE LIBROS DESDE LA VISTA
        servicioDeCarritos.almacenar(carrito);
        response.sendRedirect(Endpoints.HOME);
    }


//    @RequestMapping(value = Endpoints.LOGUEAR_CLIENTE, method = RequestMethod.POST)
//    private void loguearCliente( @RequestParam Map<String,String> requestParams , HttpServletResponse response) throws IOException {
//        Long idUsuario =Long.valueOf(requestParams.get("nombre")).longValue();
//        String password = requestParams.get("password");
//        unCliente = servicioDeClientes.buscarElCliente(idUsuario);
//        //TODO: Validar si el usuario y la contraseña es correcta. Si es incorrecta que avise, sino que lo muestre.
////        if (unCliente.getPassword().equals(password)){
//        carrito.setCliente(unCliente);
//        response.sendRedirect(Endpoints.HOME);
//    }


    private Carrito obtenerUnCarrito(){
//        return servicioDeCarritos.buscarElCarrito(carrito.getId()); //TODO: Eventualmene lo voy a necesitar.
        return carrito;
    }

    private Catalogo obtenerCatalogo(Integer id){
        return servicioDeCatalogo.darCatalogo(id);
    }

    private void inicializarCatalogo(Catalogo catalogo){
        servicioDeCatalogo.guardarCatalogo(catalogo);
    }
}
