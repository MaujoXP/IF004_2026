
import java.util.Scanner;

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
        Scanner scan = new Scanner(System.in);
        int tamano = 0;

        System.out.println("Ingrese el tamaño del arreglo");
        tamano = scan.nextInt();
        int[] datos = recolectorArreglo(tamano);
        imprimirCadena(datos);
        System.out.println("Suma cadena");
        System.out.println(sumaCadena(datos));
        System.out.println("Promedio cadena");
        System.out.println(promedioCadena(datos));
        int[] minMax = minMax(datos); 
        System.out.println("Maximo cadena");
        System.out.println(minMax[1]);
        System.out.println("Minimo cadena");
        System.out.println(minMax[0]);
        int[] paresImpares = paresImpares(datos);
        System.out.println("Cantidad pares");
        System.out.println(paresImpares[0]);
        System.out.println("Cantidad impares");
        System.out.println(paresImpares[1]);
    }
    
    public static int[] recolectorArreglo(int tamano) {
        int[] arreglo = new int[tamano];
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < tamano; i++) {
            arreglo[i] = scan.nextInt();
        }
        return arreglo;
    }
    
    public static void imprimirCadena(int[] cadena) {
        for(int dato:cadena) {
            System.out.println(dato + " ");
        }
    }
    
    public static int sumaCadena(int[] cadena) {
        int total = 0;
        
        for(int i = 0; i < cadena.length; i++) {
            total += cadena[i];
        }
        
        return total;
    }
    
    public static double promedioCadena(int[] cadena) {
        double promedio = sumaCadena(cadena) / cadena.length;
        return promedio;
    }
    
    public static int[] minMax(int[] cadena) {
        int[] resultado = {cadena[0], cadena[0]};
        for(int i = 0; i < cadena.length; i++) {
            if(cadena[i] < resultado[0]) {
                resultado[0] = cadena[i];
            }
        }
        
        for(int j = 0; j < cadena.length; j++) {
            if(cadena[j] > resultado[1]) {
                resultado[1] = cadena[j];
            }
        }
        return resultado;
    }
    
    public static int[] paresImpares(int[] cadena) {
        int[] resultado = {0, 0};
        for(int i = 0; i < cadena.length; i++) {
            if(cadena[i] % 2 == 0) {
                resultado[0] += 1;
            } else {
                resultado[1] += 1;
            }
        }
        return resultado;
    }
    
}
