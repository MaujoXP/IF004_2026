/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mauricio León B C5G444
 */
public class MemoriaInt {
    public Integer a; 
    public static void main(String[] args) {
        //Los datos primitivos se almacenan en la memoria stack, apuntan directamente
        //al dato numérico, por lo que compara los datos
        int a = 500;
        int b = 500;
        if(a == b) {
            System.out.println("Son iguales a y b");
        } else {
            System.out.println("No son iguales a y b");
        }
        
        //Apuntan a objetos de memoria, al ser distintos la comparación es falsa
        Integer c = 500;
        Integer d = 500;
        if(a == b) {
                System.out.println("Son iguales c y d");
        } else {
            System.out.println("No son iguales c y d");
        }
        
        //Entre -127 y 128 se guarda en Integer Cache al ser un número pequeño
        //provoca que guarden la misma dirección de memoria (Integer cache)
        Integer e = 100;
        Integer f = 100;
        if(e == f) {
                System.out.println("Son iguales e y f");
        } else {
            System.out.println("No son iguales e y f");
        }
        
        //Se fuerza a crear un objeto (apuntan a distintos puntos de memoria)
        Integer h = new Integer(100);
        Integer i = new Integer(100);
        if(h.equals(i)) {
                System.out.println("Son iguales h y i");
        } else {
            System.out.println("No son iguales h y i");
        }
        
        //Asigna el mismo puntero de memoria a ambos
        MemoriaInt mem1 = new MemoriaInt();
        MemoriaInt mem2 = mem1;
        mem1.a = 1000;
        
        //Sobre escribe el valor de porque apunta al mismo OBJ
        mem2.a = 5000;
        System.out.println(mem1.a);
        System.out.println(mem2.a);
        
        //Apuntan a distintos punteros de memoria por lo que siempre es falsa la comparacion
        //a pesar que tengan el mismo contenido
        MemoriaInt mem3 = new MemoriaInt();
        MemoriaInt mem4 = new MemoriaInt();
        mem3.a = 1000;
        mem4.a = 1000;
        if(mem4.a == mem3.a) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }
        
        //Equals apuntan a memoria de objetos, no a su contenido
        if(mem4.equals(mem3)) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }
    }
}
