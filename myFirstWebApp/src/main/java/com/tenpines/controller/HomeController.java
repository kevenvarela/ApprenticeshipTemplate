package com.tenpines.controller;

import com.tenpines.Acumulador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;


@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String suma() {

        return "paginaSumador";
    }
    @RequestMapping(value = "/resultado")
    public ModelAndView resultado() {
        ModelAndView mav = new ModelAndView();
        LocalDateTime laHora = LocalDateTime.now();
        Acumulador unAcumulador = new Acumulador();

        mav.setViewName("resultadoSumador");
        mav.addObject("hora", laHora);
        mav.addObject("acumulador", unAcumulador);
        return mav;
    }
}