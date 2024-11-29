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
public class gestionReservas {
    public String ReservasFacturas = "";
    public String[] listaDeReservas;
    public String[] elementosDeReserva;
    //Metodo constructor
    public gestionReservas(String Factura) {
        ReservasFacturas = ReservasFacturas + Factura;
        separacionReservas();
        muestraReservas();
    }
    //public MenuGestionReserva()
    //Metodos
    public void separacionReservas()
    {
        listaDeReservas = ReservasFacturas.split("\\."); //Separa en un array las distintas reservas dentro del String que almacena las reservas concatenadas
    }
    public void muestraReservas() //Muestra todas las reservas generadas en listaDeReservas
    {
        for(int i = 0; i < listaDeReservas.length; i++)
        {
            int numReserva = i + 1;
            elementosDeReserva = listaDeReservas[i].split(",");
            JOptionPane.showMessageDialog(null, "Reserva " + numReserva + "° \n" +
                    "Nombre: " + elementosDeReserva[0] + "\n" +
                    "ID: " + elementosDeReserva[1] + "\n" +
                    "Sala de cine: " + elementosDeReserva[2] + "\n" +
                    "Asiento: " + elementosDeReserva[3] + "\n" +
                    "Hora funcion: " + elementosDeReserva[4] + "\n" +
                    "Pelicula: " + elementosDeReserva[5] + "\n" +
                    "Hora gimnasio: " + elementosDeReserva[6] + "\n" +
                    "Clase: " + elementosDeReserva[7] + "\n" +
                    "Horario de clase: " + elementosDeReserva[8] +  "\n" +
                    "Bebida: " + elementosDeReserva[9] + "\n" +
                    "Hora de bebida: " + elementosDeReserva[10]
                    );
        }
    }
    //Modificar reservas
    
    //public void verFacturas()
}
