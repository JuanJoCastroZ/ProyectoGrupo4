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
public class Empleado {
    //Atributos
    private String empleadoNombre = "";
    private String empleadoID = ""; 
    //Metodo constructor
    public Empleado()
    {
        
        //Llama metodos
        String Nombre = JOptionPane.showInputDialog("Introducir nombre del empleado:");
        String ID = JOptionPane.showInputDialog("Introducir ID del empleado:");
        setEmpleadoNombre(Nombre);
        setEmpleadoID(ID);
    }
    
    //Getters y Setter
    public String getEmpleadoNombre() {
        return empleadoNombre;
    }

    public void setEmpleadoNombre(String empleadoNombre) {
        this.empleadoNombre = empleadoNombre;
    }

    public String getEmpleadoID() {
        return empleadoID;
    }

    public void setEmpleadoID(String empleadoID) {
        this.empleadoID = empleadoID;
    }
    //Metodos
}
