package tenpines.starter.modelo;


import com.tenpines.starter.modelo.TarjetaDeCredito;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

public class TarjetaDeCreditoTest {

    private LocalDate fechaDeVencimiento = LocalDate.of(2020, Month.DECEMBER, 1); // 2020-12-1
    private LocalDate fechaDeVencimientoCumplida = LocalDate.of(2000, Month.DECEMBER, 1); // 2000-12-1
    private TarjetaDeCredito tarjeta;
    private TarjetaDeCredito tarjetaExpirada;

    @Test
    public void alCrearUnaTarjetaDeCreditoValidaDebeTenerNumeroNombreDuenioYFechaValida(){
        tarjeta = TarjetaDeCredito.nuevaTarjeta(1000200030004000L, fechaDeVencimiento,"Roberto Perez");
        assertThat(tarjeta.getFechaDeExpiracion()).isEqualTo(fechaDeVencimiento);
        assertThat(tarjeta.getNumero()).isEqualTo(1000200030004000L);
        assertThat(tarjeta.getNombreDuenio()).isEqualTo("Roberto Perez");
    }

    @Test
    public void siLaTarjetaEstaExpiradaDebeLanzarUnaExcepcionYnoDebeCrearse(){
        try {
            tarjetaExpirada = TarjetaDeCredito.nuevaTarjeta(1000200030004000L, fechaDeVencimientoCumplida,"Roberto Perez");
            assertTrue("nunca deberia llegar aca", false);
        } catch (RuntimeException excepcionTarjetaDeCreditoExpirada) {
            AssertionsForClassTypes.assertThat(excepcionTarjetaDeCreditoExpirada.getMessage()).isEqualTo(TarjetaDeCredito.mensajeDeErrorCuandoLaTarjetaEstaExpirada());
        }
        assertThat(tarjetaExpirada).isNull();
    }

    @Test
    public void siElNombreDelDuenioDeLaTarjetaEsDemasiadoLargoDebeLanzarUnaExcepcionYNoDebeSerCreada(){
        try {
            tarjeta = TarjetaDeCredito.nuevaTarjeta(1000200030004000L, fechaDeVencimiento,"Este nombre es demasiado largo para el duenio de una tarjeta de credito");
            assertTrue("nunca deberia llegar aca", false);
        } catch (RuntimeException excepcionNombreDuenioDeTarjetaInvalida) {
            AssertionsForClassTypes.assertThat(excepcionNombreDuenioDeTarjetaInvalida.getMessage()).isEqualTo(TarjetaDeCredito.mensajeDeErrorCuandoElNombreDuenioDeUnaTarjetaEsMuyLargo());
        }
        assertThat(tarjeta).isNull();
    }
}