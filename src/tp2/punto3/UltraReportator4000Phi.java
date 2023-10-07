/* DEO GLORIA
 * conatus me
 */

package tp2.punto3;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UltraReportator4000Phi {

    private ArrayList<Alumno> alumnos;
    private ArrayList<Diagramacion> diagramaciones;
    private ArrayList<Profesor> profesores;

    private boolean profesorValido (int i) {

        return ((i > 0) && (i <= profesores.size()));
    }

    public UltraReportator4000Phi() {

        alumnos = new ArrayList<Alumno>();
        diagramaciones = new ArrayList<Diagramacion>();
        profesores = new ArrayList<Profesor>();

    }

    public void agregarAlumno (Alumno alumno) {

        alumnos.add(alumno);

    }

    public void agregarDiagramacion (Diagramacion diagramacion) {

        diagramaciones.add(diagramacion);

    }

    public void agregarProfesor (Profesor profesor) {

        profesores.add(profesor);

    }

    public void mostrarAlumnos () {

        System.out.println("--------LISTA ALUMNOS--------");

        for (Alumno alumno: alumnos) {

            System.out.println(alumno);

        }

    }

    public void mostrarDiagramaciones () {

        System.out.println("--------LISTA DIAGRAMACIONES--------");

        for (Diagramacion diagramacion: diagramaciones) {

            System.out.println(diagramacion);

        }

    }

    public void mostrarProfesores () {

        System.out.println("--------LISTA PROFESORES--------");

        for (Profesor profesor: profesores) {

            System.out.println(profesor);

        }

    }

    //Generar listado de alumno por profesor específico (según su posición en profesores)
    public ArrayList<String> reporteAlumnosPorProfesor (int i) {

        ArrayList<String> alumnosDeProfesor = new ArrayList<String>();

        if (!profesorValido(i)) {

            System.out.println("Número profesor no válido");

        } else {

            Profesor profesor = profesores.get(i-1);

            for (Alumno alumno : alumnos ) {

                if (alumno.esAlumnoDe(profesor)) {

                    alumnosDeProfesor.add(alumno.toString());

                }

            }

        }

        return alumnosDeProfesor;
    }

    public void mostrarCobroProfesor (int i) {

        Profesor profesor = profesores.get(i-1);

        int asistenciasProfesor = 0;

        for (Alumno alumno : alumnos ) {

            if (alumno.esAlumnoDe(profesor)) {

                asistenciasProfesor += alumno.asistenciasPorProfesor(profesor);

            }

        }

        System.out.println("El profesor " + profesor + " tiene " + asistenciasProfesor +
                           " asistencias, por lo que debe cobrar $" + (asistenciasProfesor*10));

    }

    public String disciplinaDeMayorRedituabilidad () {

        String mayorDisciplina = " ";

        int mayorAsistencia = 0;
        int asistActual = 0;

        for (Diagramacion diagramacion : diagramaciones) {

            asistActual = 0;

            for (Alumno alumno : alumnos) {

                asistActual += alumno.asistenciasPorDiagramacion(diagramacion);

            }

            if (asistActual > mayorAsistencia) {

                mayorAsistencia = asistActual;
                mayorDisciplina = diagramacion.getDisciplina();

            }

        }

        return mayorDisciplina;

    }



}
