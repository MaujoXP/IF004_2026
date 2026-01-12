
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
        int[] arregloOrdenado = ordenamientoBurbuja(datos);
        for(int dato:arregloOrdenado) {
            System.out.println("Dato: " + dato);
        }
    }
    
    public static int[] recolectorArreglo(int tamano) {
        int[] arreglo = new int[tamano];
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < tamano; i++) {
            System.out.println("Ingrese el dato " + i);
            arreglo[i] = scan.nextInt();
        }
        return arreglo;
    }
    
    public static int[] ordenamientoBurbuja(int[] arreglo) {
        for(int i = 0; i < arreglo.length - 1; i++) {
            for(int j = 0; j < arreglo.length - 1; j++) {
                if(arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
        return arreglo;
    }
}
