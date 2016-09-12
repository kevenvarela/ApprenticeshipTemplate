package com.tenpines;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertTrue;

public class CarritoTest{

    private Carrito carrito;
    private ProvedorDeObjetos provedor;

    @Before
    public void setUp() {
        provedor = new ProvedorDeObjetos();
        carrito = provedor.carritoVacio();
    }

    @Test
    public void test001AlCrearUnCarritoDebeEstarVacio(){
        assertThat(carrito.estaVacio()).isEqualTo(true);
    }

    @Test
    public void test002AlAgregarleUnItemAUnCarritoDebeContenerloYDejarDeEstarVacio(){
        carrito.agregarItem("Guerra de los mundos");
        assertThat(carrito.contiene("Guerra de los mundos")).isEqualTo(true);
        assertThat(carrito.estaVacio()).isEqualTo(false);
    }

    @Test
    public void test003AlAgregarleUnItemDebeConterloUnaVez(){
        carrito.agregarItem("Guerra de los mundos");
        assertThat(carrito.contidadDeUnItem("Guerra de los mundos")).isEqualTo(1);
    }

    @Test
    public void test004AlAgregarUnaCantidadDeItemsLaCantidadTotalDeEllosEsLaMismaCantidad(){
        carrito.agregarItem("Guerra de los mundos");
        carrito.agregarItem("El Principito");
        assertThat(carrito.cantidadTotalDeItems()).isEqualTo(2);
    }

    @Test
    public void test005AgregarUnItemUnaCiertaCantidadDeVecesYQueSeHayaAgregadoEsaCantidad(){
        carrito.agregarItem("Guerra de los mundos");
        carrito.agregarItem("Guerra de los mundos");
        carrito.agregarItem("Guerra de los mundos");
        carrito.agregarItem("Guerra de los mundos");
        assertThat(carrito.contidadDeUnItem("Guerra de los mundos")).isEqualTo(4);
    }

    @Test
    public void test006AlAgregarUnItemQueNoEsDeEstaEditorialSeDebeLanzarExcepcionYNoDebeSerAgregado(){
        try {
            carrito.agregarItem("INVALIDO");
            assertTrue("nunca deberia llegar aca", false);
        } catch (RuntimeException e) {
            assertThat(e.getMessage()).isEqualTo(Carrito.mensajeDeErrorCuandoUnLibroNoEsValido());
        }
    }

}
