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
import java.util.Calendar;

public class Interfaz extends JPanel {
    private String empleadoNombre;
    private String empleadoID;
    private int salaCine;
    private String asiento;
    private String pelicula;
    private String tipoClase;
    private String bebida;
    private Calendar calendarCine;
    private Calendar calendarGym;
    private Calendar calendarClase;
    private Calendar calendarBebida;
    private GeneradorReserva reserva;
    private JFrame framePrograma;

    public Interfaz(String empleadoNombre, String empleadoID, JFrame framePrograma) {
        this.empleadoNombre = empleadoNombre;
        this.empleadoID = empleadoID;
        this.framePrograma = framePrograma;
        initPanel();
    }

    public JPanel getPanel() {
        return this;
    }

    private void initPanel() { //Muestra las opciones por poder reservar
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Menú de Reservas", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        String[] opciones = {"Cine", "Gimnasio", "Clases", "Barista", "Generar reserva"}; //Almacena las opciones posibles

        for (String opcion : opciones) { //Recorre cada opcion en opciones como for each para asi crear cada boyon y asignarle un evento de java swing
            JButton botones = new JButton(opcion);
            botones.addActionListener((ActionEvent e) -> botonPresionado(opcion));
            buttonPanel.add(botones);
        }
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void botonPresionado(String opcion) {
        switch (opcion) {
            case "Cine":
                CineRegistro();
                break;
            case "Gimnasio":
                GimnasioRegistro();
                break;
            case "Clases":
                ClaseRegistro();
                break;
            case "Barista":
                calendarBebida = Calendar.getInstance();
                BaristaRegistro();
                break;
            case "Generar reserva":
                generarReserva();
                return;
        }
    }

    private void CineRegistro() {
        /*CineReserva cine = new CineReserva(framePrograma);
        salaCine = cine.getSalaCine();
        asiento = cine.getAsiento();
        pelicula = cine.getPelicula();
        calendarCine = cine.getCalendarCine();*/
    }

    private void GimnasioRegistro() {
        GimnasioReserva gimnasio = new GimnasioReserva(framePrograma);
        calendarGym = gimnasio.getFechaHoraReserva();
    }

    private void ClaseRegistro() {
        ClasesReserva clases = new ClasesReserva(framePrograma);
        tipoClase = clases.getTipoClase();
        calendarClase = clases.getCalendarClase();
    }

    private void BaristaRegistro() {
        BaristaReserva barista = new BaristaReserva(framePrograma);
        bebida = barista.getBebida();
        calendarBebida.set(barista.getDiaBebida().get(Calendar.YEAR), barista.getDiaBebida().get(Calendar.MONTH), barista.getDiaBebida().get(Calendar.DAY_OF_MONTH), barista.getHoraBebida().get(Calendar.HOUR_OF_DAY), barista.getHoraBebida().get(Calendar.MINUTE));
    }

    private void generarReserva() {
        reserva = new GeneradorReserva(empleadoNombre, empleadoID, salaCine, asiento, pelicula,calendarCine, calendarGym, tipoClase, calendarClase, bebida, calendarBebida);
        JOptionPane.showMessageDialog(framePrograma, "Reserva generada correctamente.");
    }

    public GeneradorReserva getReserva() {
        return reserva;
    }
}

