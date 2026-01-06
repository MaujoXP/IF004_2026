package domain;

import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yahir y Mauricio
 */
public class EjercicioCuatro {
    public static void main(String args[]) {
        
        EjercicioUno ejercicioUno = new EjercicioUno(); 
        EjercicioDos ejercicioDos = new EjercicioDos(); 
        EjercicioTres ejercicioTres = new EjercicioTres();  
        
        /*
        Menú para interactuar con las clases de generar un triangulo, suma de numeros positivos y adivinar un numero entre 0 y 20        
        */
        int opcion = 0;
        while (opcion != 4){
            
         opcion = Integer.parseInt( JOptionPane.showInputDialog("Ingrese una opción\n "
                + "1: Dibujar triangulo\n"
                + "2: Suma de números\n"
                + "3: Adivinar numero\n"
                + "4: Salir" ));
         
         switch (opcion ){
             case 1: 
                 ejercicioUno.triangulo();
                 break;
                 
             case 2: 
                 ejercicioDos.sumaNumeros();
                 break;
                 
             case 3: 
                 ejercicioTres.adivinarNumero();
                 break;
         }
         if(opcion < 0 || opcion > 4){
             JOptionPane.showMessageDialog(null, "Número ingresado esta fuera del rango");
         }
        }
        
    }
}
