/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo4proyecto;

/**
 *
 * @author Juan Jose
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat; //Para mantener formato de calendar
import java.util.Calendar;

public class gestionReservas extends JPanel {
    private GeneradorReserva[] listaReservas;
    private int cantidadReservas;
    private JFrame framePrograma;

    //Método constructor
    public gestionReservas(GeneradorReserva[] listaReservas, int cantidadReservas, JFrame framePrograma) {
        this.listaReservas = listaReservas;
        this.cantidadReservas = cantidadReservas;
        this.framePrograma = framePrograma;
        initPanel();
    }
    //Métodos
    //Método que devuelve este panel
    public JPanel getPanel() {
        return this;
    }

    private void initPanel() {
        setLayout(new BorderLayout());

        //Etiqueta principal
        JLabel label = new JLabel("Gestión de Reservas", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        //Panel para mostrar los botones de reservas
        JPanel panelBotones = new JPanel(new GridLayout(cantidadReservas + 1, 1, 10, 10));

        //Mostrar cada reserva con opciones
        for (int i = 0; i < cantidadReservas; i++) {
            if (listaReservas[i] != null) {
                String infoReserva = generarTextoReserva(listaReservas[i]); 
                JButton botonReserva = new JButton("Reserva " + (i + 1));
                final int indiceReserva = i; //Se declara final para evitar alteraciones
                botonReserva.addActionListener((ActionEvent e) -> mostrarOpciones(indiceReserva, infoReserva));
                panelBotones.add(botonReserva);
            }
        }

        //Botón de regreso a la interfaz inicial
        JButton botonRegresar = new JButton("Volver a la Interfaz Inicial");
        botonRegresar.addActionListener((ActionEvent e) -> regresarInterfazInicial());
        panelBotones.add(botonRegresar);  //Agregar el botón al panel principal

        add(panelBotones, BorderLayout.CENTER);  //Agregar el panel principal a la ventana
    }


    //Genera texto para mostrar los datos de una reserva en formato HTML que utilizará el método addActionListener
    private String generarTextoReserva(GeneradorReserva reserva) {
        return "<html>" +
                "<b>Nombre:</b> " + reserva.getEmpleadoNombre() + "<br>" +
                "<b>ID:</b> " + reserva.getEmpleadoID() + "<br>" +
                "<b>Sala de Cine:</b> " + reserva.getSalaCine() + "<br>" +
                "<b>Asiento:</b> " + reserva.getAsiento() + "<br>" +
                "<b>Película:</b> " + reserva.getPelicula() + "<br>" +
                "<b>Fecha y Hora del Cine:</b> " + reserva.getCalendarCine() + "<br>" +
                "<b>Fecha y Hora del Gimnasio:</b> " + reserva.getCalendarGym() + "<br>" +
                "<b>Tipo de Clase:</b> " + reserva.getTipoClase() + "<br>" +
                "<b>Fecha y Hora de la Clase:</b> " + reserva.getCalendarClase() + "<br>" +
                "<b>Bebida:</b> " + reserva.getBebida() + "<br>" +
                "<b>Fecha y Hora de la Bebida:</b> " + reserva.getCalendarBebida() + 
                "</html>";
    }



    //Muestra los datos dependiendo de la reserva seleccionada a su vez que los botones de acciones
    private void mostrarOpciones(int indice, String infoReserva) {
        Object[] opciones = {"Modificar", "Eliminar", "Cancelar"};
        int seleccion = JOptionPane.showOptionDialog(framePrograma, infoReserva, 
                "Opciones de Reserva", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                null, opciones, opciones[0]);

        switch (seleccion) {
            case 0: // Modificar
                MoficiarReserva(indice);
                break;
            case 1: // Eliminar
                listaReservas[indice] = null;
                JOptionPane.showMessageDialog(framePrograma, "Reserva eliminada.");
                actualizarPanel();
                break;
            default:
                break; // Cancelar
        }
    }

    //Método para modificar una reserva existente
    private void MoficiarReserva(int posicionReserva) {
    //Opciones disponibles para modificar los campos de la reserva
    Object[] opciones = {"Nombre del Empleado", "ID del Empleado", "Sala de Cine", "Asiento", "Película", "Fecha y Hora del Cine\n", "Fecha y Hora del Gimnasio", "Tipo de Clase", "Fecha y Hora de la Clase", "Bebida", "Fecha y hora de la Bebida"};

    //Mostrar cuadro de diálogo para seleccionar el campo a modificar
    int seleccionInterna = JOptionPane.showOptionDialog(framePrograma, "Elige un campo para modificar:", "Modificar Reserva", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

    //Modificar el campo seleccionado
        switch (seleccionInterna) { //Cada caso corresponde a un atributo por ser cambiado
            case 0: 
                
                String nuevoNombre = JOptionPane.showInputDialog(framePrograma, "Introduce el nuevo nombre:");
                listaReservas[posicionReserva].setEmpleadoNombre(nuevoNombre);
                break;

            case 1:  
                String nuevoID = JOptionPane.showInputDialog(framePrograma, "Introduce el nuevo ID:");
                listaReservas[posicionReserva].setEmpleadoID(nuevoID);
                break;
            case 2:
                listaReservas[posicionReserva].setSalaCine(Integer.parseInt(
                        JOptionPane.showInputDialog(framePrograma, "Introduce la nueva sala de cine:")
                ));
                break;
            case 3:
                listaReservas[posicionReserva].setAsiento(
                        JOptionPane.showInputDialog(framePrograma, "Introduce el nuevo asiento:")
                );
                break;
            case 4:
                listaReservas[posicionReserva].setPelicula(
                        JOptionPane.showInputDialog(framePrograma, "Introduce la nueva película:")
                );
                break;
            case 5:
                listaReservas[posicionReserva].setCalendarCine(stringACalendar("Introduce la nueva fecha del cine en formato DD/MM/AAAA", "Introduce la nueva hora del cine en formato HH:MM"));
                
                break;
            case 6:
                listaReservas[posicionReserva].setCalendarGym(stringACalendar("Introduce la nueva fecha de reserva en gimnasio en formato DD/MM/AAAA", "Introduce la nueva hora en formato HH:MM"));
                
                break;
            case 7:
                listaReservas[posicionReserva].setTipoClase(JOptionPane.showInputDialog(framePrograma, "Introduce el nuevo tipo de clase:"));
                break;
            case 8:
                listaReservas[posicionReserva].setCalendarClase(stringACalendar("Introduce la nueva fecha de clase en formato DD/MM/AAAA", "Introduce la nueva hora de clase en formato HH:MM"));
                break;
            case 9:
                listaReservas[posicionReserva].setBebida(JOptionPane.showInputDialog(framePrograma, "Introduce la nueva bebida:"));
                break;
            case 10:
                listaReservas[posicionReserva].setCalendarBebida(stringACalendar("Introduce la nueva fecha de bebida en formato DD/MM/AAAA", "Introduce la nueva hora de bebida en formato HH:MM"));
                break;
            default:  
                break;
        }
        actualizarPanel();
    }
    //Convierte string a calendar
    private Calendar stringACalendar(String porImprimir, String porImprimir2) {
        String calendarDato = JOptionPane.showInputDialog(framePrograma, porImprimir);
        String horaMinutoDato = JOptionPane.showInputDialog(framePrograma, porImprimir2);
        // Parsear fecha y hora
        String[] calendario = calendarDato.split("/");
        int dia = Integer.parseInt(calendario[0]);
        int mes = Integer.parseInt(calendario[1]) - 1;
        int año = Integer.parseInt(calendario[2]);

        String[] tiempo = horaMinutoDato.split(":");
        int hora = Integer.parseInt(tiempo[0]);
        int minuto = Integer.parseInt(tiempo[1]);

        // Crear instancia de Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.set(año, mes, dia, hora, minuto);
        return calendar;
    }

    //Remueve y agrega de nuevo la información con metodos de java swing
    private void actualizarPanel() {
        removeAll();
        initPanel();
        revalidate();
        repaint();
    }
    //Metodo para regresar a la interfaz inicial manteniendo reservas
    private void regresarInterfazInicial() {
        InterfazInicial interfazInicial = new InterfazInicial(true, cantidadReservas, framePrograma);
        interfazInicial.setReservas(listaReservas, cantidadReservas);  //Pasa las reservas existentes
        framePrograma.setContentPane(interfazInicial.getPanel());
        framePrograma.revalidate();
        framePrograma.repaint();
    }
}

