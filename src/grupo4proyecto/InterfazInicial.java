package grupo4proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InterfazInicial extends JPanel {
    private GeneradorReserva[] listaReservas = new GeneradorReserva[10];
    private int cantidadReservas = 0;
    private JFrame framePrograma;
    private boolean esPrimeraVez;

    // Constructor
    public InterfazInicial(boolean esPrimeraVez, int reservasCantidad, JFrame framePrograma) {
        this.esPrimeraVez = esPrimeraVez;
        this.cantidadReservas = reservasCantidad;
        this.framePrograma = framePrograma;
        initPanel();
    }

    // Método que devuelve este panel
    public JPanel getPanel() {
        return this;
    }
    // Método para configurar reservas existentes y actualizar la interfaz
    public void setReservas(GeneradorReserva[] reservas, int cantidad) {
        this.listaReservas = reservas;
        this.cantidadReservas = cantidad;

        //Reiniciar el panel
        removeAll();
        initPanel();  
        revalidate();  
        repaint();  
    }


    
    private void initPanel() {
        setLayout(new BorderLayout());

        JLabel label = new JLabel("Bienvenid@ al sistema de reservas", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        String[] opciones = {"Reservar", "Gestion reservas", "Cerrar programa"};

        for (String opcion : opciones) {
            JButton button = new JButton(opcion);
            button.addActionListener((ActionEvent e) -> handleButtonClick(opcion));
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.CENTER);
    }

    private void handleButtonClick(String opcion) {
        switch (opcion) {
            case "Reservar":
                Empleado empleado = new Empleado();
                Interfaz panelReserva = new Interfaz(empleado.getEmpleadoNombre(), empleado.getEmpleadoID(), framePrograma);

                int result = JOptionPane.showConfirmDialog(framePrograma, panelReserva, 
                        "Reservar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (result == JOptionPane.OK_OPTION && panelReserva.getReserva() != null) {
                    listaReservas[cantidadReservas++] = panelReserva.getReserva();
                } else {
                    JOptionPane.showMessageDialog(framePrograma, "No se generó ninguna reserva.");
                }
                break;

            case "Gestion reservas":
                if (cantidadReservas > 0) {
                    mostrarGestionReservas();  // Aquí va el cambio
                } else {
                    JOptionPane.showMessageDialog(framePrograma, "Aún no existen entradas.");
                }
                break;

            case "Cerrar programa":
                System.exit(0);
                break;
        }
    }   

    // Nuevo método para mostrar la gestión de reservas
    private void mostrarGestionReservas() {
        gestionReservas gestorReserva = new gestionReservas(listaReservas, cantidadReservas, framePrograma);

        // Reemplaza el contenido actual
        framePrograma.setContentPane(gestorReserva.getPanel());
        framePrograma.revalidate();
        framePrograma.repaint();
    }

}
