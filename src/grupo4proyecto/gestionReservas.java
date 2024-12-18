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
    
    //Reflejo de los objetos creados hasta el momento
    private int cantidadReservas = 0;
    private GeneradorReserva[] listaReservas = new GeneradorReserva[100];
    //Atributo que guardara la seleccion hecha por el usuario respecto a que hacer con cada reserva que se le muestre
    private int Seleccion;
    //Metodo constructor
    public gestionReservas(GeneradorReserva[] listaReservas, int cantidadReservas) {
        this.listaReservas = listaReservas;
        this.cantidadReservas = cantidadReservas;
        muestraReservas();
    }
    //Metodos
    public void muestraReservas() //Muestra todas las reservas generadas en listaDeReservas
    {
        //Enorme joption show con todos los datos de las reservas
        for(int i = 0; i < listaReservas.length; i++)
        {
            if(listaReservas[i] != null)
            {
                String porImprimir = "Nombre del empleado: " + listaReservas[i].getEmpleadoNombre() + 
                        "\n" +
                        "ID del Empleado: " + listaReservas[i].getEmpleadoID()
                        + "\n" +
                        "Sala de Cine: " + listaReservas[i].getSalaCine()
                        + "\n" +
                        "Asiento: " + listaReservas[i].getAsiento()
                        + "\n" +
                        "Película: " + listaReservas[i].getPelicula()
                        + "\n" +
                        "Fecha y Hora del Cine: " + listaReservas[i].getCalendarCine()
                        + "\n" +
                        "Fecha y Hora del Gimnasio: " + listaReservas[i].getCalendarGym()
                        + "\n" +
                        "Tipo de Clase: " + listaReservas[i].getTipoClase()
                        + "\n" +
                        "Fecha y Hora de la Clase: "+ listaReservas[i].getCalendarClase()
                        + "\n" +
                        "Bebida: " + listaReservas[i].getBebida()
                        + "\n" +
                        "Fecha y Hora de la Bebida: " + listaReservas[i].getCalendarBebida()
                        ;


                Object[] opciones = {"Modificar", "Eliminar", "Siguiente"};
                Seleccion = JOptionPane.showOptionDialog(null, porImprimir, "Menu gestion de reservas",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, opciones, opciones[0]);

                switch (Seleccion) { //
                    case 0:
                        MoficiarReserva(i);
                        
                        break;
                    case 1:
                        eliminarReserva(i);
                        break;
                    case 2:
                        break;
                }
            }
        } 
    }
    //Modificar reservas
    private void MoficiarReserva(int posicionReserva)
    {
        Object[] opciones = {"Nombre del Empleado", "ID del Empleado", "Sala de Cine", "Asiento", "Película", "Fecha y Hora del Cine", 
            "Fecha y Hora del Gimnasio", "Tipo de Clase", "Fecha y Hora de la Clase", "Bebida", "Fecha y hora de la Bebida"}; 
        int SeleccionInterna;
        SeleccionInterna = JOptionPane.showOptionDialog(null,"Elige un campo por cambiar:","Modificar reserva",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,null, opciones, opciones[0]);
        boolean ocupado = false;
        switch(SeleccionInterna) //Pregunta por el nuevo dato dependiendo del campo seleccionado para ser modificado
        {
            case 0: 
                String Nombre = JOptionPane.showInputDialog("Introduce el nuevo nombre: ");
                listaReservas[posicionReserva].setEmpleadoNombre(Nombre);
                break;
            case 1: 
                //System.out.println(listaReservas[i].getEmpleadoID());
                String ID = JOptionPane.showInputDialog("Introduce el nuevo ID: ");
                for(int i = 0; i < listaReservas.length; i++)
                {
                    System.out.println(listaReservas[i]);
                    if(listaReservas[i].getEmpleadoID() == ID)
                    {
                        ocupado = true;
                    }
                }
                
                listaReservas[posicionReserva].setEmpleadoID(ID);
                break;
            case 2:
                listaReservas[posicionReserva].setSalaCine(Integer.parseInt(JOptionPane.showInputDialog("Introduce la nueva sala de Cine: ")));
                break;  
            case 3:
                listaReservas[posicionReserva].setAsiento(JOptionPane.showInputDialog("Introduce el nuevo asiento: "));
                break;  
            case 4:
                listaReservas[posicionReserva].setPelicula(JOptionPane.showInputDialog("Introduce la nueva pelicula: "));
                break;  
            case 5:
                //listaReservas[posicionReserva].setCalendarCine(JOptionPane.showInputDialog("Introduce la nueva fecha: "));
                break;
            case 6:
                //listaReservas[posicionReserva].setCalendarGym("Introduce la nueva fecha: ");
                break;
            case 7:
                listaReservas[posicionReserva].setTipoClase("Introduce la nueva clase: ");
                break;
            case 8:
                //listaReservas[posicionReserva].setCalendarClase("Introduce la nueva fecha: ");
                break;
            case 9:
                listaReservas[posicionReserva].setBebida("Introduce la nueva bebida: ");
                break;
            case 10:
                //listaReservas[posicionReserva].setCalendarBebida("Introduce la nueva fecha: ");
                break;         
        }
    }
    
    private void eliminarReserva(int posicionReserva)
    {
        listaReservas[posicionReserva] = null;
    }
    private void mensajeError()
    {
        JOptionPane.showConfirmDialog(null, "Ya está ocupado.");
    }
    private void mensajeConfirmacion()
    {
     JOptionPane.showMessageDialog(null, "Campo modificado correctamente");
    }
    private String checadorOcupado(int elementoChequeo, String datoComparacion)
    {
        return "NODATAEXISTENTE!";
    }
    //public void verFacturas()
}
