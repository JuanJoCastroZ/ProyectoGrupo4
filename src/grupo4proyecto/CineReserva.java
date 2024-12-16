/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo4proyecto;

import java.util.Scanner;

/**
 *
 * @author Juan Jose
 */
public class CineReserva {

    public CineReserva() {
        volverAlMenu();
    }

    private void volverAlMenu() {
        interfazCineReserva();
    }
    //asientos de la sala
    int filas = 6;
    int columnas = 5;
    int[][] asientos = new int[filas][columnas];

    Scanner scanner = new Scanner(System.in);
    boolean continuar = true;

    public void interfazCineReserva() {
        while (continuar) {
            mostrarAsientos(asientos);

            //seleccionar asiento
            System.out.println("\nIntroduzca el numero de fila (0-4):");
            int fila = scanner.nextInt();

            System.out.println("Introduzca el numero de columna (0-4):");
            int columna = scanner.nextInt();

            //verificar si el asiento está disponible
            if (asientos[fila][columna] == 0) {
                asientos[fila][columna] = 1;
                System.out.println("se reservó el asiento seleccionado");
            } else {
                System.out.println("el asiento ya se encuentra reservado, por favor seleccione otro.");

            }
            System.out.println("desea continuar? (s/n):");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("n")) {
                continuar = false;
                System.out.println("gracias por reservar");
            }
        }
    }

    //mostrar que asientos están disponibles
    public void mostrarAsientos(int[][] asientos) {
        System.out.println("\nEstado de disponibilidad de los asientos: ");
        System.out.println("    ");

        for (int i = 0; i < asientos[0].length; i++) {
            System.out.println(i + "    ");
        }
        System.out.println();

        for (int i = 0; i < asientos.length; i++) {
            System.out.println(i + "    ");

            for (int j = 0; j < asientos[i].length; j++) {
                System.out.print((asientos[i][j] == 0 ? "L" : "O") + "  ");

            }

        }
    }

}