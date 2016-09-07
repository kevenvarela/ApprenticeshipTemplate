package com.tenpines.controller;

import com.tenpines.Sumador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

    @RequestMapping(value = "/sumador")
    public String suma() {

        return "paginaSumador";
    }
    @RequestMapping(value = "/resultado")
    public String resultado() {
        Sumador sumador_web = new Sumador();

        //sumador_web.sumar(,b);

        return "resultadoSumador";
    }
}