/* DEO GLORIA
 * conatus me
 */

package tp2.punto1;

import java.time.LocalDate;

public class Socio {

    private static int cantSocios = 0; //Se utiliza para generar nroSocio únicos.
    private int nroSocio;
    private char tipoSuscripcion;
    private LocalDate fechaInscripcion;
    private LocalDate fechaPagoHasta;
    private String nombre;
    private String apellido;
    private int dni;
    private long telefono;
    private String direccion;
    private String email;

    //(B)ásica, (I)ntermedia, (D)estacada (BID).
    private boolean verificarTipoSuscripcion (char tipoSuscripcion) {

        return ((tipoSuscripcion == 'B') | (tipoSuscripcion == 'I') | (tipoSuscripcion == 'D'));
    }

    //Las verificaciones se hacen previo a llamar al constructor.
    private Socio (String nombre, String apellido, int dni, long telefono,
                  String direccion, String email, LocalDate pagaHasta,
                  char tipoSuscripcion) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;

        fechaInscripcion = LocalDate.now();
        fechaPagoHasta = pagaHasta;
        this.tipoSuscripcion = tipoSuscripcion;

        cantSocios++;
        nroSocio = cantSocios;

    }

    //Devuelve nulo si tiposuscripcion no válido, puede extenderse a otros campos
    //de ser necesario
    public Socio armarSocio (String nombre, String apellido, int dni, long telefono,
                             String direccion, String email, LocalDate pagaHasta,
                             char tipoSuscripcion) {

        Socio nuevoSocio = null;

        if (verificarTipoSuscripcion(tipoSuscripcion)) {

            nuevoSocio = new Socio(nombre, apellido, dni, telefono,
                                   direccion, email, pagaHasta, tipoSuscripcion);

        } else {

            System.out.println("Suscripción cargada no válida.");

        }

        return nuevoSocio;
    }

    //No me parece la mejor idea poder hacer set sobre los datos del socio
    //Pero por experiencia laboral se que es necesario en caso de errores de carga
    //En un esquema más desarrollado, habilitaría el uso de estos métodos sólo
    //a petición de un socio.
    public void setNombre (String nombre) {

        this.nombre = nombre;
    }

    public void setApellido (String apellido) {

        this.apellido = apellido;
    }

    public void setDni (int dni) {

        this.dni = dni;
    }

    public void setTelefono (long telefono) {

        this.telefono = telefono;
    }

    public void setDireccion (String direccion) {

        this.direccion = direccion;
    }

    public void setEmail (String email) {

        this.email = email;
    }

    public int getCantSocios () {

        return cantSocios;
    }

    public int getNroSocio () {

        return nroSocio;
    }

    public char getTipoSuscripcion () {

        return tipoSuscripcion;
    }

    public LocalDate getfechaInscripcion () {

        return fechaInscripcion;
    }

    public LocalDate getFechaPagoHasta () {

        return fechaPagoHasta;
    }

    public String getNombre () {

        return nombre;
    }

    public String getApellido () {

        return apellido;
    }

    public int getDni () {

        return dni;
    }

    public long getTelefono () {

        return telefono;
    }

    public String getDireccion () {

        return direccion;
    }

    public String getEmail () {

        return email;
    }

    //Si llego, validar tipoSuscripcion
    public void pagarCuota (LocalDate nuevaFechaHasta, char tipoSuscripcion) {

        if (nuevaFechaHasta.isAfter(fechaPagoHasta)) {

            fechaPagoHasta = nuevaFechaHasta;
            this.tipoSuscripcion = tipoSuscripcion;

        } else {

            System.out.println("Nueva fecha de pago inválida.");

        }

    }

}
