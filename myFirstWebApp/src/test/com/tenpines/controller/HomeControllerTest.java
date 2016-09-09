package com.tenpines.controller;

import com.tenpines.Carrito;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeControllerTest {

    private HomeController controler;

    @Before
    public void setUP(){
        controler = new HomeController();
    }

    @Test
    public void XXX (){
        Carrito carrito = entrarANuevaCompra();
        Carrito carrito2 = entrarANuevaCompra();

        assertThat(carrito).isNotNull();
        assertThat(carrito).isEqualTo(carrito2);
    }

    private Carrito entrarANuevaCompra() {
        ModelAndView nuevoCarritoMVC = controler.nuevoCarro();
        Carrito carrito = (Carrito) nuevoCarritoMVC.getModel().get("carrito");
        return carrito;
    }
}
