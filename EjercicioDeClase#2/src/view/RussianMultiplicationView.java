/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio
 */
public class RussianMultiplicationView { 
    private final Scanner scanner = new Scanner(System.in); 
    public long readNumber(String msg) { 
        while (true) { 
            try { 
                System.out.print(msg); 
                return Long.parseLong(scanner.nextLine()); 
            } catch (NumberFormatException e) { 
                System.out.println("Ingrese un número entero válido."); 
            } 
        } 
    } 
    public void showResult(long result) { 
        System.out.println("Resultado final = " + result); 
    } 
    
    public void mostrarResultado(long result) {
        JOptionPane.showMessageDialog(null, result);
    }
    
    public int leerOpcionMenu() {
        int opcion = 0;
        try {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opción del menú\n1. Multiplicacion Rusa en Consola\n2. Multiplicación Rusa por Ventanas"));
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error, ingrese un número entero");
            leerOpcionMenu();
        }
        return opcion;
    }
    
    public long leerNumero(String msg) {
        long numero = 0;
        while(true) {
            try {
                numero = Long.parseLong(JOptionPane.showInputDialog(null, msg));
                return numero;
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error, ingrese un número");
            }
        }
    }
}
