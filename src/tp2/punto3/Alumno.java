/* DEO GLORIA
 * San Francisco de Asís
 * Ruega Por Nosotros
 * conatus me
 */

package tp2.punto3;

import java.util.ArrayList;

public class Alumno {

    private int dni;
    private String nombre;
    private String apellido;
    private long telefono;
    private String email;
    private ArrayList<Diagramacion> diagramaciones;
    private ArrayList<Asistencia> asistencias;

    private boolean diagramacionValida (int i) {

        return ((i > 0) && (i <= diagramaciones.size()));
    }

    private boolean asistenciaValida (int i) {

        return ((i > 0) && (i <= asistencias.size()));
    }

    public Alumno(int dni, String nombre, String apellido, long telefono, String email,
                  Diagramacion diagramacion) {

        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;

        diagramaciones = new ArrayList<Diagramacion>();
        diagramaciones.add(diagramacion);

        asistencias = new ArrayList<Asistencia>();
        asistencias.add(new Asistencia(diagramacion));

    }

    public void agregarDiagramacion (Diagramacion diagramacion) {

        diagramaciones.add(diagramacion);
        asistencias.add(new Asistencia(diagramacion));

    }

    public void modificarDiagramacion (int i, Diagramacion diagramacion) {

        if (!diagramacionValida(i-1)) {

            System.out.println("Diagramación seleccionada no válida.");

        } else {

            diagramaciones.remove(i-1);
            diagramaciones.add(i-1, diagramacion);
            asistencias.remove(i-1);
            asistencias.add(i-1, new Asistencia(diagramacion));

        }

    }

    public void eliminarDiagramacion (int i) {

        if (!diagramacionValida(i-1)) {

            System.out.println("Diagramación seleccionada no válida.");

        } else {

            diagramaciones.remove(i-1);
            asistencias.remove(i-1);

        }

    }

    public void registrarAsistencia (int i) {

        if (!asistenciaValida(i-1)) {

            System.out.println("Asistencia seleccionada no válida.");

        } else {

            asistencias.get(i).marcarAsistencia();

        }

    }

    //Para aplicarse al finalizar el reporte mensual
    public void limpiarAsistencias () {

        for (Asistencia asistencia : asistencias) {

            asistencia.resetearAsistencias();

        }

    }

    public int getDni () {

        return dni;
    }

    public String getNombre () {

        return nombre;
    }

    public String getApellido () {

        return apellido;
    }

    public long getTelefono () {

        return telefono;
    }

    public String getEmail () {

        return email;
    }

    public Diagramacion getDiagramacionI (int i) {

        Diagramacion retorno = null;

        if (!diagramacionValida(i-1)) {

            System.out.println("Diagramación no válida.");

        } else {

            retorno = diagramaciones.get(i-1);

        }

        return retorno;
    }

    public Asistencia getAsistenciaI (int i) {

        Asistencia retorno = null;

        if (!asistenciaValida(i-1)) {

            System.out.println("Asistencia no válida.");

        } else {

            retorno = asistencias.get(i);

        }

        return retorno;
    }

    public void mostrarDiagramaciones () {

        System.out.println("Diagramaciones a las que el alumno/a " + nombre + " "
                            + apellido + " está inscripto/a: "  );

        Diagramacion unaDiagramacion = null;

        for (int i = 0; i < diagramaciones.size(); i++) {

            unaDiagramacion = diagramaciones.get(i);

            System.out.println( (i+1) + " " + unaDiagramacion.getDisciplina() + " " +
                                unaDiagramacion.getNombreNivel() + " " + unaDiagramacion.getProfesor());


        }

    }

    public void mostrarAsistencias () {

        System.out.println("Las asistencias de " + nombre + " " + apellido +
                            " según diagramación son: ");

        Asistencia unaAsistencia = null;

        for (int i = 0; i < asistencias.size(); i++) {

            unaAsistencia = asistencias.get(i);

            System.out.println( (i+1) + " asistencias " + unaAsistencia.getAsistencias() + " " +
                                unaAsistencia.getDiagramacion().getDisciplina() + " " +
                                unaAsistencia.getDiagramacion().getNombreNivel() + " " +
                                unaAsistencia.getDiagramacion().getProfesor());


        }

    }

    public int asistenciasPorProfesor (Profesor profesor) {

        int asistenciasTotales = 0;

        for (Asistencia asistencia: asistencias) {

            if (asistencia.getDiagramacion().getProfesor().equals(profesor)) {

                asistenciasTotales += asistencia.getAsistencias();

            }

        }

        return asistenciasTotales;
    }

    public int asistenciasPorDiagramacion (Diagramacion diagramacion) {

        int asistenciasTotales = 0;

        boolean hallado = false;

        int i = 0;

        while ((i < asistencias.size()) && (!hallado)) {

            if (asistencias.get(i+1).getDiagramacion().equals(diagramacion)) {

                asistenciasTotales = asistencias.get(i).getAsistencias();
                hallado = true;

            }

            i++;
        }

        return asistenciasTotales;
    }

    public boolean esAlumnoDe (Profesor profesor) {

        boolean resultado = false;

        int i = 0;

        while ((i < diagramaciones.size()) && (!resultado)) {

            if (diagramaciones.get(i+1).getProfesor().equals(profesor)) {

                resultado = true;

            }

            i++;
        }

        return resultado;

    }

    public String toString () {

        return (dni + " " + nombre + " " + apellido);
    }

}
