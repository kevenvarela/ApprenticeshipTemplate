package com.tenpines.controller;

import com.tenpines.starter.Carrito;
import com.tenpines.starter.HomeController;
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
    public void testController001ElCarritoDebeSerElMismoCuandoAgregoUnItem (){
        Carrito carrito = entrarANuevaCompra();
        Carrito carrito2 = entrarANuevaCompra();

        assertThat(carrito).isNotNull();
        assertThat(carrito).isEqualTo(carrito2);
    }

    @Test
    public void testController002AgregarUnItemAlCarroYQueSeMuestreEseItem (){
        Carrito carrito = entrarANuevaCompra();

        assertThat(carrito).isNotNull();
    }

    private Carrito entrarANuevaCompra() {
        ModelAndView nuevoCarritoMVC = controler.nuevoCarro();
        Carrito carrito = (Carrito) nuevoCarritoMVC.getModel().get("carrito");
        return carrito;
    }
}
