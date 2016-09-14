package com.tenpines.starter.web;

import com.tenpines.starter.modelo.Carrito;
import com.tenpines.starter.rest.AgregarRequest;
import com.tenpines.starter.servicios.ServicioDeCarritos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class CarritoController {
    private ServicioDeCarritos servicio;

    @Autowired
    public CarritoController(ServicioDeCarritos servicioDeCarritos) {
        this.servicio = servicioDeCarritos;
    }

    @RequestMapping(Endpoints.HOME)
    String home(Model model) {
        model.addAttribute("mensajes", obtener());
        return "nuevaCompra";
    }

    @RequestMapping(value = Endpoints.AGREGAR_CARRITO, method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    void agregar(AgregarRequest carrito, HttpServletResponse response) throws IOException {
        servicio.almacenar(carrito);
        response.sendRedirect(Endpoints.HOME);
    }

    @RequestMapping(value = Endpoints.OBTENER_CARRITO, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    List<Carrito> obtener(){
        return (List<Carrito>) servicio.buscarTodos();
    }
}
