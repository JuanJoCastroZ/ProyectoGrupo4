/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo4proyecto;

import javax.swing.*;
import java.time.LocalTime;
import java.util.Calendar;

/**
 *
 * @author Juan Jose
 */
public class CineReserva extends JPanel {
    // Atributos de la reserva
    private int salaCine;
    private String asiento;
    private String pelicula;
    private Calendar calendarCine;

    // Configuración de salas y atributos estáticos
    private static final int capacidadSala = 30;
    private static final int numSalas = 3;
    private static int[][][] reservas = new int[numSalas][capacidadSala][2];
    private static String[][] peliculas = new String[numSalas][3];
    private static LocalTime[][] horarios = new LocalTime[numSalas][3];
    private static String[][] idiomas = new String[numSalas][3];

    // Constructor con JFrame
    public CineReserva(JFrame framePrograma) {
        inicializarSistema();  // Inicializa configuración de la sala
        volverAlMenu(framePrograma);  // Inicia el menú interactivo
    }

    // Inicializa el sistema de cine
    private static void inicializarSistema() {
        peliculas[0][0] = "Wicked"; peliculas[0][1] = "Moana"; peliculas[0][2] = "Star Wars";
        peliculas[1][0] = "It"; peliculas[1][1] = "Los fantasmas de Scrooge"; peliculas[1][2] = "La La Land";
        peliculas[2][0] = "El Rey León"; peliculas[2][1] = "Rapunzel"; peliculas[2][2] = "Joker";

        horarios[0][0] = LocalTime.of(14, 0); horarios[0][1] = LocalTime.of(16, 30); horarios[0][2] = LocalTime.of(19, 0);
        horarios[1][0] = LocalTime.of(15, 0); horarios[1][1] = LocalTime.of(17, 30); horarios[1][2] = LocalTime.of(20, 0);
        horarios[2][0] = LocalTime.of(16, 0); horarios[2][1] = LocalTime.of(18, 30); horarios[2][2] = LocalTime.of(21, 0);

        idiomas[0][0] = "Español"; idiomas[0][1] = "Inglés"; idiomas[0][2] = "Subtitulado";
        idiomas[1][0] = "Español"; idiomas[1][1] = "Inglés"; idiomas[1][2] = "Original";
        idiomas[2][0] = "Español"; idiomas[2][1] = "Doblado"; idiomas[2][2] = "Subtitulado";
    }

    // Menú principal de la interfaz visual
    private void volverAlMenu(JFrame framePrograma) {
        String[] opciones = {"Mostrar Películas", "Realizar Reserva", "Salir"};
        while (true) {
            int opcion = JOptionPane.showOptionDialog(
                    framePrograma, 
                    "Seleccione una opción:", 
                    "Cine Reserva", 
                    JOptionPane.DEFAULT_OPTION, 
                    JOptionPane.PLAIN_MESSAGE, 
                    null, opciones, opciones[0]);

            switch (opcion) {
                case 0 -> mostrarPeliculas(framePrograma);
                case 1 -> realizarReserva(framePrograma);
                case 2 -> {
                    JOptionPane.showMessageDialog(framePrograma, "Saliendo del sistema");
                    return;
                }
                default -> JOptionPane.showMessageDialog(framePrograma, "Opción no válida, intente nuevamente.");
            }
        }
    }

    // Métodos de interacción
    private void mostrarPeliculas(JFrame framePrograma) {
        StringBuilder message = new StringBuilder("--- Películas Disponibles ---\n");
        for (int sala = 0; sala < numSalas; sala++) {
            message.append("Sala ").append(sala + 1).append(":\n");
            for (int i = 0; i < 3; i++) {
                message.append("  - ").append(peliculas[sala][i]).append(" - ").append(horarios[sala][i]).append(" - ").append(idiomas[sala][i]).append("\n");
            }
        }
        JOptionPane.showMessageDialog(framePrograma, message.toString());
    }

    private void realizarReserva(JFrame framePrograma) {
        try {
            salaCine = Integer.parseInt(JOptionPane.showInputDialog(framePrograma, "Elija la sala que desea (1-" + numSalas + "):")) - 1;
            if (salaCine < 0 || salaCine >= numSalas) throw new Exception("Sala no disponible");

            StringBuilder peliculasLista = new StringBuilder("Películas disponibles:\n");
            for (int i = 0; i < 3; i++) {
                peliculasLista.append(i + 1).append(". ").append(peliculas[salaCine][i]).append(" - ").append(horarios[salaCine][i]).append(" - ").append(idiomas[salaCine][i]).append("\n");
            }
            int peliculaIndex = Integer.parseInt(JOptionPane.showInputDialog(framePrograma, peliculasLista + "\nElija la película (1-3):")) - 1;
            if (peliculaIndex < 0 || peliculaIndex >= 3) throw new Exception("Película no disponible");

            int asientoSeleccionado = Integer.parseInt(JOptionPane.showInputDialog(framePrograma, "Elija el asiento (1-30):")) - 1;
            if (asientoSeleccionado < 0 || asientoSeleccionado >= capacidadSala || reservas[salaCine][asientoSeleccionado][0] == 1) {
                throw new Exception("Asiento no disponible");
            }

            reservas[salaCine][asientoSeleccionado][0] = 1;
            reservas[salaCine][asientoSeleccionado][1] = peliculaIndex;

            // Asignación de atributos
            asiento = String.valueOf(asientoSeleccionado + 1);
            pelicula = peliculas[salaCine][peliculaIndex];
            calendarCine = Calendar.getInstance();

            JOptionPane.showMessageDialog(framePrograma, "Reserva realizada con éxito:\n" +
                    "Sala: " + (salaCine + 1) + "\n" +
                    "Película: " + pelicula + "\n" +
                    "Asiento: " + asiento);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(framePrograma, "Error: " + e.getMessage());
        }
    }

    // Getters agregados para interacción con Interfaz.java
    public int getSalaCine() {
        return salaCine + 1;
    }

    public String getAsiento() {
        return asiento;
    }

    public String getPelicula() {
        return pelicula;
    }

    public Calendar getCalendarCine() {
        return calendarCine;
    }
}
