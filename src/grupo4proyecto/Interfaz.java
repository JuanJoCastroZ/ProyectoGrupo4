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
public class Interfaz {
    //Atributos
    private String empleadoNombre = "N/A";
    private String empleadoID = "N/A";
    private int seleccion; //Guarda la opcion de menu seleccionada
    private int cantidadReservas = 0; //Control para matriz
    //Guardamos los datos de la reserva que se pasarán al objeto reserva que se crea al confirmar la generación de reserva (Opcion de menu: 4)
    private int salaCine = 0;
    private String Asiento = "N/A";
    private String Pelicula = "N/A";
    private Calendar calendarCine;
    private Calendar calendarGym;
    private String tipoClase = "N/A";
    private Calendar calendarClase;
    private String Bebida = "N/A";
    private Calendar calendarBebida;
    //Objeto
    GeneradorReserva reserva;
    
    //Lista de objetos en este caso reservas
    
    
    //Metodo constructor
    public Interfaz(String empleadoNombre, String empleadoID) {
        this.empleadoNombre = empleadoNombre;
        this.empleadoID = empleadoID;
        //Llamada de metodos
        opcionesMenuReserva();
    }
    //Getters
    public String getEmpleadoNombre() {
        return empleadoNombre;
    }

    public String getEmpleadoID() {
        return empleadoID;
    }

    public int getSeleccion() {
        return seleccion;
    }
    
    //Metodos
     public void opcionesMenuReserva() //recolecta menú por ingresar
    {
        Object[] opciones = {"1- Cine", "2- Gimnasio", "3- Clases", "4- Barista", "5- Generar reserva", "6- Volver"};
        // Muestra las distintas cosas que se pueden reservar
        seleccion = JOptionPane.showOptionDialog(null,"Elige una opcion:","Menu reserva",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, opciones, opciones[0]);
        MenuReserva(seleccion);
    }
    public void MenuReserva(int seleccion) {
//a
        /*
                |||MENU RESERVA|||
         */
        switch (seleccion) //Recibe la seleccion del usuario y dependiendo del boton presionado, abre un tipo de reserva u otra
        {
            case 0:
                CineRegistro();
                opcionesMenuReserva();
                break;
            case 1:
                GimnasioRegistro();
                opcionesMenuReserva();
                break;
            case 2:
                ClaseRegistro();
                opcionesMenuReserva();
                break;
            case 3:
                calendarBebida = Calendar.getInstance();
                BaristaRegistro();
                opcionesMenuReserva();
                break;
            case 4:
                //Agregamos los datos a los setters del generador de reserva
                reserva = new GeneradorReserva(empleadoNombre, empleadoID, salaCine, Asiento, Pelicula, calendarCine, calendarGym, tipoClase, calendarClase, Bebida, calendarBebida);
                JOptionPane.showMessageDialog(null, "Se ha guardado la reserva exitosamente.");
                break;
                //vuelta a Menu
                
            case 5:
                //vuelta a Menu
                break;
        }
    }
    
    //Metodos para distintas reservas
    private void CineRegistro()
    {
        CineReserva CineRegistro = new CineReserva();
    }
    private void GimnasioRegistro()
    {
        GimnasioReserva GimnasioRegistro = new GimnasioReserva();
    }
    private void ClaseRegistro(){
        ClasesReserva ClaseRegistro = new ClasesReserva();
        //Asignar las variables de arriba, los getters del objeto ClasesReserva
        calendarClase = ClaseRegistro.getCalendarClase();
        tipoClase = ClaseRegistro.getTipoClase();
       
    }
    private void BaristaRegistro()
    {
        BaristaReserva BaristaRegistro = new BaristaReserva();
        calendarBebida.set(BaristaRegistro.getDiaBebida().get(Calendar.YEAR), BaristaRegistro.getDiaBebida().get(Calendar.MONTH), BaristaRegistro.getDiaBebida().get(Calendar.DAY_OF_MONTH), BaristaRegistro.getHoraBebida().get(Calendar.HOUR_OF_DAY), BaristaRegistro.getHoraBebida().get(Calendar.MINUTE));
    }
    
    public GeneradorReserva reservaGetter()
    {
        if(reserva != null)
        {
            return reserva;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No se generó ninguna nueva reserva");
            return reserva;
        }        
    }
}
