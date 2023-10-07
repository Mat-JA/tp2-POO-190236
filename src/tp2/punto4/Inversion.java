/* DEO GLORIA
 * conatus me
 */

package tp2.punto4;

import java.time.LocalDate;

public class Inversion {

    private double monto;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;

    private Inversion (double montoInversion, LocalDate fechaInicio, LocalDate fechaFinal) {

        this.monto = montoInversion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;

    }

    public static Inversion crearInversion (double montoInversion, LocalDate fechaInicio, LocalDate fechaFinal) {

        Inversion nuevaInversion = null;

        if (fechaFinal.isBefore(fechaInicio) || fechaFinal.isEqual(fechaInicio)) {

            System.out.println("Fechas no válidas.");

        } else {

            nuevaInversion = new Inversion(montoInversion, fechaInicio, fechaFinal);

        }

        return nuevaInversion;

    }

    public double getmontoInvertido () {

        return monto;
    }

    public double getMontoAPagar () {

        return (monto*(1.4));
    }

    public LocalDate getFechaInicio () {

        return fechaInicio;
    }

    public LocalDate getFechaFinal () {

        return fechaFinal;
    }

    public int getDiasTotales () {

        return (fechaFinal.compareTo(fechaInicio));
    }

    public int getDiasRestantes () {

        return (fechaFinal.compareTo(LocalDate.now()));
    }

}
