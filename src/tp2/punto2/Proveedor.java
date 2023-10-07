/* DEO GLORIA
 * conatus me
 */

package tp2.punto2;

//Esta clase debería dividirse mediante herencia, pero se hace en punto 14
//Excursion nop deberia ser, sino guia de turismo y este a suvez tener un array de excursiones
//rehacer luego de terminar el resto
public class Proveedor {

    private String nombre;
    private char tipo;
    private Destino localizacion; //En el caso de medio de transporte indica lugar de llegada

    //(M)edio de transporte, (H)ospedaje, (E)xcursion
    private static boolean verificarTipo (char tipo) {

        return ((tipo == 'M') | (tipo == 'E') | (tipo == 'H'));
    }

    private Proveedor (String nombre, char tipo, Destino localizacion) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.localizacion = localizacion;

    }

    public static Proveedor cargarProveedor (String nombre, char tipo, Destino localizacion) {

        Proveedor nuevoProveedor = null;

        if (verificarTipo(tipo)) {

            nuevoProveedor = new Proveedor (nombre, tipo, localizacion);

        } else {

            System.out.println("Tipo de proveedor no válido.");

        }

        return nuevoProveedor;
    }

    public void setNombre (String nombre) {

        this.nombre = nombre;
    }

    public void setTipo (char tipo) {

        if (verificarTipo(tipo)) {

            this.tipo = tipo;

        } else {

            System.out.println("Tipo no válido.");

        }

    }

    public void setLocalizacion (Destino localizacion) {

        this.localizacion = localizacion;
    }

    public String getNombre () {

        return nombre;
    }

    public char getTipo () {

        return tipo;
    }

    public Destino getLocalizacion () {

        return localizacion;
    }

    public boolean esMedioDeTransporte () {

        return (tipo == 'M');
    }

    public boolean esHospedaje () {

        return (tipo == 'H');
    }

    public boolean esExcursion () {

        return (tipo == 'E');
    }

    public String toString () {

        String p_cadena = "";

        p_cadena = p_cadena.concat(nombre);

        if (esExcursion()) {

            p_cadena = p_cadena.concat(" ofrece una excursion en: ");

        } else if (esHospedaje()) {

            p_cadena = p_cadena.concat(" es un hospedaje en: ");

        } else {

            p_cadena = p_cadena.concat(" es una empresa de transporte que lleva gente a: ");

        }

        p_cadena = p_cadena.concat(localizacion.toString());

        return p_cadena;
    }

}
