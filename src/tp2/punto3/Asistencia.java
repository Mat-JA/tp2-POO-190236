/* DEO GLORIA
 * conatus me
 */

package tp2.punto3;

import java.util.ArrayList;

public class Asistencia {

    private int asistencias;
    private Diagramacion diagramacion;

    public Asistencia(Diagramacion diagramacion) {

        asistencias = 0;
        this.diagramacion = diagramacion;

    }

    public void marcarAsistencia () {

        asistencias += 1;
    }

    public void resetearAsistencias () {

        asistencias = 0;
    }

    public void setDiagramacion (Diagramacion diagramacion) {

        this.diagramacion = diagramacion;

    }

    public int getAsistencias () {

        return asistencias;
    }

    public Diagramacion getDiagramacion () {

        return diagramacion;
    }

}
