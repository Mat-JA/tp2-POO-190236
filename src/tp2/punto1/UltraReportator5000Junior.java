/* DEO GLORIA
 * conatus me
 */

package tp2.punto1;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;

//Genera los reportes pedidos.
//TLDR: Perry el ornitorrinco.
public class UltraReportator5000Junior {

    private ArrayList<Socio> socios;
    private ArrayList<Actividad> actividades;

    private void mostrarListaSocios (ArrayList<Socio> socios) {

        for (Socio socio : socios) {

            System.out.println(socio.getNombre() + " " +
                               socio.getApellido() + " " + socio.getNroSocio());

        }

    }

    private void mostrarListaActividades (ArrayList<Actividad> actividades) {

        for (Actividad actividad: actividades) {

            System.out.println(actividad.getNombre());

        }

    }

    public UltraReportator5000Junior () {

        socios = new ArrayList<Socio>();
        actividades = new ArrayList<Actividad>();

    }

    public void aniadirSocio (Socio nuevoSocio) {

        socios.add(nuevoSocio);
    }

    public void aniadirActividad (Actividad nuevaActividad) {

        actividades.add(nuevaActividad);
    }

    public void reporteMensualNuevosSocios () {

        Month mesActual = LocalDate.now().getMonth();
        Year anioActual = Year.of(LocalDate.now().getYear());

        LocalDate fechaInscripcionAux = null;

        System.out.println("\n----REPORTE SOCIOS INSCRIPTOS EN EL PRESENTE MES----\n");

        for (Socio socio : socios) {

            fechaInscripcionAux = socio.getfechaInscripcion();

            if ((fechaInscripcionAux.getMonth().equals(mesActual)) &&
                    (Year.of(fechaInscripcionAux.getYear()).equals(anioActual))) {

                System.out.println(socio.getNombre() + " " +
                                   socio.getApellido() + " " + socio.getNroSocio());

            }

        }

    }

    public void listadoActividadPorNivel () {

        ArrayList<Actividad> actBasicas = new ArrayList<Actividad>();
        ArrayList<Actividad> actIntermedias = new ArrayList<Actividad>();
        ArrayList<Actividad> actDestacadas = new ArrayList<Actividad>();

        for (Actividad actividad : actividades) {

            if (actividad.getNivel() == 'B') {

                actBasicas.add(actividad);

            } else if (actividad.getNivel() == 'I') {

                actIntermedias.add(actividad);

            } else {

                actDestacadas.add(actividad);

            }

        }

        System.out.println("\n----LISTADO ACTIVIDADES POR SUSCRIPCION----\n");

        System.out.println("BÁSICAS");
        mostrarListaActividades(actBasicas);

        System.out.println("\nINTERMEDIAS");
        mostrarListaActividades(actIntermedias);

        System.out.println("\nDESTACADAS");
        mostrarListaActividades(actDestacadas);

    }

    public void listadoSociosPorTipoSuscripcion () {

        ArrayList<Socio> sociosBasicos = new ArrayList<Socio>();
        ArrayList<Socio> sociosIntermedios = new ArrayList<Socio>();
        ArrayList<Socio> sociosDestacados = new ArrayList<Socio>();

        for (Socio socio : socios) {

            if (socio.getTipoSuscripcion() == 'B') {

                sociosBasicos.add(socio);

            } else if (socio.getTipoSuscripcion() == 'I') {

                sociosIntermedios.add(socio);

            } else {

                sociosDestacados.add(socio);

            }

        }

        System.out.println("\n----LISTADO SOCIOS POR SUSCRIPCION----\n");

        System.out.println("BÁSICOS");
        mostrarListaSocios(sociosBasicos);

        System.out.println("\nINTERMEDIOS");
        mostrarListaSocios(sociosIntermedios);

        System.out.println("\nDESTACADOS");
        mostrarListaSocios(sociosDestacados);


    }


}
