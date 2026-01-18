/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.JOptionPane;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class VistaMatriz {
    /**
    * Muestra un menú de opciones al usuario mediante un cuadro de diálogo.
    * 
    * El método permanece en un bucle hasta que el usuario ingrese un número válido.
    * Si el usuario ingresa un valor no numérico, se muestra un mensaje de error
    * y se vuelve a solicitar la opción.
    * 
    * @return int opción seleccionada por el usuario (entre 1 y 7).
    */
    public int showMenu() {
        String msg = "1. Llenar matriz\n"
                + "2. Imprimir\n"
                + "3. Mostrar promedio\n"
                + "4. Ordenar valores\n"
                + "5. Contar los mayores al promedio\n"
                + "6. Sumar fila\n"
                + "7. Salir";
        while(true) {
            try{
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(msg));
                return opcion;
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error, ingrese un número");
            }
        }
    }
    
    /**
    * Muestra un mensaje en un cuadro de diálogo.
    * 
    * Este método se utiliza para informar al usuario sobre eventos,
    * resultados de operaciones o mensajes personalizados.
    * 
    * @param msg mensaje que se mostrará en el cuadro de diálogo.
    */
    public void mostrarEvento(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
