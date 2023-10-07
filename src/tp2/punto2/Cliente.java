/* DEO GLORIA
 * conatus me
 */

package tp2.punto2;

import java.util.ArrayList;

public class Cliente {

    private String nombre;
    private ArrayList<PaqueteTurismo> paquetesComprados;

    public Cliente (String nombre) {

        this.nombre = nombre;
        paquetesComprados = new ArrayList<PaqueteTurismo>();

    }

    public void comprarPaquete (PaqueteTurismo nuevoPaquete) {

        paquetesComprados.add(nuevoPaquete);

    }

    public void setNombre (String nombre) {

        this.nombre = nombre;
    }

    public String getNombre () {

        return nombre;
    }

    public String toString () {

        return nombre;
    }

}
