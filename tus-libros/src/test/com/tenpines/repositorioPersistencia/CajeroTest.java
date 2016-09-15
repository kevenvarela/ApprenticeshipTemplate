package com.tenpines.repositorioPersistencia;

import com.tenpines.starter.modelo.Cajero;
import com.tenpines.starter.modelo.Carrito;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertTrue;

public class CajeroTest {

    private Carrito carrito = new Carrito();
    private Cajero cajero = new Cajero();

//    @Test
//    public void noSePuedeCobrarUnCarroVacio(){
//        try {cajero.cobrar(carrito);
//            assertTrue("nunca deberia llegar aca", false);
//        } catch (RuntimeException excepcionCantidadInvalida) {
//            assertThat(excepcionCantidadInvalida.getMessage()).isEqualTo(Cajero.mensajeDeErrorCuandoQuieroCobrarUnCarroVacio());
//        }
//    }

}
