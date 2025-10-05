/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaB;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Duration;

/**
 *
 * @author Juan Sandoval
 */

public class Alquiler {
    
    private Cliente cliente;
    private Barco barco;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String ubicacion;
    private double costo;
    
    
    private static final double dia = 25000;
    private static final double impuestos = 0.16;

    public Alquiler(Cliente cliente, Barco barco, LocalDate fechaInicio, LocalDate fechaFin, String ubicacion) {
        this.cliente = cliente;
        this.barco = barco;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ubicacion = ubicacion;
        this.cliente.incrementarAmarres();
    }
    
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public int calcularDias() {
        long diasAlquier = Duration.between(fechaInicio.atStartOfDay(), fechaFin.atStartOfDay()).toDays();
        return Long.valueOf(diasAlquier).intValue(); 
    }
    
    public void calcularAlquiler() {
        int dias = calcularDias();
        int modulo = barco.moduloEslora();

        double diario = dia + modulo;
        double total = dias * diario * (1 + impuestos);
        
        this.costo = total;
    }
    
    public void imprimirRecibo() {
        
        DecimalFormat df = new DecimalFormat("#.##");
        
        System.out.println("\n--- RECIBO DE PAGO ---");
        System.out.println("Cliente: " + cliente.getNombre() + " | Documento: " + cliente.getDocumento());
        System.out.println("Barco: Matricula " + barco.getMatricula() + " | Eslora: " + barco.getEslora() + 
                           " Metros | Año de Fabricación: " + barco.getFabricacion());
        System.out.println("Fecha de Inicio: " + this.fechaInicio + " | Fecha de Fin: " + this.fechaFin);
        System.out.println("Días de Alquiler: " + this.calcularDias());
        System.out.println("Valor del Alquiler: $ " + df.format(this.costo));
        System.out.println("------------------------");
    }

}
