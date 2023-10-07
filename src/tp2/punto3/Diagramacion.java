/* DEO GLORIA
 * ALABADO SEA DIOS PADRE
 * ALABADO SEA DIOS HIJO
 * ALABADO SEA DIOS ESPIRITU SANTO
 * QUI UT DEUS
 */

package tp2.punto3;

import java.util.ArrayList;

public class Diagramacion {

    private ArrayList<DiaClase> diasClase;
    private int nivel; //1 - inicial, 2 - intermedio, 3 - avanzado
    private String disciplina;
    private Profesor profesor;

    private static boolean nivelValido (int nivel) {

        return ((nivel > 0) && (nivel < 4));
    }

    private boolean diaClaseValido (int i) {

        return ((i > 0) && (i <= diasClase.size()));
    }

    private Diagramacion(int nivel, String disciplina, Profesor profesor) {

        diasClase = new ArrayList<DiaClase>();
        this.nivel = nivel;
        this.disciplina = disciplina;
        this.profesor = profesor;

    }

    public static Diagramacion crearDiagramacion (int nivel, String disciplina, Profesor profesor) {

        Diagramacion nuevaDigramacion = null;

        if (!nivelValido(nivel)) {

            System.out.println();

        } else {

            nuevaDigramacion = new Diagramacion(nivel, disciplina, profesor);

        }

        return nuevaDigramacion;
    }

    public void agragarDiaClase (DiaClase nuevoDia) {

        diasClase.add(nuevoDia);

    }

    public void modificarDiaClase (int i, DiaClase diaModificado) {

        if (!diaClaseValido(i-1)) {

            System.out.println("Día seleccionado no válido.");

        } else {

            diasClase.remove(i-1);
            diasClase.add(i-1, diaModificado);

        }

    }

    public void setNivel (int nivel) {

        if (!nivelValido(nivel)) {

            System.out.println("Nivel no válido.");

        } else {

            this.nivel = nivel;

        }

    }

    public void setDisciplina (String disciplina) {

        this.disciplina = disciplina;

    }

    public void setProfesor (Profesor profesor) {

        this.profesor = profesor;

    }

    public void mostrarDiaClase (int i) {

        if (!diaClaseValido(i-1)) {

            System.out.println("Día seleccionado no válido.");

        } else {

            System.out.println(diasClase.get(i-1));

        }

    }

    public DiaClase getDiaClase (int i) {

        DiaClase diaBuscado = null;

        if ((i < 0) || (i > diasClase.size())) {

            System.out.println("Número de día no válido.");

        } else {

            diaBuscado = diasClase.get(i-1);

        }

        return diaBuscado;
    }

    public int getCantDiasClase () {

        return diasClase.size();
    }

    public int getNivel () {

        return nivel;
    }

    public String getNombreNivel () {

        String nombreNivel = "Ahora si existe el nivel 0.";

        switch(nivel) {

            case 1:
                nombreNivel = "INICIAL";
                break;
            case 2:
                nombreNivel = "INTERMEDIO";
                break;
            case 3:
                nombreNivel = "AVANZADO";
                break;
            default:
                nombreNivel = "No deberías acceder aquí";

        }

        return nombreNivel;
    }

    public String getDisciplina () {

        return disciplina;
    }

    public Profesor getProfesor () {

        return profesor;
    }

    public String toString () {

        String muestra = "Los días: \n";

        DiaClase unDia = null;

        for (int i = 0; i < diasClase.size(); i++) {

            unDia = diasClase.get(i);

            muestra = muestra.concat(unDia.getNombreDia() + " de " + unDia.getHoraInicio().getHour()
                    + ":" + unDia.getHoraInicio().getMinute() + " a " + unDia.getHoraFin().getHour() +
                    ":" + unDia.getHoraFin().getMinute());

            muestra = muestra.concat("\n");

        }

        muestra = muestra.concat("El profesor " + profesor + " da la clase de " + disciplina + "\n");
        muestra = muestra.concat("La clase es de nivel " + getNombreNivel());

        return muestra;
    }

    public boolean equals (Diagramacion otraDiagramacion) {

        boolean esIgual = true;

        if (diasClase.size() != otraDiagramacion.getCantDiasClase()) {

            esIgual = false;

        } else {

            int i = 0;

            while ((i < diasClase.size()) && esIgual) {

                if (!diasClase.get(i).equals(otraDiagramacion.getDiaClase(i+1))) {

                    esIgual = false;

                }

                i++;

            }

        }

        if (esIgual) {

            if (nivel != otraDiagramacion.getNivel()) {

                esIgual = false;

            } else if (!disciplina.contentEquals(otraDiagramacion.getDisciplina())) {

                esIgual = false;

            } else if (!profesor.equals(otraDiagramacion.getProfesor())) {

                esIgual = false;

            }

        }

        return esIgual;
    }

}
