import com.tenpines.Agenda;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AgendaTest {

    private Agenda agenda;

    @Before
    public void setUp() {
        agenda = new Agenda();
    }

    @Test
    public void test001(){
        assertThat(agenda.mostrarFecha()).isEqualTo("05/09/2016");
    }
}