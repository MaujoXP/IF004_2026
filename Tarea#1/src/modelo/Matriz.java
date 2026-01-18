/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Random;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Matriz {
    private int[][] matriz = new int[5][5];
    
    public Matriz() {
        
    }
    
    /**
     * Llena la matriz con valores aleatorios entre 1 y 10.
     */
    public void fillMatrix() {
        Random random = new Random();
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                this.matriz[i][j] = random.nextInt(10) + 1;
            }
        } 
    }
    
    /**
     * Calcula el promedio de todos los elementos de la matriz.
     *
     * @return el promedio como valor double
     */
    public double getAvg() {
        int contador = 0;
        int suma = 0;
        for(int i = 0; i < matriz.length; i++) {
            for(int j = 0; j < matriz[i].length; j++) {
                contador++;
                suma += matriz[i][j];
            }
        }
        double resultado = suma / contador;
        return resultado;
    }
    
    /**
     * Ordena cada fila de la matriz en orden ascendente
     * utilizando el algoritmo de burbuja.
     */
    public void orderMatrix() {
        for (int i = 0; i < matriz.length; i++) {
            for (int k = 0; k < matriz[i].length - 1; k++) {
                for (int j = 0; j < matriz[i].length - 1 - k; j++) {
                    if (matriz[i][j] > matriz[i][j + 1]) {
                        int temp = matriz[i][j];
                        matriz[i][j] = matriz[i][j + 1];
                        matriz[i][j + 1] = temp;
                    }
                }
            }
        }
    }

    /**
     * Cuenta cuántos elementos de la matriz son mayores
     * que el promedio calculado con getAvg().
     *
     * @return número de elementos mayores al promedio
     */
    public int countMaxAvg() {
        double promedio = getAvg();
        int totalNum = 0;
        for(int i = 0; i < this.matriz.length; i++) {
            for(int j = 0; j < this.matriz[i].length; j++) {
                if(this.matriz[i][j] > promedio) {
                    totalNum++;
                }
            }
        }
        
        return totalNum;
    }
    
    /**
     * Calcula la suma de cada fila de la matriz.
     *
     * @return un arreglo de enteros donde cada posición
     *         corresponde a la suma de una fila
     */
    public int[] sumRows() {
        int[] resultado = new int[this.matriz.length];
        for(int i = 0; i < this.matriz.length; i++) {
            int sumaFila = 0;
            for(int j = 0; j < this.matriz[i].length; j++) {
                sumaFila += this.matriz[i][j];
            }
            resultado[i] = sumaFila;
        }
        
        return resultado;
    }
    
    /**
    * Devuelve una representación en cadena de la matriz.
    * Cada fila se imprime en una línea separada, mostrando
    * los valores de sus columnas.
    *
    * @return una cadena con el contenido de la matriz
    *         en formato tabular
    */
    @Override
    public String toString() {
        String msg = "";
        for(int i = 0; i < this.matriz.length; i++) {
            for(int j = 0; j < this.matriz[i].length; j++) {
                msg += "Posición[" + i + "][" + j + "]: " + this.matriz[i][j] + "\n";
            }
        }
        return msg;
    }
}
