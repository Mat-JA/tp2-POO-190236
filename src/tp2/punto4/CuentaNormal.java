/* DEO GLORIA
 * conatus me
 */

package tp2.punto4;

import java.time.LocalDate;
import java.util.Scanner;

public class CuentaNormal {

    private double limiteGiroEnDescubierto;
    private double saldo;
    private Inversion inversion;

    private boolean consultarGastoSaldoNegativo () {

        String decision = " ";

        System.out.println("Saldo insuficiente, puede utilizar giro al descubierto.");
        System.out.println("¿Continuar con la operación?[s/n]: ");

        Scanner sc = new Scanner(System.in);
        decision = sc.next();

        return (decision.equals("s"));
    }

    public CuentaNormal (double limiteGiroEnDescubierto) {

        this.limiteGiroEnDescubierto = limiteGiroEnDescubierto;
        this.saldo = 0;
        inversion = null;

    }

    public double getLimiteGiroEnDescubierto () {

        return limiteGiroEnDescubierto;
    }

    public double consultarSaldo () {

        return saldo;
    }

    //Es válido porque inversion no tiene ningún set.
    public Inversion getInversion () {

        return inversion;
    }

    public void cargarMonto (double monto) {

        saldo += monto;
    }

    public boolean gastarMonto (double monto) {

        boolean exito = true;

        if (saldo > monto) {

            saldo -= monto;

        } else if (saldo + limiteGiroEnDescubierto > monto) {

            if (consultarGastoSaldoNegativo()) {

                saldo -= monto;
                System.out.println("Se ha girado en descubierto, saldo actual: " + saldo);

            } else {

                System.out.println("Operación cancelada.");
                exito = false;

            }

        } else {

            System.out.println("Operación rechazada. Falta de fondos.");
            exito = false;

        }

        return exito;
    }

    public double consultarMontoInvertido () {

        double invertido = 0;

        if (inversion != null) {

            inversion.getmontoInvertido();

        }

        return invertido;
    }

    public void Invertir (double monto, LocalDate fechaFinal) {

        if (inversion != null) {

            System.out.println("No se puede invertir, dado que ya se ha realizado una inversion");

        } else if (saldo < monto) {

            System.out.println("No hay fondos suficientes para realizar la inversión");

        } else if (fechaFinal.isBefore(LocalDate.now().plusDays(30))) {

            System.out.println("Fecha de término de inversión no válida\n" +
                               "Deben ser al menos 30 días después de la fecha de hoy.");

        } else {

            inversion = Inversion.crearInversion(monto, LocalDate.now(), fechaFinal);

        }

    }

    public void cobrarInversion () {

        if (inversion.getFechaFinal().isBefore(LocalDate.now())) {

            System.out.println("La inversión todavía no llegó a término.");

        } else {

            saldo += inversion.getMontoAPagar();
            inversion = null;

        }

    }

}
