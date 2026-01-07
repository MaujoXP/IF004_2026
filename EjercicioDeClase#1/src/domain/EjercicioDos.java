/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import javax.swing.JOptionPane;

/**
 *
 * @author Yahir y Mauricio
 */
public class EjercicioDos {
    
    public EjercicioDos() {
    
    }
    
    /*
    * Método encargado de sumar números enteros positivos hasta que se ingrese uno negativo
    * @return Suma total de los números ingresados menos el último negativo ingresado
    */
    public void sumaNumeros() {
        int n = 0;
        int resultado = 0;
        
        while(n >= 0) {
            try {
                n = Integer.parseInt( JOptionPane.showInputDialog("Ingrese un número entero positivo")); 
                if(n >= 0) {
                   resultado += n; 
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese un número entero");
            }
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}
