/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaC;

/**
 *
 * @author Juan Sandoval
 */

public class Cliente {
    
    private String nombres;
    private String apellidos;
    private int edad;
    private String nombresRepresentante;
    private String apellidosRepresentante;

    public Cliente(String nombres, String apellidos, int edad, String nombresRepresentante, String apellidosRepresentante) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.nombresRepresentante = nombresRepresentante;
        this.apellidosRepresentante = apellidosRepresentante;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombresRepresentante() {
        return nombresRepresentante;
    }

    public void setNombresRepresentante(String nombresRepresentante) {
        this.nombresRepresentante = nombresRepresentante;
    }

    public String getApellidosRepresentante() {
        return apellidosRepresentante;
    }

    public void setApellidosRepresentante(String apellidosRepresentante) {
        this.apellidosRepresentante = apellidosRepresentante;
    }
    
    public boolean esMenorDeEdad() {
        return this.edad < 18;
    }
    
}
