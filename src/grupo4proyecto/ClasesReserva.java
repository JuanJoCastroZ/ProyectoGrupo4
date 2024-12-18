/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo4proyecto;
import java.util.Calendar;
import javax.swing.JOptionPane;
/**
 *
 * @author Juan Jose
 */
public class ClasesReserva {
    //Atributos por devolver
    private String tipoClase = "N/A";
    private Calendar calendarClase;
    private int seleccion = 0;
    //Metodo constructor
    public ClasesReserva() {
        opcionesMenu();
    }
    //Metodos
    public void opcionesMenu() //Recolecta reserva por ingresar
    {
        Object[] opciones = {"1- Yoga", "2- Baile", "3- Cancelar"};
        // Muestra las distintas cosas que se pueden reservar
        seleccion = JOptionPane.showOptionDialog(null,"Elige una opcion para reservar:","Menu reserva clases",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, opciones, opciones[0]);
        menuReservaClases(seleccion);
    }
    //Menu donde se recolectan los datos de la reserva
    private void menuReservaClases(int seleccion)
    {
        switch(seleccion)
        {
            case 0: 
                almacenarDatos("Yoga", JOptionPane.showInputDialog("Ingrese la fecha deseada en el formato DD/MM/AAAA"), JOptionPane.showInputDialog("Ingrese la hora deseada en el formato HH:MM"));
                break;
            case 1:
                almacenarDatos("Baile", JOptionPane.showInputDialog("Ingrese la fecha deseada en el formato DD/MM/AAAA"), JOptionPane.showInputDialog("Ingrese la hora deseada en el formato HH:MM"));
                break;
        }
    }
    //Metodo para tratar y almacenar los datos a los atributos
    private void almacenarDatos(String tipoClase, String calendarClase, String horaClase)
    {
        //Parse de string a calendar
        String[] calendario = calendarClase.split("/");
        int dia = Integer.parseInt(calendario[0]);
        int mes = Integer.parseInt(calendario[1]) - 1;
        int año = Integer.parseInt(calendario[2]);

        String[] tiempo = horaClase.split(":");
        int hora = Integer.parseInt(tiempo[0]);
        int minuto = Integer.parseInt(tiempo[1]);
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(año, mes, dia, hora, minuto);
        
        //Asigna los datos a los atributos de la clase
        this.tipoClase = tipoClase;
        this.calendarClase = calendar;
    }
    //Getters para que los datos obtenidos sean accesibles
    public String getTipoClase() {
        return tipoClase;
    }
    public Calendar getCalendarClase() {
        return calendarClase;
    }
}