/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Bicicleta;
import modelo.Carro;
import modelo.Moto;

/**
 *
 * @author Meowricio
 */
public class Main {
     public static void main(String[] args) {

        Moto moto = new Moto(2, 2, "Negro", 200);
        Carro carro = new Carro(4, 5, "Rojo", "Manual");
        Bicicleta bici = new Bicicleta(2, 1, "Azul", "Freno de disco");

        System.out.println("=== MOTO ===");
        moto.avanzar();
        moto.frenar();
        System.out.println("Cilindraje: " + moto.getCilindraje());

        System.out.println("\n=== CARRO ===");
        carro.avanzar();
        carro.frenar();
        System.out.println("Transmisión: " + carro.getTransmision());

        System.out.println("\n=== BICICLETA ===");
        bici.avanzar();
        bici.frenar();
        System.out.println("Tipo de frenado: " + bici.getTipoFrenado());
    }
}
