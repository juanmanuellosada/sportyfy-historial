package sportyfy.historial;

import lombok.Getter;
import sportyfy.core.entidades.partido.Partido;
import sportyfy.core.entidades.resultado.Resultado;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

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
    private final Map<Partido, Resultado> pronosticosRealizados = new HashMap<>();

    /**
     * Método que se ejecuta cuando se realiza un nuevo pronóstico.
     * <p>
     * Este método se encarga de almacenar el nuevo pronóstico en el historial.
     *
     * @param evt Evento que contiene el nuevo pronóstico (el resultado).
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("resultado".equals(evt.getPropertyName())) {
            Resultado nuevoResultado = (Resultado) evt.getNewValue();
            Partido partido = new Partido(nuevoResultado.getPrimerEquipo(), nuevoResultado.getSegundoEquipo());
            this.pronosticosRealizados.put(partido, nuevoResultado);
        }
    }
}
