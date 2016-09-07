import com.tenpines.Acumulador;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SumadorTest {

    private Acumulador sumador;

    @Before
    public void setUp() {
        sumador = new Acumulador();

    }

    @Test
    public void test001(){
        assertThat(sumador.sumar(2,6)).isEqualTo(8);
    }
}