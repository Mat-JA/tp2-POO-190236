/* DEO GLORIA
 * conatus me
 */

package tp2.punto2;

public class Destino {

    private String nombre;

    public Destino (String nombre) {

        this.nombre = nombre;

    }

    public void setNombre (String nombre) {

        this.nombre = nombre;
    }

    public String getNombre () {

        return nombre;
    }

    public boolean equals(Destino otroDestino) {

        return (nombre.equals(otroDestino.getNombre()));
    }

    public String toString () {

        return nombre;
    }

}
