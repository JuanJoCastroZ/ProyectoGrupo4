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
    private String ReservasFacturas = "";
    private String[] listaDeReservas;
    private String[] elementosDeReserva;
    //Atributos que se devolveran para saber que está o no ocupado
    private String cineOcupado;
    private String GimnasioOcupado;
    private String claseOcupado;
    private String bebidaOcupado;
    //Atributo que guardara la seleccion hecha por el usuario respecto a que hacer con cada reserva que se le muestre
    private int Seleccion;
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
            Object[] opciones = {"Modificar", "Eliminar", "Siguiente"}; 
            int numReserva = i;
            int numReservaPrint = i + 1;
            elementosDeReserva = listaDeReservas[i].split(",");
            Seleccion = JOptionPane.showOptionDialog(null, "Reserva " + numReservaPrint + "° \n" +
                    "Nombre: " + elementosDeReserva[0] + "\n" +
                    "ID: " + elementosDeReserva[1] + "\n" +
                    "Sala de cine: " + elementosDeReserva[2] + "\n" +
                    "Asiento: " + elementosDeReserva[3] + "\n" +
                    "Hora funcion: " + elementosDeReserva[4] + "\n" +
                    "Pelicula: " + elementosDeReserva[5] + "\n" +
                    "Dia de la funcion: " + elementosDeReserva[6] + "\n" +
                    "Hora gimnasio: " + elementosDeReserva[7] + "\n" +
                    "Dia gimnasio: " + elementosDeReserva[8] + "\n" +
                    "Clase: " + elementosDeReserva[9] + "\n" +
                    "Horario de clase: " + elementosDeReserva[10] +  "\n" +
                    "Dia de clase: " + elementosDeReserva[11] +  "\n" +
                    "Bebida: " + elementosDeReserva[12] + "\n" +
                    "Hora de bebida: " + elementosDeReserva[13] + "\n" +
                    "Dia de bebida: " + elementosDeReserva[14]
                    //Finaliza muestra de la reserva y ahora pregunta que hacer con ella
                    ,"Visor reservas",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, opciones, opciones[0]);
            
            switch(Seleccion)
            {
                case 0:
                    MoficiarReserva(elementosDeReserva, numReserva);
                    //muestraReservas();
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        }
    }
    //Modificar reservas
    private void MoficiarReserva(String[] elementosDeReserva, int numReserva)
    {
        Object[] opciones = {"Sala de cine", "Asiento", "Hora funcion", "Pelicula", "Dia de la funcion", "Hora gimnasio", "Dia gimnasio", "Clase", "Horario de clase", "Dia de clase", "Bebida", "Hora de bebida", "Dia de bebida"}; 
        int SeleccionInterna;
        String elementosReservaInterno = "";
        String temporal = "";
        String elementosString = "";
        SeleccionInterna = JOptionPane.showOptionDialog(null,"Elige un campo por cambiar:","Modificar reserva",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, opciones, opciones[0]);
        switch(SeleccionInterna)
        {
            case 0: 
                temporal = JOptionPane.showInputDialog("Cambiando asiento: ");
                if(temporal != checadorOcupado(2, temporal))
                {
                    elementosDeReserva[2] = temporal;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Ya está ocupado");
                }
                break;
            case 1: 
                elementosDeReserva[3] = JOptionPane.showInputDialog("Cambiando hora funcion: ");
                break;
            
        }
        for(int i = 0; i < elementosDeReserva.length; i++)
        {
            elementosString = elementosString + elementosDeReserva[i] + ",";
        }
        listaDeReservas[numReserva] = elementosString;
        mensajeConfirmacion();
        muestraReservas();
    }
    private void mensajeConfirmacion()
    {
     JOptionPane.showMessageDialog(null, "Campo modificado correctamente");
    }
    private String checadorOcupado(int elementoChequeo, String datoComparacion)
    {
        for(int i = 0; i < listaDeReservas.length; i++)
        {
            elementosDeReserva = listaDeReservas[i].split(",");
            if(elementosDeReserva[elementoChequeo] == datoComparacion)
            {
                return datoComparacion;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Espacio ya ocupado");
            }
        }
        
        return "NODATAEXISTENTE!";
    }
    //public void verFacturas()
}
