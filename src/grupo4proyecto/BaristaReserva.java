package grupo4proyecto;

import javax.swing.JOptionPane;
import java.util.Calendar;

public class BaristaReserva {
    private String Bebida;
    private Calendar horaBebida;
    private Calendar diaBebida;

    public BaristaReserva() {
        this.Bebida = "";
        this.horaBebida = Calendar.getInstance();
        this.diaBebida = Calendar.getInstance();
        
        // Llamamos al método para recoger los datos del usuario
        pedirInformacion();
        JOptionPane.showMessageDialog(null, "PRUEBA" + horaBebida + diaBebida);
    }

    public String getBebida() {
        return Bebida;
    }

    public void setBebida(String Bebida) {
        this.Bebida = Bebida;
    }

    public Calendar getHoraBebida() {
        return horaBebida;
    }

    public void setHoraBebida(int hora, int minuto) {
        horaBebida.set(Calendar.HOUR_OF_DAY, hora);
        horaBebida.set(Calendar.MINUTE, minuto);
        horaBebida.set(Calendar.SECOND, 0);
    }

    public Calendar getDiaBebida() {
        return diaBebida;
    }

    public void setDiaBebida(int año, int mes, int dia) {
        diaBebida.set(Calendar.YEAR, año);
        diaBebida.set(Calendar.MONTH, mes - 1);
        diaBebida.set(Calendar.DAY_OF_MONTH, dia);
    }

    public void mostrarMenu() {
        System.out.println("Menú de bebida:");
        System.out.println("1. Café normal");
        System.out.println("2. Capuchino");
        System.out.println("3. Capuchino con vainilla");
        System.out.println("4. Chocolate");
        System.out.println("5. Moka");
        System.out.println("6. Té chai");
        System.out.println("7. Café trío");
    }

    private String seleccionaraBebida(int opcion) {
        switch (opcion) {
            case 1:
                return "Café normal";
            case 2:
                return "Capuchino";
            case 3:
                return "Capuchino con vainilla";
            case 4:
                return "Chocolate";
            case 5:
                return "Moka";
            case 6:
                return "Té chai";
            case 7:
                return "Café trío";
            default:
                return "Opción no válida";
        }
    }

    public void mostrartPedido() {
        System.out.println("Tu bebida es: " + Bebida);
        System.out.println("Se entregará el día: " + diaBebida.get(Calendar.DAY_OF_MONTH) + "/"
                + (diaBebida.get(Calendar.MONTH) + 1) + "/" + diaBebida.get(Calendar.YEAR));
        System.out.println("A la hora: " + horaBebida.get(Calendar.HOUR_OF_DAY) + ":"
                + horaBebida.get(Calendar.MINUTE));
    }

    public String obtenerDatosReserva() {
        return Bebida + ", " + horaBebida.get(Calendar.HOUR_OF_DAY) + ":" + horaBebida.get(Calendar.MINUTE)
                + ", " + diaBebida.get(Calendar.DAY_OF_MONTH) + "/" + (diaBebida.get(Calendar.MONTH) + 1) + "/" + diaBebida.get(Calendar.YEAR);
    }

    // Método agregado para pedir información al usuario
    private void pedirInformacion() {
        // Pedir la bebida
        String bebidaSeleccionada = JOptionPane.showInputDialog(null, "Selecciona la bebida (1-7):\n"
                + "1. Café normal\n"
                + "2. Capuchino\n"
                + "3. Capuchino con vainilla\n"
                + "4. Chocolate\n"
                + "5. Moka\n"
                + "6. Té chai\n"
                + "7. Café trío");
        if (bebidaSeleccionada != null) {
            int opcion = Integer.parseInt(bebidaSeleccionada);
            this.Bebida = seleccionaraBebida(opcion);
        }

        // Pedir la hora de la bebida
        String hora = JOptionPane.showInputDialog(null, "Ingresa la hora de la bebida (0-23):");
        String minuto = JOptionPane.showInputDialog(null, "Ingresa los minutos de la bebida (0-59):");
        if (hora != null && minuto != null) {
            setHoraBebida(Integer.parseInt(hora), Integer.parseInt(minuto));
        }

        // Pedir el día de la bebida
        String dia = JOptionPane.showInputDialog(null, "Ingresa el día de la bebida (día del mes):");
        String mes = JOptionPane.showInputDialog(null, "Ingresa el mes de la bebida (1-12):");
        String año = JOptionPane.showInputDialog(null, "Ingresa el año de la bebida:");
        if (dia != null && mes != null && año != null) {
            setDiaBebida(Integer.parseInt(año), Integer.parseInt(mes), Integer.parseInt(dia));
        }
        
        
    }
    
}