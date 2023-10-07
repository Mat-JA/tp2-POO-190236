/* DEO GLORIA
 * conatus me
 */

package tp2.punto4;

import tp2.punto12.Cuenta;

import java.util.ArrayList;

public class CuentaCredito {

    private double limiteGasto;
    private double deudaInteres; //Definido dado que limiteGasto no debe registrar interes.
                                 //Considero interes a el %5 de recargo en los gastos por crédito.
                                 //El gasto completo está vislumbrado en gastos.
    private ArrayList<GastoCredito> gastos;

    private boolean gastoCreditoValido (int i) {

        return ((i > -1) && (i < gastos.size()));
    }

    private CuentaCredito (double limiteGasto) {

        this.limiteGasto = limiteGasto;
        deudaInteres = 0;
        gastos = new ArrayList<GastoCredito>();

    }

    public static CuentaCredito crearCuentaCredito (double limiteGasto) {

        CuentaCredito nuevaCuenta = null;

        if (limiteGasto < 1) {

            System.out.println("Limite de gastos no válido");

        } else {

            nuevaCuenta = new CuentaCredito(limiteGasto);

        }

        return nuevaCuenta;

    }

    public double getLimiteGasto () {

        return limiteGasto;
    }

    public double getDeudaInteres() {

        return deudaInteres;
    }

    public GastoCredito getGastoI (int i) {

        GastoCredito gastoCredito = null;

        if (!gastoCreditoValido(i)) {

            System.out.println("Gasto pedido no válido.");

        } else {

            gastoCredito = gastos.get(i);

        }

        return gastoCredito;

    }

    public boolean gastar (double monto) {

        boolean exito = true;

        if (monto > limiteGasto) {

            System.out.println("Rechazada. El monto excede límite de gasto de la tarjeta.");
            exito = false;

        } else {

            limiteGasto -= monto;
            deudaInteres += monto*(0.05);

            gastos.add(new GastoCredito(monto + monto*(0.05)));

        }

        return exito;
    }

    public double pagar (int i, double monto) {

        double resto = 0;

        if (!gastoCreditoValido(i)) {

            System.out.println("Gasto seleccionado no válido.");

        } else {

            GastoCredito gasto = gastos.get(i);

            if (monto >= gasto.getCosto() - gasto.getPagado()) {

                resto = monto - (gasto.getCosto() - gasto.getPagado());
                monto = (gasto.getCosto() - gasto.getPagado());

            }

            double porcentajePrevio = gasto.getPorcentajeTotalRestante();

            gasto.pagar(monto); //Sí, básicamente la devolución no importa en este esquema
                                        //Es una consideración para posibles implementaciones futuras

            if (gasto.getPorcentajeTotalRestante() >= 0.05) {

                limiteGasto += monto;

            } else if (!gasto.pago()) { //Se paga por arriba del %95 pero menos del %100
                                        //Una parte afecta a limiteGasto otra parte a deuda

                double porcentajePagoActual = 1.0 - gasto.getPorcentajeTotalRestante();

                double porcentajePagadoPorMonto = porcentajePagoActual - (1.0 - porcentajePrevio);

                double porcentajeAPagoDeuda = porcentajePagoActual - 0.95;

                double porcentajeALlenarLimiteGasto = porcentajePagadoPorMonto - porcentajeAPagoDeuda;

                limiteGasto += (gasto.getCosto()*porcentajeALlenarLimiteGasto);
                deudaInteres -= (gasto.getCosto()*porcentajeAPagoDeuda);


            } else { //Se paga la parte que faltaba de la deuda

                deudaInteres -= monto;

            }

        }

        return resto;

    }

    public double getTotalDeuda () {

        double totalDeuda = 0;

        for (GastoCredito gasto : gastos) {

            totalDeuda += gasto.getTotalRestante();

        }

        return totalDeuda;
    }

}
