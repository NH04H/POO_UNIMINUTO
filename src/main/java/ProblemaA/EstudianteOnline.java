/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaA;

/**
 *
 * @author Juan Sandoval
 */

public class EstudianteOnline extends Estudiante {
 
    private static final double matricula = 1500;
    private static final double incremento = 0.05;

    public EstudianteOnline(String nombres, String apellidos, int documento, String telefono, String direccion, String carrera, int semestre) {
        super(nombres, apellidos, documento, telefono, direccion, carrera, semestre);
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
    
    @Override
    public void calcularCosto() {
        this.costo = matricula;
        
        if (semestre >= 5) {
            double aumento = costo * incremento;
            this.costo += aumento;
        }
    }
}
