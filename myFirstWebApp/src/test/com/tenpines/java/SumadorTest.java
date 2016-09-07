import com.tenpines.Sumador;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SumadorTest {

    private Sumador sumador;

    @Before
    public void setUp() {
        sumador = new Sumador();

    }

    @Test
    public void test001(){
        assertThat(sumador.sumar(2,6)).isEqualTo(8);
    }
}