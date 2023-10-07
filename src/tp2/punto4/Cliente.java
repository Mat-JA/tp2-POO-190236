/* DEO GLORIA
 * conatus me
 */

package tp2.punto4;

public class Cliente {

    private int ID;
    private String nombre;
    private String apellido;
    private long telefono;
    private String email;
    private CuentaNormal cuentaNormal;
    private CuentaCredito cuentaCredito;

    public Cliente (int ID, String nombre, String apellido, long telefono, String email,
                    int limiteGiroDescubierto) {

        this.ID = ID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        cuentaNormal = new CuentaNormal(limiteGiroDescubierto);
        cuentaCredito = null;

    }

    public boolean abrirCuentaCredito (double limiteGasto) {

        if ((cuentaCredito == null) & (limiteGasto > 0)) {

            cuentaCredito = CuentaCredito.crearCuentaCredito(limiteGasto);

        }

        return (cuentaCredito != null);
    }

    public double getSaldo () {

        return cuentaNormal.consultarSaldo();
    }

    public double getLimiteGiroDescubierto () {

        return cuentaNormal.getLimiteGiroEnDescubierto();
    }

    public double getMontoInvertido () {

        return cuentaNormal.consultarMontoInvertido();
    }

    public double saldoCredito () {

        double credito = 0;

        if (cuentaCredito != null) {

            credito = cuentaCredito.getLimiteGasto();

        }

        return credito;
    }

    public double getDeuda () {

        double totalDeuda = 0;

        if (cuentaNormal.consultarSaldo() < 0) {

            totalDeuda -= cuentaNormal.consultarSaldo(); //como saldo < 0, -saldo > 0

        }

        if (cuentaCredito != null) {

            totalDeuda += cuentaCredito.getTotalDeuda();

        }

        return totalDeuda;
    }

    public int getID () {

        return ID;
    }

    public String getNombre () {

        return nombre;
    }

    public String getApellido () {

        return apellido;
    }

    public long getTelefono () {

        return telefono;
    }

    public String getEmail () {

        return email;
    }

    public void cargarSaldo (double monto) {

        cuentaNormal.cargarMonto(monto);

    }

    public boolean comprarConDebito (double monto) {

        boolean exito = false;

        exito = cuentaNormal.gastarMonto(monto);

        return exito;
    }

    public boolean comprarConCredito (double monto) {

        boolean exito = false;

        if (cuentaCredito != null) {

            exito = cuentaCredito.gastar(monto);

        }

        return exito;
    }

    public void pagarCredito (double monto) {

        if (cuentaCredito != null) {

            cuentaCredito.pagar(0, monto);

        }

    }

}
