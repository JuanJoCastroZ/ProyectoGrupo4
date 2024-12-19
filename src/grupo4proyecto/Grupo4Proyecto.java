/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grupo4proyecto;

import javax.swing.SwingUtilities;

/**
 * Clase principal para ejecutar el programa de reservas.
 */
public class Grupo4Proyecto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { //El invoke nos va a permitir manejar los eventos de forma separada
            framePrograma frame = new framePrograma();
            frame.setVisible(true);
        });
    }
}
