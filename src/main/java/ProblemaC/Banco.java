/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaC;

import java.util.Scanner;

/**
 *
 * @author Juan Sandoval
 */

public class Banco {
    
    private static Scanner scanner = new Scanner(System.in);
    private static Cuenta cuenta1;
    private static Cuenta cuenta2;
    
    public static void main(String[] args) {
        
        Cliente cliente1 = new Cliente("Izara", "Mark", 18, null, null);
        Cliente cliente2 = new Cliente("Boris", "Mark", 16, "Toby", "Mark");
        
        cuenta1 = new CuentaCorriente(cliente1, 500000);
        cuenta2 = new CuentaAhorros(cliente2);
        
        mostrarMenu();
    }
    
    private static void mostrarMenu() {
        int opcion = 0;
        
        do {
            System.out.println("\n----- SISTEMA BANCARIO -----");
            System.out.println("============================");
            System.out.println("1. Aperturas de Cuentas");
            System.out.println("2. Transferencias");
            System.out.println("3. Cajero Automático");
            System.out.println("4. Estado de Cuenta");
            System.out.println("0. Salir");
            System.out.println("============================");
            System.out.print("Seleccione una opción: ");
            
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    case 1:
                        System.out.println("\nCuentas ya Instanciadas para la Simulación");
                        System.out.println("\nImprimiendo su Estado de Cuenta");
                        cuenta1.generarEstadoDeCuenta();
                        System.out.println("\n");
                        cuenta2.generarEstadoDeCuenta();
                        break;
                    case 2:
                        administrarTransferencias();
                        break;
                    case 3:
                        administrarCajero();
                        break;
                    case 4:
                        administrarExtractos();
                        break;
                    case 0:
                        System.out.println("Gracias por utilizar nuestros Servicios!");
                    default:
                        //System.out.println("Error: Opción invalida, inténtelo de nuevo.");
                }
            }
            
        } while (opcion != 0);
    }
    
    private static void administrarTransferencias() {
        
        System.out.println("--- Simulación Transferencias ---");
        System.out.println("Cuenta     |     Saldo");
        System.out.println(cuenta1.getTipoCuenta() + "   |     " + cuenta1.getBalance());
        System.out.println("\n");
        System.out.println(cuenta2.getTipoCuenta() + "   |     " + cuenta2.getBalance());
        
        System.out.print("Monto a transferir: $ ");
        double monto = scanner.nextDouble();
        
        cuenta1.transferir(cuenta2, monto);
    }
    
    private static void administrarCajero() {
        System.out.println("--- Simulación Retiros ---");
        System.out.print("Seleccione la Cuenta para hacer el Retiro (1 o 2): ");
        int seleccion = scanner.nextInt();
        
        Cuenta cuentaSeleccionada = (seleccion == 1) ? cuenta1 : cuenta2;
        
        System.out.print("Monto a retirar: $ ");
        double monto = scanner.nextDouble();
        
        cuentaSeleccionada.retirar(monto, true);
    }
    
    private static void administrarExtractos() {
        System.out.println("--- Cierre Mensual ---");
        System.out.println("\nCuenta 1");
        cuenta1.aplicarCierreMensual();
        cuenta1.generarEstadoDeCuenta();
        System.out.println("----------------------");
        System.out.println("\nCuenta 2");
        cuenta2.aplicarCierreMensual();
        cuenta2.generarEstadoDeCuenta();
    }
    
}
