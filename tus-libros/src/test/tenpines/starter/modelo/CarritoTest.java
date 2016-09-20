package tenpines.starter.modelo;

import com.tenpines.starter.modelo.Carrito;
import com.tenpines.starter.modelo.Libro;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertTrue;

public class CarritoTest{

    private Carrito carrito;
    private ProveedorDeObjetos provedor;
    private Libro libroElPerfume;
    private Libro libroGuerraDeLosMundos;
    private Libro libroInvalido;

    @Before
    public void setUp() {
        provedor = new ProveedorDeObjetos();
        carrito = provedor.carritoVacio();
        libroElPerfume = provedor.crearLibro();
        libroGuerraDeLosMundos = provedor.crearOtroLibro();
        libroInvalido = provedor.crearLibroInvalido();
    }

    @Test
    public void alCrearUnCarritoDebeEstarVacio(){
        assertThat(carrito.estaVacio()).isEqualTo(true);
    }

    @Test
    public void alAgregarleUnItemAUnCarritoDebeContenerloYDejarDeEstarVacio(){
        carrito.agregarLibro(libroElPerfume,1);
        assertThat(carrito.contiene(libroElPerfume)).isEqualTo(true);
        assertThat(carrito.estaVacio()).isEqualTo(false);
    }

    @Test
    public void alAgregarleUnItemDebeConterloUnaVez(){
        carrito.agregarLibro(libroElPerfume,1);
        assertThat(carrito.contidadDeUnItem(libroElPerfume)).isEqualTo(1);
    }

    @Test
    public void alAgregarUnaCantidadDeItemsLaCantidadTotalDeEllosEsLaMismaCantidad(){
        carrito.agregarLibro(libroElPerfume,1);
        carrito.agregarLibro(libroGuerraDeLosMundos,1);
        assertThat(carrito.cantidadTotalDeItems()).isEqualTo(2);
    }

    @Test
    public void agregarUnItemUnaCiertaCantidadDeVecesYQueSeHayaAgregadoEsaCantidad(){
        carrito.agregarLibro(libroGuerraDeLosMundos,4);
        assertThat(carrito.contidadDeUnItem(libroGuerraDeLosMundos)).isEqualTo(4);
    }

    @Test
    public void alAgregarUnaCantidadDeVecesUnLibroYOtroLibroAlConsultarMeDevuelveLaCantidadDelConsultado(){
        carrito.agregarLibro(libroGuerraDeLosMundos,4);
        carrito.agregarLibro(libroElPerfume,2);
        assertThat(carrito.contidadDeUnItem(libroGuerraDeLosMundos)).isEqualTo(4);
        assertThat(carrito.contidadDeUnItem(libroElPerfume)).isEqualTo(2);
    }


    @Test
    public void noSePuedenAgregarCantidadesNegativasDeUnLibro(){
        try {
            carrito.agregarLibro(libroGuerraDeLosMundos, -2);
            assertTrue("nunca deberia llegar aca", false);
        } catch (RuntimeException excepcionCantidadInvalida) {
            assertThat(excepcionCantidadInvalida.getMessage()).isEqualTo(Carrito.mensajeDeErrorCuandoAgregoLibrosUnaCantidadNegativa());
        }
    }
}

