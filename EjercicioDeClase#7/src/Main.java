/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gaby
 */
public class Main {
    public static void main(String args[]) {
        Animal[] animales = new Animal[4];
        Gato miel = new Gato("Miel", 5, "Naranja");
        Gato michu = new Gato("Michu", 7, "Naranja y Blanco");
        
        Perro sasha = new Perro("Sasha", 4, "Zaguate");
        Perro maya = new Perro("Maya", 2, "Zaguate");
        animales[0] = michu;
        animales[1] = miel;
        animales[2] = sasha;
        animales[3] = maya;
        for(Animal i:animales) {
            System.out.println(i.getNombre());
            System.out.println(i.getEdad());
            System.out.println(i.hacerSonido());
        }
        
    }
}
