package sportyfy.historial;

import org.junit.jupiter.api.*;
import sportyfy.core.Pronostico;
import sportyfy.core.core.SportyfyCore;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.entidades.partido.PartidoFuturo;
import sportyfy.core.iniciadores.IniciadorSportyfyCore;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class US5 {
    private Equipo gimnasiaDeLaPlata;
    private Equipo riverPlate;
    private SportyfyCore sportyfyCore;
    private Historial historial;
    private PartidoFuturo partidoFuturo;

    @BeforeEach
    public void Escenario() throws IOException, IllegalArgumentException {
        historial = new Historial();
        IniciadorSportyfyCore iniciador = new IniciadorSportyfyCore();
        sportyfyCore = iniciador.iniciar("src/pronosticadores");

        gimnasiaDeLaPlata = sportyfyCore.getEquipos().get(0);
        riverPlate = sportyfyCore.getEquipos().get(1);

        partidoFuturo = new PartidoFuturo(gimnasiaDeLaPlata, riverPlate);
    }

    @Test
    @Order(1)
    @DisplayName("Se guarda un pronostico con equipo ganador en el historial")
    void testAgregarPronosticoAlHistorial() {
        Pronostico pronostico = new Pronostico(riverPlate,partidoFuturo);
        sportyfyCore.setPronosticoActual(pronostico);
        historial.update(sportyfyCore,null);

        assertEquals(riverPlate,historial.getPronosticosRealizados().get(0).getEquipoGanador());
    }

    @Test
    @Order(2)
    @DisplayName("Se guarda un pronostico de empate en el historial")
    void testAgregarPronosticoNullAlHistorial() {
        Pronostico pronostico = new Pronostico(null,partidoFuturo);
        sportyfyCore.setPronosticoActual(pronostico);
        historial.update(sportyfyCore,null);

        assertNull(historial.getPronosticosRealizados().get(0).getEquipoGanador());
    }
}
