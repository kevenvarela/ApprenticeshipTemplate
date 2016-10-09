package com.tenpines.tusLibros.modelo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RelojTest {

    @Test
    public void unRelojDebeSerCreadoConUnaHoraYUnosMinutosValidosYCuandoSeLoPidoDarmeEsaHoraYMinutos(){
        RelojDePrueba reloj1230horas = new RelojDePrueba(12,30);
        assertThat(reloj1230horas.obtenerHora()).isEqualTo(12);
        assertThat(reloj1230horas.obtenerMinutos()).isEqualTo(30);
    }
}
