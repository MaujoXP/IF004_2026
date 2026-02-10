/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mauricio León B C5G444
 */
public class MemoriaString {
    public static void main(String[] args) {
        //Se almacenan en la String pool, por lo que los String apuntan a la misma dirección de memoria
        String a = "Hola mundo";
        String b = "Hola mundo";
        if(a == b) {
            System.out.println("Son iguales a y b");
        } else {
            System.out.println("No son iguales a y b");
        }
        
        //Se fuerza a crear un objeto, apuntando a regiones de memoria distintas
        String c = new String("Hola mundo");
        String d = new String("Hola mundo");
        if(c == d) {
            System.out.println("Son iguales c y d");
        } else {
            System.out.println("No son iguales c y d");
        }
        
        //Se fuerza a crear un objeto, pero el metodo equals compara valores, no donde apunta la memoria
        String e = new String("Hola mundo");
        String f = new String("Hola mundo");
        if(c.equals(f)) {
            System.out.println("Son iguales e y f");
        } else {
            System.out.println("No son iguales e y f");
        }
    }
}
