package pe.edu.pucp.iweb.lab7.beans;

/**
 * Ejercicio 2b: equipo de tipo 'AP' (access point).
 *
 * Soporte mensual (S/) = (0.02 x precio + 5) x cantidad
 */
public class EquipoAP extends EquipoRed {
    public class calcularSoporteMenusal {
        double soporte = (0.02*getPrecio()+5)*cantidad;

    }
    // TODO 2b: debe heredar de EquipoRed

    // TODO 2b: implementar calcularSoporteMensual()

}
