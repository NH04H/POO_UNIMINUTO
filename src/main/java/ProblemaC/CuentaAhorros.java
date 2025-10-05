/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaC;

/**
 *
 * @author Juan Sandoval
 */

public class CuentaAhorros extends Cuenta {
    
    public CuentaAhorros(Cliente cliente) {
        super(cliente, "Ahorros");
    }

    @Override
    public void cobrarComisionDeposito(double montoDepositado) {
        double comision = 0.0;
        
        if (montoDepositado >= 500000 && montoDepositado < 2000000) {
            comision = 3000 + (montoDepositado * 0.01); //1%
        }
        else if (montoDepositado >= 2000000 && montoDepositado <= 10000000) {
            comision = 2000 + (montoDepositado * 0.005); //0,5%
        }
        else if (montoDepositado > 10000000 && montoDepositado < 100000000) {
            comision = montoDepositado * 0.018; //1,8%
        }
        else if (montoDepositado > 100000000) {
            comision = montoDepositado * 0.02; //2%
        }
        
        this.balance -= comision;
        this.totalComisiones += comision;
        System.out.println("Comisión por Depósito es $ " + comision);
        System.out.println("Su nuevo saldo es $ " + this.balance);
    }
    
    @Override
    public void aplicarCierreMensual() {
       final double tasaAnual = 0.022; //2,2%
       
       double tasaMensual = tasaAnual / 12;
       double rendimiento = this.getBalance() * tasaMensual;
       this.balance += rendimiento;
       
       System.out.println("Rendimiento fue $ " + rendimiento);
       System.out.println("Su nuevo saldo es $ " + this.balance);      
    }

}
