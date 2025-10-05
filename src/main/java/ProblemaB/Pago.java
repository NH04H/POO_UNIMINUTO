/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaB;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Juan Sandoval
 */

public class Pago {
    
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.println("\n--- DATOS DEL CLIENTE ---");
        System.out.print("Ingrese su Nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese su Documento: ");
        int documento = scanner.nextInt();
        scanner.nextLine();
        
        Cliente cliente = new Cliente(nombre, documento);
        
        System.out.println("\n--- DATOS DEL BARCO ---");
        System.out.print("Ingrese su Matrícula: ");
        String matricula = scanner.nextLine();
        
        System.out.print("Ingrese su Eslora (Metros): ");
        int eslora = scanner.nextInt();
        
        System.out.print("Ingrese su Año de Fabricación: ");
        int fabricacion = scanner.nextInt();
        
        Barco barco = new Barco(matricula, eslora, fabricacion);
        
        System.out.println("\n--- DATOS DEL ALQUILER ---");
        System.out.print("Ingrese la ubicación del Amarre (A1,B2,C3): ");
        String ubicacion = scanner.nextLine();
        
        scanner.nextLine();
        System.out.print("Ingrese la Fecha de Inicio del Alquiler (YYYY-MM-DD): ");
        LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());
        
        System.out.print("Ingrese la Fecha de Fin del Alquiler (YYYY-MM-DD): ");
        LocalDate fechaFin = LocalDate.parse(scanner.nextLine());
        
        Alquiler nuevoAlquiler = new Alquiler(cliente, barco, fechaInicio, fechaFin, ubicacion);
            
        ArrayList<Alquiler> registroAlquileres = new ArrayList<>();
        registroAlquileres.add(nuevoAlquiler);
        nuevoAlquiler.calcularAlquiler(); 
        nuevoAlquiler.imprimirRecibo();
        scanner.close();
    }
}
