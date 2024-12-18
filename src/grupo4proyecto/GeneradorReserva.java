/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo4proyecto;
import java.text.SimpleDateFormat;
import java.util.Calendar; //Importamos paquete para manejar datos tipo calendario
/**
 *
 * @author Juan Jose
 */
public class GeneradorReserva {
    //Atributos con datos enlazados a un empleado
    private String empleadoNombre = "N/A";
    private String empleadoID = "N/A";
    private int salaCine = 0;
    private String Asiento = "N/A";
    private String Pelicula = "N/A";
    private Calendar calendarCine;
    private Calendar calendarGym;
    private String tipoClase = "N/A";
    private Calendar calendarClase;
    private String Bebida = "N/A";
    private Calendar calendarBebida;
    
    //Constructor
    public GeneradorReserva(String empleadoNombre, String empleadoID, int salaCine, String Asiento, String Pelicula, 
            Calendar calendarCine, Calendar calendarGym, String tipoClase, Calendar calendarClase, String Bebida, Calendar calendarBebida) { //Aqui hay que pasar por parametros todo lo de la reserva, esto somehow tiene que quedar en el gestor de reservas
        //Guarda los datos generados en la instanciacion
        this.empleadoNombre = empleadoNombre;
        this.empleadoID = empleadoID;
        this.salaCine = salaCine;
        this.Asiento = Asiento;
        this.Pelicula = Pelicula;
        this.calendarCine = calendarCine;
        this.calendarGym = calendarGym;
        this.tipoClase = tipoClase;
        this.calendarClase = calendarClase;
        this.Bebida = Bebida;
        this.calendarBebida = calendarBebida;
        //LLamado de metodos
    }
    
    // Da formato legible a los datos de calendar
    private String calendarToString(Calendar calendar) {
        if (calendar == null) {
            return "Fecha no definida";
        }
        SimpleDateFormat fechaSimplificada = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return fechaSimplificada.format(calendar.getTime());
    }
    
    //Setters para todos los datos

    public void setEmpleadoNombre(String empleadoNombre) {
        this.empleadoNombre = empleadoNombre;
    }

    public void setEmpleadoID(String empleadoID) {
        this.empleadoID = empleadoID;
    }

    public void setSalaCine(int salaCine) {
        this.salaCine = salaCine;
    }

    public void setAsiento(String Asiento) {
        this.Asiento = Asiento;
    }

    public void setPelicula(String Pelicula) {
        this.Pelicula = Pelicula;
    }

    public void setCalendarCine(Calendar calendarCine) {
        this.calendarCine = calendarCine;
    }

    public void setCalendarGym(Calendar calendarGym) {
        this.calendarGym = calendarGym;
    }

    public void setTipoClase(String tipoClase) {
        this.tipoClase = tipoClase;
    }

    public void setCalendarClase(Calendar calendarClase) {
        this.calendarClase = calendarClase;
    }

    public void setBebida(String Bebida) {
        this.Bebida = Bebida;
    }

    public void setCalendarBebida(Calendar calendarBebida) {
        this.calendarBebida = calendarBebida;
    }
    
    //Getters para todos los datos

    public String getEmpleadoNombre() {
        return empleadoNombre;
    }

    public String getEmpleadoID() {
        return empleadoID;
    }

    public int getSalaCine() {
        return salaCine;
    }

    public String getAsiento() {
        return Asiento;
    }

    public String getPelicula() {
        return Pelicula;
    }

    public String getCalendarCine() {
        return calendarToString(calendarCine);
    }

    public String getCalendarGym() {
        return calendarToString(calendarGym);
    }

    public String getTipoClase() {
        return tipoClase;
    }

    public String getCalendarClase() {
        return calendarToString(calendarClase);
    }

    public String getBebida() {
        return Bebida;
    }

    public String getCalendarBebida() {
        return calendarToString(calendarBebida);
    }
}