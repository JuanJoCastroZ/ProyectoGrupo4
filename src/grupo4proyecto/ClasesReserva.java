/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo4proyecto;

import java.util.Calendar;
import javax.swing.*;

/**
 *
 * @author Juan Jose
 */
public class ClasesReserva {
    // Atributos por devolver
    private String tipoClase = "N/A";
    private Calendar calendarClase;
    private int seleccion = 0;

    // metodo constructor
    public ClasesReserva(JFrame framePrograma) {
        opcionesMenu(framePrograma);
    }

    // Metodos
    public void opcionesMenu(JFrame framePrograma) {
        Object[] opciones = {"1- Yoga", "2- Baile", "3- Cancelar"};
        
        // Mostrar opciones de reserva
        seleccion = JOptionPane.showOptionDialog(framePrograma, "Elige una opción para reservar:", 
                "Menú de Reserva de Clases", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                null, opciones, opciones[0]);
        
        menuReservaClases(seleccion, framePrograma);
    }

    // Menu donde se recolectan los datos de la reserva
    private void menuReservaClases(int seleccion, JFrame framePrograma) {
        switch (seleccion) {
            case 0:
                recogerDatos("Yoga", framePrograma);
                break;
            case 1:
                recogerDatos("Baile", framePrograma);
                break;
        }
    }

    // metodo para recoger y almacenar datos
    private void recogerDatos(String tipoClase, JFrame framePrograma) {
            String fechaIngresada = JOptionPane.showInputDialog(framePrograma, "Ingrese la fecha deseada en el formato DD/MM/AAAA :");
            String horaIngresada = JOptionPane.showInputDialog(framePrograma, "Ingrese la hora deseada en el formato HH:MM :");
            almacenarDatos(tipoClase, fechaIngresada, horaIngresada);
    }

    // metodo para almacenar datos en atributos de la clase
    private void almacenarDatos(String tipoClase, String calendarClase, String horaClase) {

        // parsear fecha y hora
        String[] calendario = calendarClase.split("/");
        int dia = Integer.parseInt(calendario[0]);
        int mes = Integer.parseInt(calendario[1]) - 1;
        int año = Integer.parseInt(calendario[2]);

        String[] tiempo = horaClase.split(":");
        int hora = Integer.parseInt(tiempo[0]);
        int minuto = Integer.parseInt(tiempo[1]);

        // crear instancia de Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.set(año, mes, dia, hora, minuto);

        // asignar datos
        this.tipoClase = tipoClase;
        this.calendarClase = calendar;

    }

    // Getters para que los datos obtenidos sean accesibles
    public String getTipoClase() {
        return tipoClase;
    }

    public Calendar getCalendarClase() {
        return calendarClase;
    }
}
