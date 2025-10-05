/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaC;

/**
 *
 * @author Juan Sandoval
 */

public abstract class Cuenta {
    
    private Cliente cliente;
    private String tipoCuenta;
    protected double balance;
    protected double totalComisiones;

    public Cuenta(Cliente cliente, String tipoCuenta) {
        this.cliente = cliente;
        this.tipoCuenta = tipoCuenta;
        this.balance = 0.0;
        this.totalComisiones = 0.0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void depositar(double monto) {
        if (monto > 0) {
            this.balance += monto;
            
            this.cobrarComisionDeposito(monto);
            
            System.out.println("Depósito realizado con éxito, su nuevo saldo es $ " + this.balance);
        }
    }

    public void transferir(Cuenta destino, double monto) {
        if (this.balance >= monto) {
            this.balance -= monto;
            
            destino.depositar(monto);
            this.cobrarComisionDeposito(monto);
            System.out.println("Trasferencia realizada con éxito, su nuevo saldo es $ " + this.balance);
        }
        else {
            System.out.println("Error: Fondos insuficientes para realizar esta Transferencia.");
        }
    }
    
    public boolean retirar(double monto, boolean esCajeroPropio) {
        if (monto <= 0 || monto > this.balance) {
            System.out.println("Error: Fondos insuficientes para realizar este Retiro.");
            return false;
        }
        
        this.balance -= monto;
        
        if (!esCajeroPropio) {
            final double comisionCajeroAjeno = 4500;
            this.balance -= comisionCajeroAjeno;
            System.out.println("Comisión por Cajero Ajeno es $ " + comisionCajeroAjeno);
        }
        System.out.println("Retiro realizado con éxito, su nuevo saldo es $ " + this.balance);
        return true;
    }
    
    public void cobrarComisionDeposito(double montoDepositado) {
        
    }
        
    public void aplicarCierreMensual() {
        
    }
    
    public void generarEstadoDeCuenta() {
        System.out.println("----- ESTADO DE CUENTA -----");
        System.out.println("Titular: " + cliente.getNombres() + " " + cliente.getApellidos());
        if (cliente.esMenorDeEdad()) {
            System.out.println("Representante: " + cliente.getNombresRepresentante() + " " + cliente.getApellidosRepresentante());
        }
        System.out.println("Tipo de Cuenta: " + tipoCuenta);
        System.out.println("--- Resumen de Movimientos ---");
        System.out.println("Cobros por Comisiones - $ " + totalComisiones);
        //System.out.println("Rendimientos ---------- $ " + rendimiento);
        System.out.println("Saldo Final: ---------- $ " + this.balance);
        System.out.println("============================");
        
        this.totalComisiones = 0.0;
    }
}
