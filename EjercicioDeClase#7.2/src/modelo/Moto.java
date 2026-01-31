/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Meowricio
 */
public class Moto extends Vehiculo{
    private int cilindraje;
    
    public Moto(int cantidadLlantas, int cantidadPasajeros, String color, int cilindraje) {
        super(cantidadLlantas, cantidadPasajeros, color);
        this.cilindraje = cilindraje;
    }
    
    @Override
    public void avanzar() {
        System.out.println("Giras el puño del acelerador para acelerar");
    }
    
    @Override
    public void frenar() {
        System.out.println("Presionas el pedal y manilla de freno para frenar");
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
}
