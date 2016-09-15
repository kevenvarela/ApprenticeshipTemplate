package com.tenpines;

import com.tenpines.starter.modelo.Carrito;
import com.tenpines.starter.modelo.ProvedorDeObjetos;
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
    public void alCrearUnCarritoDebeEstarVacio(){
        assertThat(carrito.estaVacio()).isEqualTo(true);
    }

    @Test
    public void alAgregarleUnItemAUnCarritoDebeContenerloYDejarDeEstarVacio(){
        carrito.agregarLibro("Guerra de los mundos",1);
        assertThat(carrito.contiene("Guerra de los mundos")).isEqualTo(true);
        assertThat(carrito.estaVacio()).isEqualTo(false);
    }

    @Test
    public void alAgregarleUnItemDebeConterloUnaVez(){
        carrito.agregarLibro("Guerra de los mundos",1);
        assertThat(carrito.contidadDeUnItem("Guerra de los mundos")).isEqualTo(1);
    }

    @Test
    public void alAgregarUnaCantidadDeItemsLaCantidadTotalDeEllosEsLaMismaCantidad(){
        carrito.agregarLibro("Guerra de los mundos",1);
        carrito.agregarLibro("Nacidos de la bruma",1);
        assertThat(carrito.cantidadTotalDeItems()).isEqualTo(2);
    }

    @Test
    public void agregarUnItemUnaCiertaCantidadDeVecesYQueSeHayaAgregadoEsaCantidad(){
        carrito.agregarLibro("Guerra de los mundos",4);
        assertThat(carrito.contidadDeUnItem("Guerra de los mundos")).isEqualTo(4);
    }

    @Test
    public void alAgregarUnaCantidadDeVecesUnLibroYOtroLibroAlConsultarMeDevuelveLaCantidadDelConsultado(){
        carrito.agregarLibro("Guerra de los mundos",4);
        carrito.agregarLibro("El perfume",2);
        assertThat(carrito.contidadDeUnItem("Guerra de los mundos")).isEqualTo(4);
        assertThat(carrito.contidadDeUnItem("El perfume")).isEqualTo(2);
    }

    @Test
    public void alAgregarUnItemQueNoEsDeEstaEditorialSeDebeLanzarExcepcionYNoDebeSerAgregado(){
        try {
            carrito.agregarLibro("INVALIDO",1);
            assertTrue("nunca deberia llegar aca", false);
        } catch (RuntimeException excepcionLibroInvalido) {
            assertThat(excepcionLibroInvalido.getMessage()).isEqualTo(Carrito.mensajeDeErrorCuandoUnLibroNoEsValido());
        }
    }

    @Test
    public void noSePuedenAgregarCantidadesNegativasDeUnLibro(){
        try {
            carrito.agregarLibro("Guerra de los mundos", -2);
            assertTrue("nunca deberia llegar aca", false);
        } catch (RuntimeException excepcionCantidadInvalida) {
            assertThat(excepcionCantidadInvalida.getMessage()).isEqualTo(Carrito.mensajeDeErrorCuandoAgregoLibrosUnaCantidadNegativa());
        }
    }



}
