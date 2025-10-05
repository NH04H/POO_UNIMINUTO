/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaA;

/**
 *
 * @author Juan Sandoval
 */

public abstract class Estudiante extends Persona {
    
    protected String carrera;
    protected int semestre;
    protected double costo;

    public Estudiante(String nombres, String apellidos, int documento, String telefono, String direccion, String carrera, int semestre) {
        super(nombres, apellidos, documento, telefono, direccion);
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    public abstract void calcularCosto();
    
    public void generarRecibo() {
        System.out.println("\n--- RECIBO DE LA INSCRIPCIÓN ---");
        System.out.println("Estudiante: " + getNombres() + " " + getApellidos());
        System.out.println("Documento: " + getDocumento());
        System.out.println("Carrera: " + carrera + " | Semestre: " + semestre);
        System.out.println("Costo de la Matrícula: " + costo + " USD");
        System.out.println("-------------------------------");
    }
    
}
