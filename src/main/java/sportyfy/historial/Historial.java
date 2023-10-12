package sportyfy.historial;

import sportyfy.core.Pronostico;
import sportyfy.core.core.SportyfyCore;

import java.util.*;

@SuppressWarnings("deprecation")
public class Historial implements Observer {
    List<Pronostico> pronosticosRealizados;

    private Historial(){
        pronosticosRealizados = new ArrayList<>();
    }

    private void guardarPronostico(Pronostico p){
        pronosticosRealizados.add(p);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof SportyfyCore) {
            SportyfyCore sportyfyCore = (SportyfyCore) o;
            Pronostico pronosticoActual = sportyfyCore.getPronosticoActual();
            guardarPronostico(pronosticoActual);
        }
    }
}
