/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Meowricio
 */
public class Carro extends Vehiculo {
    private String transmision;
    
    public Carro(int cantidadLlantas, int cantidadPasajeros, String color, String transmision) {
        super(cantidadLlantas, cantidadPasajeros, color);
        this.transmision = transmision;
    }
    
    @Override
    public void avanzar() {
        System.out.println("Acelerando con el pedal");
    }
    
    @Override
    public void frenar() {
        System.out.println("Frenando con el pedal");
    }

    public String getTransmision() {
        return transmision;
    }

    public void setTransmision(String transmision) {
        this.transmision = transmision;
    }
}
