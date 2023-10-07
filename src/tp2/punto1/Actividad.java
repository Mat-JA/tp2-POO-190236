/* DEO GLORIA
 * conatus me
 */

package tp2.punto1;

public class Actividad {

    private String nombre;
    private String descripcion;
    private char nivel;

    private boolean verificarNivel (char nivel) {

        return ((nivel == 'B') | (nivel == 'I') | (nivel == 'D'));
    }

    private Actividad (String nombre, String descripcion, char nivel) {

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;

    }

    public Actividad generarActividad (String nombre, String descripcion, char nivel) {

        Actividad nuevaActividad = null;

        if (verificarNivel(nivel)) {

            nuevaActividad = new Actividad(nombre, descripcion, nivel);

        } else {

            System.out.println("Nivel de actividad no válido.");

        }

        return nuevaActividad;

    }

    public void setNombre (String nombre) {

        this.nombre = nombre;
    }

    public void setDescripcion (String descripcion) {

        this.descripcion = descripcion;
    }

    public void setNivel (char nivel) {

        if (verificarNivel(nivel)) {

            this.nivel = nivel;

        } else {

            System.out.println("Tipo indicado no válido.");

        }

    }

    public String getNombre () {

        return nombre;
    }

    public String getDescripcion () {

        return descripcion;
    }

    public char getNivel () {

        return nivel;
    }

}
