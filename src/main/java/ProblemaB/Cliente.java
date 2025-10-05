/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaB;

/**
 *
 * @author Juan Sandoval
 */

public class Cliente {
    
    private String nombre;
    private int documento;
    private int alquilados;

    public Cliente(String nombre, int documento) {
        this.nombre = nombre;
        this.documento = documento;
        this.alquilados = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public int getAlquilados() {
        return alquilados;
    }

    public void setAlquilados(int alquilados) {
        this.alquilados = alquilados;
    }
    
    public void incrementarAmarres() {
        this.alquilados++;
    }
}
