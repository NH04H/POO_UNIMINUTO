/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaC;

/**
 *
 * @author Juan Sandoval
 */

public class CuentaCorriente extends Cuenta {
    
    private final double montoMinimo = 200000; 
    
    public CuentaCorriente(Cliente cliente, double montoInicial) {
        super(cliente, "Corriente");
        
        if (montoInicial >= montoMinimo) {
            this.balance = montoInicial;
            System.out.println("Su nueva Cuenta Corriente fue aperturada con éxito! Su saldo inicial es " + this.balance);
        }
        else {
            this.balance = 0.0;
            System.out.println("Error: Fondos insuficientes para abrir su Cuenta Corriente.");
        }
    }

    @Override
    public void cobrarComisionDeposito(double montoDepositado) {
        double comision = 0.0;
        
        if (montoDepositado < 500000) {
            comision = 7000;
        }
        else if (montoDepositado >= 500000 && montoDepositado < 2000000) {
            comision = 5000 + (montoDepositado * 0.02); //2%
        }
        else if (montoDepositado >= 2000000 && montoDepositado <= 10000000) {
            comision = 4000 + (montoDepositado * 0.02); //2%
        }
        else if (montoDepositado > 10000000) {
            comision = montoDepositado * 0.033; //3,3%
        }
        
        this.balance -= comision;
        this.totalComisiones += comision;
        System.out.println("Comisión por Depósito es $ " + comision);
        System.out.println("Su nuevo saldo es $ " + this.balance);
    }

    @Override
    public void aplicarCierreMensual() {
       final double tasaMensual = 0.015;
       
       double cobroMantenimiento = this.getBalance() * tasaMensual;
       this.balance -= cobroMantenimiento;
       this.totalComisiones += cobroMantenimiento;
       
       System.out.println("Comisión por Mantenimiento es $ " + tasaMensual);
       System.out.println("Su nuevo saldo es $ " + this.balance);
    }
    
    public void cobrarUsoCheque() {
       final double cobroCheque = 3000;
       
       this.balance -= cobroCheque;
       this.totalComisiones += cobroCheque;
       
       System.out.println("Comisión por emitir Cheque es $ " + cobroCheque);
    }

}
