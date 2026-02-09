/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package semana6_excepciones;

/**
 *
 * @author Gaby
 */
public class Semana6_Excepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Caso #1");
        double resultado1 = dividir(20, 0);
        System.out.println("El resultado es: " + resultado1);
        System.out.println("Caso #2");
        int[] notas = {90, 80, 70, 100, 60};
        int valor1 = obtenerElemento(notas, 8);
        System.out.println("El valor en esa posicion es: " + valor1);
    }
    
    public static int obtenerElemento(int[] arreglo, int indice) {
        try {
            return arreglo[indice];
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Error de indice fuera de rango");
            System.out.println("El indice recibido es: " + indice + "y el tamaño del arreglo es " + arreglo.length);
            System.out.println("Detalle del error: " + e.getMessage());
            return -1;
        } finally {
            System.out.println("Valor igual a -1 si en caso de indice fuera de rango");
        }
        
    }
    
    public static double dividir(double dividendo, double divisor) {
         try { 
            return dividendo / divisor;
         } catch(ArithmeticException excep) {
             System.out.println("Detalle del error: " + excep.getMessage());
             return 0;
         } finally {
             System.out.println("En caso de divisor igual a cero el resultado es cero");
         }
    }
    
}
