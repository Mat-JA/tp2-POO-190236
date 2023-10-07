/* DEO GLORIA
 * conatus me
 */

package tp2.punto4;

public class GastoCredito {

    private double costo;
    private double totalPagado;

    public GastoCredito(double costo) {

        this.costo = costo;
        totalPagado = 0;

    }

    public double getCosto () {

        return costo;
    }

    public double getPagado () {

        return totalPagado;
    }

    public double getTotalRestante () {

        return (costo - totalPagado);
    }

    public double pagar (double monto) {

        double devolucion = 0; //Si sobra, devuelve el pago

        if (monto > (costo - totalPagado)) {

            devolucion = monto - (costo - totalPagado);
            totalPagado = costo;

        } else if (monto < (costo - totalPagado)) {

            totalPagado += monto;

        } else {

            totalPagado = costo;

        }

        return devolucion;
    }

    public double getPorcentajeTotalRestante () {

        return ((totalPagado*100)/costo);
    }

    public boolean pago () {

        return (costo == totalPagado);
    }

}
