/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Meowricio
 */
public abstract class Vehiculo {
    private int cantidadLlantas;
    private String color;
    private int cantidadPasajeros;
    
    public Vehiculo(int cantidadLlantas, int cantidadPasajeros, String color) {
        this.cantidadLlantas = cantidadLlantas;
        this.color = color;
        this.cantidadPasajeros = cantidadPasajeros;
    }
    
    public abstract void avanzar();
    public abstract void frenar();

    public int getCantidadLlantas() {
        return cantidadLlantas;
    }

    public String getColor() {
        return color;
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadLlantas(int cantidadLlantas) {
        this.cantidadLlantas = cantidadLlantas;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }
}
