package com.tenpines.tusLibros.modelo;


import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;


public class LibroTest {

    Libro libro = Libro.crearLibro("El perfume", "123456789", 45);

    @Test
    public void alCrearUnCatalogoSuNombreEsIgualAlDeSuCreacion(){
        assertThat(libro.getNombreLibro()).isEqualTo("El perfume");
    }

    @Test
    public void alCrearUnLibroDebeTenerContenerNombreIsbnYPrecio(){
        assertThat(libro.getNombreLibro()).isEqualTo("El perfume");
        assertThat(libro.getIsbn()).isEqualTo("123456789");
        assertThat(libro.getPrecio()).isEqualTo(45);
    }

    @Test
    public void noSePuedenCrearUnLibroInvalido(){
        try {
            Libro.crearLibro(null,"123123123",50);
            assertTrue("nunca deberia llegar aca", false);
        } catch (RuntimeException excepcionLibroInvalido) {
            assertThat(excepcionLibroInvalido.getMessage()).isEqualTo(Libro.mensajeDeErrorCuandoQuieroCrearUnLibroInvalido());
        }
    }
}
