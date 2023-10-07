/* DEO GLORIA
 * conatus me
 */

package tp2.punto2;

import java.util.ArrayList;

public class PaqueteTurismo {

    private String nombre;
    private Destino localizacion;
    private Proveedor medioDeTransporte;
    private Proveedor hospedaje;
    private ArrayList<Proveedor> excursiones;

    //Se asegura de que los proveedores sean de la localizacion correspondiente del paquete de turismo
    private static boolean verificarLocalizacion (Destino localizacion, Proveedor proveedor) {

        return (localizacion.equals(proveedor.getLocalizacion()));
    }

    private PaqueteTurismo (String nombre, Destino localizacion,
                            Proveedor medioDeTransporte, Proveedor hospedaje) {

        this.nombre = nombre;
        this.localizacion = localizacion;
        this.medioDeTransporte = medioDeTransporte;
        this.hospedaje = hospedaje;
        excursiones = new ArrayList<Proveedor>();

    }

    public static PaqueteTurismo crearPaqueteTurismo (String nombre, Destino localizacion,
                                                      Proveedor medioDeTransporte, Proveedor hospedaje) {

        PaqueteTurismo paqTur = null;

        if ((verificarLocalizacion(localizacion, medioDeTransporte)) &&
                (verificarLocalizacion(localizacion, hospedaje))) {

            if ((medioDeTransporte.esMedioDeTransporte()) && (hospedaje.esHospedaje())) {

                paqTur = new PaqueteTurismo(nombre, localizacion, medioDeTransporte, hospedaje);

            } else {

                System.out.println("Tipo de proveedores incorrecto.");

            }

        } else {

            System.out.println("Proveedores no pertenecen a la localizacion establecida.");

        }


        return paqTur;
    }

    public void setNombre (String nombre) {

        this.nombre = nombre;
    }

    public void setLocalizacion (Destino localizacion) {

        this.localizacion = localizacion;
    }

    public void setMedioDeTransporte (Proveedor medioDeTransporte) {

        if ((verificarLocalizacion(localizacion, medioDeTransporte))
                && (medioDeTransporte.esMedioDeTransporte())) {

            this.medioDeTransporte = medioDeTransporte;

        } else {

            System.out.println("medioDeTransporte no es medioDeTransporte.");

        }

    }

    public void setHospedaje (Proveedor hospedaje) {

        if ((verificarLocalizacion(localizacion, hospedaje)) && (hospedaje.esHospedaje())) {

            this.hospedaje = hospedaje;

        } else {

            System.out.println("hospedaje no es hospedaje.");

        }

    }

    public void aniadirExcursion (Proveedor excursion) {

        if ((verificarLocalizacion(localizacion, excursion)) && (excursion.esExcursion())) {

            excursiones.add(excursion);

        } else {

            System.out.println("excursion no es excursion.");

        }

    }

    public String getNombre () {

        return nombre;
    }

    public String getLocalizacion () {

        return localizacion.getNombre();
    }

    public String getMedioDeTransporte () {

        return medioDeTransporte.getNombre();
    }

    public String getHospedaje () {

        return hospedaje.getNombre();
    }

    public String getExcursionN (int n) {

        String nombreExcursion = null;

        if (excursiones.isEmpty()) {

            System.out.println("El tour actualmente no tiene excursiones.");

        } else if (n > excursiones.size()) {

            System.out.println("El tour no cuenta con la excursion pedida.");

        } else {

            nombreExcursion = excursiones.get(n).getNombre();

        }

        return nombreExcursion;
    }

    public boolean equals (PaqueteTurismo otroPaqueteTurismo) {

        return nombre.equals(otroPaqueteTurismo.getNombre());
    }

    public String toString () {

        String paqTurcadena = "Paquete " + nombre;
        paqTurcadena = paqTurcadena.concat("\n" + "Lugar: " + localizacion);
        paqTurcadena = paqTurcadena.concat("\n" + "Medio de transporte: " + medioDeTransporte.getNombre());
        paqTurcadena = paqTurcadena.concat("\n" + "Hospedaje: " + hospedaje.getNombre());
        paqTurcadena = paqTurcadena.concat("\n" + "Excursiones:");

        for (Proveedor excursion : excursiones) {

            paqTurcadena = paqTurcadena.concat("\n" + excursion.getNombre());

        }

        return paqTurcadena;
    }

}
