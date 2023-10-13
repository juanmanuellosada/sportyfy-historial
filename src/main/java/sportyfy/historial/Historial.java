package sportyfy.historial;

import lombok.Getter;
import sportyfy.core.Pronostico;
import sportyfy.core.PronosticoNull;
import sportyfy.core.core.SportyfyCore;

import java.util.*;

@SuppressWarnings("deprecation")
public class Historial implements Observer {
    @Getter
    private List<Pronostico> pronosticosRealizados;

    public Historial(){
        this.pronosticosRealizados = new ArrayList<>();
    }

    private void guardarPronostico(Pronostico p){
        if(p != null)
            this.pronosticosRealizados.add(p);
        else {
//            PronosticoNullParaHistorial pronosticoNull = new PronosticoNullParaHistorial(p.getEquipoLocal(),p.getEquipoVisitante(),null);
            this.pronosticosRealizados.add( new PronosticoNull());
        }
    }

    public  List<Pronostico> getPronosticosRealizados(){
        return this.pronosticosRealizados;
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
