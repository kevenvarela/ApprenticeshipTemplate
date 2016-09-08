package com.tenpines.repositorioPersistencia;

import com.tenpines.repositorioPersistencia.Repositorio;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RepositorioTest {

    private Repositorio repositorio;

    @Before
    public void setUp() {
        repositorio = new Repositorio();
    }

    @Test
    public void test1(){
        repositorio.guardar("libro");
        assertThat(repositorio.tomar(0)).isEqualTo("libro");
    }
}