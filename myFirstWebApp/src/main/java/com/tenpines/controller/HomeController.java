package com.tenpines.controller;

import com.tenpines.Carrito;
import com.tenpines.ProvedorDeObjetos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;


@Controller
public class HomeController {

    ProvedorDeObjetos provedorDeObjetos = new ProvedorDeObjetos();

    @RequestMapping(value = "/")
    public ModelAndView resultado() {
        ModelAndView unModeloVista = new ModelAndView();
        LocalDateTime horaActual = LocalDateTime.now();
        Carrito unCarrito = provedorDeObjetos.carritoConUnLibro();

        unModeloVista.setViewName("tusLibros");
        unModeloVista.addObject("horaActual", horaActual);
        unModeloVista.addObject("carrito", unCarrito);

        return unModeloVista;
    }
}