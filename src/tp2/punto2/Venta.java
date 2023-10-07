/* DEO GLORIA
 * conatus me
 */

package tp2.punto2;

public class Venta {

    private Cliente comprador;
    private Destino localizacion;
    private PaqueteTurismo paqTurismo;

    public Venta (Cliente cliente, Destino lugar, PaqueteTurismo paqTurismo) {

        comprador = cliente;
        localizacion = lugar;
        this.paqTurismo = paqTurismo;

    }

    public Cliente getCliente () {

        return comprador;
    }

    public Destino getLugar () {

        return localizacion;
    }

    public PaqueteTurismo getPaqTurismo () {

        return paqTurismo;
    }

    public String toString () {

        return (comprador + " ha viajado a " + localizacion + " \nCon el paquete " + paqTurismo.getNombre());
    }

}
