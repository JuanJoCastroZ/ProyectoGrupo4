/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo4proyecto;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

/**
 *
 * @author Juan Jose
 */
public class GimnasioReserva extends JPanel {
    // Atributo de reserva
    private Calendar fechaHoraReserva;

    // Constructor adaptado
    public GimnasioReserva(JFrame framePrograma) {
        mostrarMenu(framePrograma);  // Integración de Frame
    }

    // Métodos
    private void mostrarMenu(JFrame framePrograma) {
        // Opciones del menú principal
        Object[] opciones = {"Reservar clase", "Cancelar"};
        int seleccion = JOptionPane.showOptionDialog(
            framePrograma, 
            "Bienvenido al sistema de reservas del gimnasio. ¿Qué desea hacer?", 
            "Menú de Reservas", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.INFORMATION_MESSAGE, 
            null, 
            opciones, 
            opciones[0]
        );

        if (seleccion == 0) {
            reservarClase(framePrograma);  // Llamada al método de reserva
        } else {
            JOptionPane.showMessageDialog(framePrograma, "Reserva cancelada.");
        }
    }

    private void reservarClase(JFrame framePrograma) {
        // Solicitar detalles de la reserva con ventanas emergentes
        String fechaInput = JOptionPane.showInputDialog(framePrograma, "Ingrese la fecha deseada en el formato DD/MM/AAAA:");
        String horaInput = JOptionPane.showInputDialog(framePrograma, "Ingrese la hora deseada en el formato HH:MM:");

        almacenarDatos(fechaInput, horaInput, framePrograma);  // Almacenar la reserva
    }

    private void almacenarDatos(String fechaInput, String horaInput, JFrame framePrograma) {
        try {
            // Parsear fecha y hora
            String[] fechaPartes = fechaInput.split("/");
            int dia = Integer.parseInt(fechaPartes[0]);
            int mes = Integer.parseInt(fechaPartes[1]) - 1; // Mes comienza en 0
            int año = Integer.parseInt(fechaPartes[2]);

            String[] horaPartes = horaInput.split(":");
            int hora = Integer.parseInt(horaPartes[0]);
            int minuto = Integer.parseInt(horaPartes[1]);

            Calendar fechaHora = Calendar.getInstance();
            fechaHora.set(año, mes, dia, hora, minuto);

            // Asignar la fecha y hora al atributo
            this.fechaHoraReserva = fechaHora;

            JOptionPane.showMessageDialog(framePrograma, 
                "Reserva realizada con éxito para el día " + dia + "/" + (mes + 1) + "/" + año + 
                " a las " + hora + ":" + String.format("%02d", minuto) + ".");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(framePrograma, 
                "Error al procesar la reserva: " + e.getMessage());
        }
    }

    // Getters y Setters
    public Calendar getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    public void setFechaHoraReserva(Calendar fechaHoraReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
    }
}


