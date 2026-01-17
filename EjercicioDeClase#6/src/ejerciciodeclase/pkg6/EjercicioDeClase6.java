/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciodeclase.pkg6;

import java.util.Scanner;

/**
 *
 * @author Gaby
 */
public class EjercicioDeClase6 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Cuantas filas tiene la matriz");
        int filas = entrada.nextInt();
        System.out.println("Cuantas columnas tiene la matriz");
        int columnas = entrada.nextInt();

        int[][] matriz = new int[filas][columnas];

        System.out.println("Matriz de " + filas + " x " + columnas);

        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                matriz[i][j] = entrada.nextInt();
            }
        }
        
        System.out.println("Imprimir matriz");
        for(int i = 0; i < filas; i++) {
            for(int j = 0; j < columnas; j++) {
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
    
}
