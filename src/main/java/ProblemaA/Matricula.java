/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaA;

import java.util.Scanner;

/**
 *
 * @author Juan 
 */

public class Matricula {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static Estudiante crearEstudiante() {
        
        System.out.println("\n--- DATOS DEL ESTUDIANTE ---");
        System.out.print("Ingrese sus Nombres: ");
        String nombres = scanner.nextLine();
        
        System.out.print("Ingrese sus Apellidos: ");
        String apellidos = scanner.nextLine();
        
        System.out.print("Ingrese su Documento: ");
        int documento = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Ingrese sus Teléfono: ");
        String telefono = scanner.nextLine();
        
        System.out.print("Ingrese sus Dirección: ");
        String direccion = scanner.nextLine();
        
        System.out.println("\n--- DATOS DE LA CARRERA ---");
        System.out.println("Carreras Disponibles 2026-1:");
        System.out.println("1. Programación");
        System.out.println("2. Sistemas");
        System.out.println("3. Inglés");
        
        System.out.print("Ingrese el número de la Carrera de su interés: ");
        int seleccion = scanner.nextInt();
        String carrera = switch (seleccion) {
            case 1 -> "Programación";
            case 2 -> "Sistemas";
            case 3 -> "Inglés";
            default -> "Inténtelo de nuevo...";
        };
        
        System.out.print("Ingrese su Semestre Actual: ");
        int semestre = scanner.nextInt();
        
        System.out.println("¿Tomará las Clases en Línea?");
        System.out.println("1. Si");
        System.out.println("2. No");
        
        System.out.print("Ingrese el número de su interés: ");
        int modalidad = scanner.nextInt();
        
        Estudiante estudiante;
        
            if (modalidad == 1) {
                estudiante = new EstudianteOnline(nombres, apellidos, documento, telefono, direccion, carrera, semestre);
            }
            else {
                System.out.print("Ingrese el número de Créditos de este Semestre: ");
                int creditosSemestre = scanner.nextInt();
                System.out.print("Ingrese el número de Créditos Aplazados (Si Aplica): ");
                int creditosAplazados = scanner.nextInt();

                estudiante = new EstudianteRegular(nombres, apellidos, documento, telefono, direccion, carrera, semestre,
                                                   creditosSemestre, creditosAplazados);
            }
        
        return estudiante;
        
    }
    
    public static void main(String[] args) {
        
        Estudiante nuevoEstudiante = crearEstudiante();
        nuevoEstudiante.calcularCosto(); 
        nuevoEstudiante.generarRecibo();
        scanner.close();
    }
}
