/* DEO GLORIA
 * conatus me
 */

package tp2.punto3;

import java.time.chrono.JapaneseEra;

public class Profesor {

    private String nombre;
    private String apellido;
    private int ID;
    private static int cantProfesores = 0;

    public Profesor(String nombre, String apellido) {

        this.nombre = nombre;
        this.apellido = apellido;
        cantProfesores++;
        ID = cantProfesores;

    }

    public void setNombre (String nombre) {

        this.nombre = nombre;

    }

    public void setApellido (String apellido) {

        this.apellido = apellido;

    }

    public String getNombre () {

        return nombre;
    }

    public String getApellido () {

        return apellido;
    }

    public int getID () {

        return ID;
    }

    public int getCantidadProfesores () {

        return cantProfesores;
    }

    public String toString () {

        return (ID + " : " + nombre + " " + apellido);
    }

    public boolean equals (Profesor otroProfesor) {

        return (ID == otroProfesor.getID());
    }

}
