/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.util.ArrayList;
import modelo.Deportista;
import modelo.Futbolista;
import modelo.Piloto;
import modelo.Tarjeta;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Main {
    public static void main(String[] args) {
        //Futbolista
        Futbolista f1 = new Futbolista("Mauricio", 173, "Defensa", 5);
        
        // Agregar tarjetas
        f1.agregarTarjeta(new Tarjeta("Amarilla"));
        f1.agregarTarjeta(new Tarjeta("Roja"));
        
        // Mostrar datos del futbolista
        System.out.println("===== FUTBOLISTA =====");
        System.out.println("Nombre: " + f1.getNombre());
        System.out.println("Estatura: " + f1.getEstatura());
        System.out.println("Posición: " + f1.getPosicion());
        System.out.println("Goles anotados: " + f1.getGolesAnotados());
        System.out.println("Salario: $" + f1.calcularSalario());

        System.out.println("Tarjetas acumuladas:");
        for (Tarjeta t : f1.getTarjetasAcumuladas()) {
            System.out.println(" - Tipo: " + t.getTipoTarjeta() + ", Fecha: " + t.getFechaAmonestacion());
        }
        
        //Piloto
        Piloto p1 = new Piloto("Carlos", 175, "A", 3);

        // Agregar victoria
        p1.agregarVictoria();

        // Mostrar datos del piloto
        System.out.println("\n===== PILOTO =====");
        System.out.println("Nombre: " + p1.getNombre());
        System.out.println("Estatura: " + p1.getEstatura());
        System.out.println("Tipo de licencia: " + p1.getTipoLicencia());
        System.out.println("Carreras ganadas: " + p1.getCarrerasGanadas());
        System.out.println("Salario: $" + p1.calcularSalario());

        //Polimorfismo
        System.out.println("\n===== POLIMORFISMO =====");

        ArrayList<Deportista> lista = new ArrayList<>();
        lista.add(f1);
        lista.add(p1);

        for (Deportista d : lista) {
            System.out.println(d.getNombre() + " gana $" + d.calcularSalario());
        }
    }
}
