package tenpines.starter.modelo;


import com.tenpines.starter.modelo.Libro;
import org.junit.Test;

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


}
