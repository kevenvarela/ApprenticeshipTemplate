package tenpines.starter.modelo;


import com.tenpines.starter.modelo.Cajero;
import com.tenpines.starter.modelo.Carrito;
import com.tenpines.starter.modelo.Cliente;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;
import static tenpines.starter.modelo.ProveedorDeObjetos.UN_PRECIO_BIEN_CONOCIDO;

public class CajeroTest {

    private Cliente cliente = Cliente.crearCliente("1234");

    private Carrito carrito = Carrito.crearCarrito(cliente);
    private Cajero cajero = new Cajero();
    private ProveedorDeObjetos proveedor;

    @Before
    public void Setup(){
        proveedor = new ProveedorDeObjetos();
    }

    @Test
    public void noSePuedeCobrarUnCarroVacio(){
        try {cajero.cobrar(carrito);
            assertTrue("nunca deberia llegar aca", false);
        } catch (RuntimeException excepcionNoCobrarCarrosVacios) {
            assertThat(excepcionNoCobrarCarrosVacios.getMessage()).isEqualTo(Cajero.mensajeDeErrorCuandoQuieroCobrarUnCarroVacio());
        }
    }

    @Test
    public void cobrarUnCarritoCon1Itemy1UnidadDeEseMismoDeberiaCobrar45Pesos(){
        carrito.agregarLibro(proveedor.crearLibro(),1);
        assertThat(cajero.cobrar(carrito)).isEqualTo(UN_PRECIO_BIEN_CONOCIDO);
    }

    @Test
    public void cobrarUnCarritoCon1Itemy2Unidades(){
        carrito.agregarLibro(proveedor.crearLibro(),2);
        assertThat(cajero.cobrar(carrito)).isEqualTo(2 * UN_PRECIO_BIEN_CONOCIDO);
    }

    @Test
    public void cobrarUnCarritoCon2Libros(){
        carrito.agregarLibro(proveedor.crearLibro(),1);
        carrito.agregarLibro(proveedor.crearOtroLibro(),1);
        assertThat(cajero.cobrar(carrito)).isEqualTo(140);
    }

    @Test
    public void cobrarUnCarritoCon2DeUnoyOtro(){
        carrito.agregarLibro(proveedor.crearLibro(),2);
        carrito.agregarLibro(proveedor.crearOtroLibro(),1);
        assertThat(cajero.cobrar(carrito)).isEqualTo(185);
    }

    @Test
    public void cobrarUnCarritoConUnaTarjetaDeCreditoValida(){
        carrito.agregarLibro(proveedor.crearLibro(),2);
        carrito.agregarLibro(proveedor.crearOtroLibro(),1);
        assertThat(cajero.cobrar(carrito)).isEqualTo(185);
    }
}
