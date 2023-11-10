package sportyfy.historial;

import lombok.Getter;
import sportyfy.core.entidades.partido.Partido;
import sportyfy.core.entidades.resultado.Resultado;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.*;

/**
 * Clase que representa el historial de pronósticos realizados por un usuario.
 * <p>
 * Esta clase implementa la interfaz {@link PropertyChangeListener} para poder
 * ser notificada cuando se realice un nuevo pronóstico.
 * <p>
 * El historial de pronosticos se almacena en un {@link HashMap} donde la clave
 * es el partido y el valor es el resultado del pronóstico.
 */
@Getter
public class Historial implements PropertyChangeListener {

    private Map<Partido, Resultado> pronosticosRealizados = new HashMap<>();

    /**
     * Método que se ejecuta cuando se realiza un nuevo pronóstico.
     * 
     * Este método se encarga de almacenar el nuevo pronóstico en el historial.
     *
     * @param evt Evento que contiene el nuevo pronóstico (el resultado).
     */
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
