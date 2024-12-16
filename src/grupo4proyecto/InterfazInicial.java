/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo4proyecto;

import javax.swing.JOptionPane;

/**
 *
 * @author Juan Jose
 */
public class InterfazInicial {
    private int cantidadReservas = 0;
    private int seleccion;
    private String reservaConcatenada = ""; //Guarda la informacion de la reserva en un unico string
    private boolean esPrimeraVez; //Controla si es la primera vez que se accede, de manera que el mensaje de bienvenida no aparezca en caso de no ser la primera vez
    //Constructor
    public InterfazInicial(boolean esPrimeraVez, int reservasCantidad) {
        cantidadReservas = reservasCantidad;
        //Llamado metodos  
        this.esPrimeraVez = esPrimeraVez;
        opcionesMenuInicial();
    }
    //Setter y getters

    public int getCantidadReservas() {
        return cantidadReservas;
    }
    
    //Metodos
    public void opcionesMenuInicial() //Da bienvenida y recolecta menú por ingresar
    {
        // 
        Object[] opciones = {"1- Reservar", "2- Gestion reservas", "3- Gestion cine", "4- Cerrar programa"};
        if(esPrimeraVez)
        {
            JOptionPane.showMessageDialog(null, "Bienvenid@ al sistema de reservas.");
        }
        // Muestra las opciones del menu
        seleccion = JOptionPane.showOptionDialog(null,"Elige una opcion:","Menu inicial",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, opciones, opciones[0]);
        switch(seleccion)
        {
            case 0:
                accesoReserva();
                break;
            case 1:
                if(reservaConcatenada != "")
                {
                    accesoGestionReserva();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Aun no hay datos por mostrar.");
                    esPrimeraVez = false;
                    opcionesMenuInicial();
                } 
        }
    }
    public int GetOpcionSelecta()
    {
        return seleccion;
    }
    
    public void concatenarReserva(String[] datoReserva) //Guarda los datos de la reserva en el string reservaConcatenada
    {
        for(int i = 0; i < datoReserva.length; i++)
        {
            reservaConcatenada = reservaConcatenada + datoReserva[i];
            System.out.println(reservaConcatenada);
        }
    }

    public String getReservaConcatenada() {
        return reservaConcatenada;
    }
    //Metodos menu
    public void accesoReserva()
    {
        Empleado empleado = new Empleado();
        Interfaz menuReserva = new Interfaz(empleado.getEmpleadoNombre(), empleado.getEmpleadoID());
        reservaConcatenada = reservaConcatenada + menuReserva.getDatoReserva();
        esPrimeraVez = false;
        opcionesMenuInicial();
        
    }
    public void accesoGestionReserva()
    {
        gestionReservas gestorReserva = new gestionReservas(reservaConcatenada);
    }
    
}
