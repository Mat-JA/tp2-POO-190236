/* DEO GLORIA
 * conatus me
 */

package tp2.punto3;

import java.time.LocalTime;

public class DiaClase {

    private int dia;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    private static boolean diaValido (int dia) {

        return ((dia > 0) && (dia < 8));
    }

    private DiaClase(int dia, LocalTime horaInicio, LocalTime horaFin) {

        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;

    }

    public static DiaClase crearDiaClase (int dia, LocalTime horaInicio, LocalTime horaFin) {

        DiaClase nuevoDiaClase = null;

        if (!diaValido(dia)) {

            //No válido por día
            System.out.println("Día no válido.");

        } else if (horaFin.isBefore(horaInicio)) {

            //No válido por horario
            System.out.println("Horario fin mayor a horario inicial");

        } else {

            nuevoDiaClase = new DiaClase(dia, horaInicio, horaFin);

        }

        return nuevoDiaClase;

    }

    public void set (int dia) {

        if (!diaValido(dia)) {

            System.out.println("Día no válido.");

        } else {

            this.dia = dia;

        }

    }

    public void setHoraInicio (LocalTime horaInicio) {

        if (horaFin.isBefore(horaInicio)) {

            System.out.println("hora ingresada no válida (menor a hora final)");

        } else {

            this.horaInicio = horaInicio;

        }

    }

    public void setHoraFinal (LocalTime horaFin) {

        if (horaFin.isBefore(horaInicio)) {

            System.out.println("hora ingresada no válida (hora final menor a hora inicial)");

        } else {

            this.horaFin = horaFin;

        }

    }

    public String getNombreDia () {

        String nombreDia = "nil";

        switch (dia) {

            case 1:
                nombreDia = "LUNES";
                break;
            case 2:
                nombreDia = "MARTES";
                break;
            case 3:
                nombreDia = "MIERCOLES";
                break;
            case 4:
                nombreDia = "JUEVES";
                break;
            case 5:
                nombreDia = "VIERNES";
                break;
            case 6:
                nombreDia = "SABADO";
                break;
            case 7:
                nombreDia = "DOMINGO";
                break;
            default:
                nombreDia = "Buen día, aquí no se entra.";

        }

        return nombreDia;
    }

    public int getDia () {

        return dia;
    }

    public LocalTime getHoraInicio () {

        return horaInicio;
    }

    public LocalTime getHoraFin () {

        return horaFin;
    }

    public String toString () {

        return (getNombreDia() + " de " + horaInicio.getHour() + ":" + horaInicio.getMinute() +
                " " + horaFin.getHour() + ":" + horaFin.getMinute());
    }

    public boolean equals (DiaClase otroDia) {

        return ((dia == otroDia.dia) && (horaInicio.equals(otroDia.horaInicio))
                 && (horaFin.equals(otroDia.horaFin)));
    }

}
