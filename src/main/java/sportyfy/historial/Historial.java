package sportyfy.historial;

import lombok.Getter;
import sportyfy.core.PronosticoNullParaHistorial;
import sportyfy.core.PronosticoParaHistorial;
import sportyfy.core.core.SportyfyCore;

import java.util.*;

@SuppressWarnings("deprecation")
public class Historial implements Observer {
    @Getter
    private List<PronosticoParaHistorial> pronosticosRealizados;

    public Historial(){
        this.pronosticosRealizados = new ArrayList<>();
    }

    private void guardarPronostico(PronosticoParaHistorial p){
        if(p != null)
            this.pronosticosRealizados.add(p);
        else {
            PronosticoNullParaHistorial pronosticoNull = new PronosticoNullParaHistorial();
            pronosticoNull.setEquipoLocal(p.getEquipoLocal());
            pronosticoNull.setEquipoGanador(p.getEquipoGanador());
            this.pronosticosRealizados.add(pronosticoNull);
        }
    }

    public  List<PronosticoParaHistorial> getPronosticosRealizados(){
        return this.pronosticosRealizados;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof SportyfyCore) {
            SportyfyCore sportyfyCore = (SportyfyCore) o;
            PronosticoParaHistorial pronosticoActual = sportyfyCore.getPronosticoActualParaHistorial();
            guardarPronostico(pronosticoActual);

        }
    }
}
