package com.tenpines.starter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public ModelAndView inicio() {
        ModelAndView mav = new ModelAndView();
        LocalDateTime laHora = LocalDateTime.now();

        mav.setViewName("tusLibrosHome");
        mav.addObject("hora", laHora);

        return mav;
    }

    Carrito carritoNuevo = new Carrito();

    @RequestMapping(value = "/nueva_compra")
    public ModelAndView nuevoCarro() {
        ModelAndView mav = new ModelAndView();
        LocalDateTime laHora = LocalDateTime.now();

        mav.setViewName("nuevaCompra");
        mav.addObject("hora", laHora);
        mav.addObject("carrito", carritoNuevo);
        return mav;
    }

    @RequestMapping(value = "/nueva_compra", method = RequestMethod.GET, params = "item")

    String agregar(@RequestParam String item) {
        carritoNuevo.agregarItem(item);
        return "itemCorrecto";
    }
}
