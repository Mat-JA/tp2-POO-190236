/* DEO GLORIA
 * conatus me
 */

package tp2;

import java.util.Scanner;

public class Inicio {
    public static void main (String[] args) {

        int opcion = 0;

        do {
            mostrarMenu();
            opcion = recibirOpcion();

            if (opcion != 0) {

                procesarOpcion(opcion);

            }

        } while (opcion != 0);

        System.out.println("\n\nEl programa ha terminado.\nTenga un buen día.");
    }

    private static void mostrarMenu () {

        System.out.println("\n          GLORIA UT DEUS" +
                "\n           conatus me");
        System.out.println("\n+++++++++  MENU TP1  +++++++++");
        System.out.println("1.ej_1   6.ej_6   11.ej_11");
        System.out.println("2.ej_2   7.ej_7   12.ej_12");
        System.out.println("3.ej_3   8.ej_8   13.ej_13");
        System.out.println("4.ej_4   9.ej_9   14.ej_14");
        System.out.println("5.ej_5   10.ej_10");
        System.out.println("0.EXIT");

    }

    private static int recibirOpcion () {

        int opcion = -1;

        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("\nIngrese la opcion: ");
            opcion = sc.nextInt();

        } while( (opcion < 0) | (opcion > 14) );

        return opcion;
    }

    private static void procesarOpcion (int opcion) {

        switch (opcion) {

            case 1:
                punto1();
                break;
            case 2:
                punto2();
                break;
            case 3:
                punto3();
                break;
            case 4:
                punto4();
                break;
            case 5:
                punto5();
                break;
            case 6:
                punto6();
                break;
            case 7:
                punto7();
                break;
            case 8:
                punto8();
                break;
            case 9:
                punto9();
                break;
            case 10:
                punto10();
                break;
            case 11:
                punto11();
                break;
            case 12:
                punto12();
                break;
            case 13:
                punto13();
                break;
            case 14:
                punto14();
                break;
            default:
                System.out.println("No deberías poder acceder aquí por el menú.");

        }

    }

    private static void punto1 () {

    }

    private static void punto2 () {

    }

    private static void punto3 () {

    }

    private static void punto4 () {

    }

    private static void punto5 () {

    }

    private static void punto6 () {

    }

    private static void punto7 () {

    }

    private static void punto8 () {

    }

    private static void punto9 () {

    }

    private static void punto10 () {


    }

    private static void punto11 () {

    }

    private static void punto12 () {

    }

    private static void punto13 () {

    }

    private static void punto14 () {

    }

}

