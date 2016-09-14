package com.tenpines.starter.web;

import com.tenpines.starter.modelo.Carrito;
import com.tenpines.starter.servicios.ServicioDeCarritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class CarritoController {
    private ServicioDeCarritos servicio;
    Carrito carrito = new Carrito();

    @Autowired
    public CarritoController(ServicioDeCarritos servicioDeCarritos) {
        this.servicio = servicioDeCarritos;
    }

    @RequestMapping(Endpoints.HOME)
    String home(Model model) {
        model.addAttribute("carrito", obtenerUnCarrito());
        return "nuevaCompra";
    }

    @RequestMapping(value = Endpoints.AGREGAR_CARRITO, method = RequestMethod.POST)
    void crearUnCarrito(HttpServletResponse response) throws IOException {
        response.sendRedirect(Endpoints.HOME);
        carrito = new Carrito();
    }

    @RequestMapping(value = Endpoints.AGREGAR_ITEM, method = RequestMethod.POST)
    void agregarUnLibro(@RequestParam(value = "elemento") String unLibro, HttpServletResponse response) throws IOException {
        carrito.agregarItem(unLibro);
        response.sendRedirect(Endpoints.HOME);
    }

    private Carrito obtenerUnCarrito(){
        return carrito;
     }
}
