/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.JOptionPane;

/**
 *
 * @author Meowricio
 */
public class VistaClasificador {
    public int leerNumero() {
        int numero = 0;
        try {
            numero = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese un número entero positivo"));
            if(numero > 0) {
                return numero;
            }
            JOptionPane.showMessageDialog(null, "Error, ingrese un número mayor a 0");
            return leerNumero();
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error, ingrese un número entero positivo");
            return leerNumero();
        }
    }
    
    public void mostrarResultado(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
