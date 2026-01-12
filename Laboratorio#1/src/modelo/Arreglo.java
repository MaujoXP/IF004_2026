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
public class Arreglo {
    private int[] cadena = new int[10];
    
    public Arreglo() {
        
    }
    
    /**
    * Llena el arreglo 'cadena' con números aleatorios entre 1 y 10.
    */
    public void fillArray() {
        Random random = new Random();
        for(int i = 0; i < this.cadena.length; i++) {
            this.cadena[i] = random.nextInt(10) + 1;
        }
    }
    
    /**
    * Calcula el promedio de los valores almacenados en el arreglo 'cadena'.
    *
    * @return el promedio como un valor double.
    */
    public double getAvg() {
        int suma = 0;
        double resultado = 0;
        
        for(int i = 0; i < this.cadena.length; i++) {
            suma += this.cadena[i];
        }
        
        resultado = suma / this.cadena.length;
        
        return resultado;
    }   
    
    /**
    * Ordena el arreglo 'cadena' en orden descendente utilizando el algoritmo de burbuja.
    */
    public void orderArray() {
        for(int i = 0; i < this.cadena.length - 1; i++) {
            for(int j = 0; j < this.cadena.length - 1; j++) {
                if(this.cadena[j] < this.cadena[j + 1]) {
                    int temp = this.cadena[j];
                    this.cadena[j] = this.cadena[j + 1];
                    this.cadena[j + 1] = temp;
                }
            }
        }
    }
    
     /**
     * Cuenta cuántos elementos del arreglo 'cadena' son mayores al promedio.
     *
     * @return número de elementos mayores al promedio.
     */
    public int sumMaxAvg() {
        double promedio = getAvg();
        int totalNum = 0;
        for(int i = 0; i < this.cadena.length; i++) {
            if(this.cadena[i] > promedio) {
                totalNum++;
            }
        }
        
        return totalNum;
    }
    
    /**
    * Suma los elementos opuestos del arreglo 'cadena'.
    * Ejemplo: primer elemento con el último, segundo con el penúltimo, etc.
    *
    * @return un nuevo arreglo con las sumas de los pares opuestos.
    */
    public int[] sumOpposites() {
        int[] resultado = new int[5];
        for(int i = 0; i < resultado.length; i++) {
            resultado[i] = this.cadena[i] + this.cadena[this.cadena.length - 1 - i];
        }    
                
        return resultado;
    }
    
    /**
    * Devuelve una representación en texto del arreglo 'cadena',
    * mostrando cada posición y su valor.
    *
    * @return cadena de texto con los valores del arreglo.
    */
    @Override
    public String toString() {
        String msg = "";
        for(int i = 0; i < this.cadena.length; i++) {
            msg += "Posición " + i + ": " +this.cadena[i] + "\n";
        }
        return msg;
    }
}
