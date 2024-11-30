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
public class Interfaz {
    //Atributos
    private String empleadoNombre = "N/A";
    private String empleadoID = "N/A";
    private int seleccion;
    //Guardamos los datos de la reserva que se pasarán a la interfaz inicial
    private String[] datoReserva = new String[16]; //Guardamos todos los datos de la reserva que se haga en el menu de reserva
    private String reservaUnificadaString = "";
    private String salaCine = "N/A";
    private String Asiento = "N/A";
    private String horaCine = "N/A";
    private String Pelicula = "N/A";
    private String diaCine = "N/A";
    private String horaGym = "N/A";
    private String diaGym = "N/A";
    private String tipoClase = "N/A";
    private String horaClase = "N/A";
    private String diaClase = "N/A";
    private String Bebida = "N/A";
    private String horaBebida = "N/A";
    private String diaBebida = "N/A";
    private String finalizador = ".";
    
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
     public void opcionesMenuReserva() //Da bienvenida y recolecta menú por ingresar
    {
        Object[] opciones = {"1- Cine", "2- Gimnasio", "3- Clases", "4- Barista", "5- Generar reserva", "6- Volver"};
        // Muestra las distintas cosas que se pueden reservar
        seleccion = JOptionPane.showOptionDialog(null,"Elige una opcion:","Menu reserva",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, opciones, opciones[0]);
        MenuReserva(seleccion);
    }
    public void MenuReserva(int seleccion) {

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
                BaristaRegistro();
                opcionesMenuReserva();
                break;
            case 4:
                //Los agregamos al array de la reserva
                datoReserva[0] = empleadoNombre + "       ,";
                datoReserva[1] = empleadoID + "       ,";
                datoReserva[2] = salaCine + "       ,";
                datoReserva[3] = Asiento + "       ,";
                datoReserva[4] = horaCine + "       ,";
                datoReserva[5] = Pelicula + "       ,";
                datoReserva[6] = diaCine + "       ,";
                datoReserva[7] = horaGym + "       ,";
                datoReserva[8] = diaGym + "       ,";
                datoReserva[9] = tipoClase + "       ,";
                datoReserva[10] = horaClase + "       ,";
                datoReserva[11] = diaClase + "       ,";
                datoReserva[12] = Bebida + "       ,";
                datoReserva[13] = horaBebida + "       ,";
                datoReserva[14] = diaBebida + "       ,";
                datoReserva[15] = finalizador;
                   
                JOptionPane.showMessageDialog(null, "Se ha guardado la reserva exitosamente.");
                //vueltaMenu();
                break;
            case 5:
                //vueltaMenu();
                break;
        }
    }
    private void vueltaMenu()
    {
        InterfazInicial interfazInicial = new InterfazInicial(false);
    }

    public String getDatoReserva() {
        for(int i = 0; i < datoReserva.length; i++)
        {
            reservaUnificadaString = reservaUnificadaString + datoReserva[i];
        }
        return reservaUnificadaString;
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
        
    }
    private void BaristaRegistro()
    {
        BaristaReserva BaristaRegistro = new BaristaReserva();
    }
}
