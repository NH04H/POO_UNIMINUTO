/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaA;

/**
 *
 * @author Juan Sandoval
 */

public class EstudianteRegular extends Estudiante {
 
    private int creditosAplazados;
    private int creditosSemestre;

    public EstudianteRegular(String nombres, String apellidos, int documento, String telefono, String direccion, String carrera, int semestre, int creditosSemestre, int creditosAplazados) {
        super(nombres, apellidos, documento, telefono, direccion, carrera, semestre);
        this.creditosAplazados = creditosAplazados;
        this.creditosSemestre = creditosSemestre;
    }

    private double calcularCostoCredito() {
        if (semestre >= 1 && semestre <= 3) {
            return 20.0;
        } else if (semestre >= 4 && semestre <= 6) {
            return 25.0;
        } else {
            return 30.0;
        }
    }
    
    @Override
    public void calcularCosto() {
        double costoCredito = calcularCostoCredito();
        
        double costoSemestre = creditosSemestre * costoCredito;
        double costoAplazados = creditosAplazados * costoCredito;
        
        this.costo = costoSemestre + costoAplazados;
    }
}
