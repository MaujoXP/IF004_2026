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
public class EjercicioUno {
    
    public EjercicioUno() {
        
    }
    
    /*
    * Método encargado de crear un triangulo de asteriscos de altura n 
    * @param Variable que indica la altura del triangulo
    */
    public void triangulo() {
        int n;
        String asterisco = "*";
        String resultado = "";
        
        try {
            n = Integer.parseInt( JOptionPane.showInputDialog("Ingrese un número para generar el triangulo"));
            
            for(int i = 0; i < n; i++) {
                resultado += asterisco + "\n";
                asterisco += "*";
            }
            JOptionPane.showMessageDialog(null, resultado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número entero");
            triangulo();
        }
    }
}
