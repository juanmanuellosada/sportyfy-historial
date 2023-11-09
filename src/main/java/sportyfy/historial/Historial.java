package sportyfy.historial;

import lombok.Getter;
import sportyfy.core.entidades.partido.Partido;
import sportyfy.core.entidades.resultado.Resultado;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

@Getter
public class Historial implements PropertyChangeListener{
    private Map<Partido, Resultado> pronosticosRealizados;

    public Historial(){
        this.pronosticosRealizados = new HashMap<>();
    }

//    public  Map<Partido, Resultado> getPronosticosRealizados(){
//        return this.pronosticosRealizados;
//    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("resultado".equals(evt.getPropertyName())) {
            Resultado resultadoNuevo = (Resultado) evt.getNewValue();
            System.out.println("Se hizo un nuevo pronóstico con este resultado: " + resultadoNuevo.toString());
            Partido partido = new Partido(resultadoNuevo.getPrimerEquipo(), resultadoNuevo.getSegundoEquipo());
            this.pronosticosRealizados.put(partido, resultadoNuevo);
        }
    }
}
