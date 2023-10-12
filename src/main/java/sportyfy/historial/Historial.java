package sportyfy.historial;

import lombok.Getter;
import sportyfy.core.Pronostico;
import sportyfy.core.core.SportyfyCore;

import java.util.*;

@SuppressWarnings("deprecation")
public class Historial implements Observer {
    @Getter
    List<Pronostico> pronosticosRealizados;

    public Historial(){
        pronosticosRealizados = new ArrayList<>();
    }

    private void guardarPronostico(Pronostico p){
        pronosticosRealizados.add(p);
        System.out.println("Pronostico: "+p.getEquipoGanador().getNombre());
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
