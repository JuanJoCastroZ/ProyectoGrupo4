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
    private GeneradorReserva[] listaReservas = new GeneradorReserva[10];
    
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
                
                Empleado empleado = new Empleado();
                Interfaz menuReserva = new Interfaz(empleado.getEmpleadoNombre(), empleado.getEmpleadoID());
                listaReservas[cantidadReservas] = menuReserva.reservaGetter();
                cantidadReservas++;
                esPrimeraVez = false;
                opcionesMenuInicial();
                
                break;
            case 1:
                
                if(cantidadReservas != 0)
                {
                    esPrimeraVez = false;
                    accesoGestionReserva();
                }
                else
                {
                    esPrimeraVez = false;
                    JOptionPane.showMessageDialog(null, "Aun no existen entradas.");
                    opcionesMenuInicial();
                }
        }
    }
    public int GetOpcionSelecta()
    {
        return seleccion;
    }
    
    

    
    //Metodos menu
    public void accesoReserva()
    {
        
        
    }
    public void accesoGestionReserva()
    {
        gestionReservas gestorReserva = new gestionReservas(listaReservas,cantidadReservas);
        opcionesMenuInicial();
    }
    
}
