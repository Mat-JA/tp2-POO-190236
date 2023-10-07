/* DEO GLORIA
 * 777
 * conatus me
 */

package tp2.punto2;

import java.util.ArrayList;
import java.util.Scanner;

//Clase añadida debido a que consigna dice: "El sistema debe permitir llevar un registro de..."
public class Sistema {

    private ArrayList<Cliente> clientes;
    private ArrayList<Destino> destinos;
    private ArrayList<Proveedor> mediosDeTransporte;
    private ArrayList<Proveedor> hospedajes;
    private ArrayList<Proveedor> excursiones;
    private ArrayList<PaqueteTurismo> paquetesTurismo;
    private ArrayList<Integer> ventasPorDestino;
    private ArrayList<Venta> ventas;

    private boolean destinoNuevo (Destino unDestino) {

        boolean destinoNoRegistrado = true;

        Destino destinoAux = null;

        int i = 0;

        while ((i < destinos.size()) && (destinoNoRegistrado)) {

            destinoAux = destinos.get(i);

            if (destinoAux.equals(unDestino)) {

                destinoNoRegistrado = false;

            }

            i++;
        }

        return destinoNoRegistrado;
    }

    private void aniadirDestino (Destino unDestino) {

        if (destinoNuevo(unDestino)) {

            destinos.add(unDestino);
            ventasPorDestino.add(0);

        }

    }

    private void mostrarProveedor (ArrayList<Proveedor> proveedores) {

        int posicion = 1;

        for (Proveedor proveedor: proveedores) {

            System.out.println(posicion + ". " + proveedor.getNombre());

        }

    }

    private int obtenerPosDestino (PaqueteTurismo paqTurismo) {

        int posicion = -1;

        int i = 0;

        boolean hallado = false;

        while ((i < destinos.size()) && !(hallado)) {

            if (destinos.get(i).getNombre().equals(paqTurismo.getLocalizacion())) {

                posicion = i;
                hallado = true;

            }

            i++;
        }

        return posicion;

    }

    private Destino obtenerDestino (PaqueteTurismo paqTurismo) {

        Destino localizacion = null;

        int i = 0;

        boolean hallado = false;

        while ((i < destinos.size()) && !(hallado)) {

            if (destinos.get(i).getNombre().equals(paqTurismo.getLocalizacion())) {

                localizacion = destinos.get(i);
                hallado = true;

            }

            i++;
        }

        return localizacion;

    }

    private int obtenerPosMayorVentas () {

        int posMayorVenta = -1;
        int mayorVenta = -1;

        for (int i = 0; i < ventasPorDestino.size(); i++) {

            if (ventasPorDestino.get(i) > mayorVenta) {

                posMayorVenta = i;
                mayorVenta = ventasPorDestino.get(i);

            }

        }

        return posMayorVenta;

    }

    public Sistema () {

        clientes = new ArrayList<Cliente>();
        destinos = new ArrayList<Destino>();
        mediosDeTransporte = new ArrayList<Proveedor>();
        hospedajes = new ArrayList<Proveedor>();
        excursiones = new ArrayList<Proveedor>();
        paquetesTurismo = new ArrayList<PaqueteTurismo>();

    }

    public void nuevoCliente (String nombre) {

        Cliente cliente = new Cliente(nombre);
        clientes.add(cliente);

    }

    public void nuevoDestino (String nombre) {

        Destino destino = new Destino(nombre);
        destinos.add(destino);
        ventasPorDestino.add(0);

    }

    public void nuevoMedioDeTransporte (String nombre, char tipo, Destino localizacion) {

        Proveedor medioDeTransporte = Proveedor.cargarProveedor(nombre, tipo, localizacion);

        if ((medioDeTransporte != null) && medioDeTransporte.esMedioDeTransporte()) {

            mediosDeTransporte.add(medioDeTransporte);
            aniadirDestino(localizacion);

        }

    }

    public void nuevoHospedaje (String nombre, char tipo, Destino localizacion) {

        Proveedor hospedaje = Proveedor.cargarProveedor(nombre, tipo, localizacion);

        if ((hospedaje != null) && (hospedaje.esHospedaje())) {

            hospedajes.add(hospedaje);
            aniadirDestino(localizacion);

        }

    }

    public void nuevaExcursion (String nombre, char tipo, Destino localizacion) {

        Proveedor excursion = Proveedor.cargarProveedor(nombre, tipo, localizacion);

        if ((excursion != null) && (excursion.esExcursion())) {

            excursiones.add(excursion);
            aniadirDestino(localizacion);

        }

    }

    public void mostrarDestinos () {

        int posicion = 1;

        for (Destino destino : destinos) {

            System.out.println(posicion + ". " + destino);

        }

    }

    public void mostrarMediosDeTransporte () {

        System.out.println("Medios de transporte registrados: ");

        mostrarProveedor(mediosDeTransporte);

    }

    public void mostrarHospedajes () {

        System.out.println("Hospedajes registrados: ");

        mostrarProveedor(hospedajes);

    }

    public void mostrarExcursiones () {

        System.out.println("Excursiones: ");

        mostrarProveedor(excursiones);

    }

    public void armarPaqueteTurismo () {

        PaqueteTurismo nuevoPaqTurismo;

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del paquete de turismo: ");
        String paqNombre = sc.next();

        mostrarDestinos();
        System.out.println("Ingrese el número de la localizacion del paquete de turismo.");

        int posDestino = sc.nextInt();

        mostrarMediosDeTransporte();
        System.out.println("Ingrese el número de medio de transporte: ");

        int posMedioDeTransporte = sc.nextInt();

        mostrarHospedajes();
        System.out.println("Ingrese el número de hospedaje: ");

        int posHospedaje = sc.nextInt();

        nuevoPaqTurismo = PaqueteTurismo.crearPaqueteTurismo(paqNombre, destinos.get(posDestino),
                                                              mediosDeTransporte.get(posMedioDeTransporte),
                                                              hospedajes.get(posHospedaje));

        if (nuevoPaqTurismo != null) {

            System.out.println("Ingrese cuantas excursiones incluirá el paquete de turismo: ");
            int cantExcursiones = sc.nextInt();

            int posExcursion = -1;

            for (int i = 0; i < cantExcursiones; i++) {

                mostrarExcursiones();
                System.out.println("Ingrese el número de excursión: ");

                posExcursion = sc.nextInt();

                nuevoPaqTurismo.aniadirExcursion(excursiones.get(posExcursion));

            }

            paquetesTurismo.add(nuevoPaqTurismo);

        } else {

            System.out.println("Fallo en la creación del paquete de turismo.");

        }

    }

    public void venderPaquete (int posCliente, int posPaqueteTurismo) {

        if ( ( (posCliente > 0) && (posCliente <= clientes.size()) ) &&
                ( (posPaqueteTurismo > 0) && (posPaqueteTurismo <= paquetesTurismo.size()) ) ) {

            clientes.get(posCliente).comprarPaquete(paquetesTurismo.get(posPaqueteTurismo));

            ventas.add(new Venta(clientes.get(posCliente), obtenerDestino(paquetesTurismo.get(posPaqueteTurismo)),
                    paquetesTurismo.get(posPaqueteTurismo)));

            int posDestino = obtenerPosDestino(paquetesTurismo.get(posPaqueteTurismo));
            Integer modVenta = ventasPorDestino.get(posDestino);
            modVenta += 1;

        } else {

            System.out.println("Cliente, o paquete, no válido");

        }

    }

    public void mostrarVentasPorDestino () {

        for (Destino destino: destinos) {

            for (Venta venta : ventas) {

                if (destino.equals(venta.getLugar())) {

                    System.out.println(venta);

                }

            }

        }

    }

    public void mostrarDestinoFavorito () {

        int posMayorVentas = obtenerPosMayorVentas();

        System.out.println("El destino favorito de los clientes es: " + destinos.get(posMayorVentas));

    }

}
