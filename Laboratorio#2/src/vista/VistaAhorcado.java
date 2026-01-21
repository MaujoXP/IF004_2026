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
public class VistaAhorcado {
    
    /**
    * Muestra un menú de opciones al usuario mediante un cuadro de diálogo.
    * 
    * El método permanece en un bucle hasta que el usuario ingrese un número válido.
    * Si el usuario ingresa un valor no numérico, se muestra un mensaje de error
    * y se vuelve a solicitar la opción.
    * 
    * @return int opción seleccionada por el usuario (entre 1 y 7).
    */
    public int opcionMenu() {
        String msg = "1. Iniciar nueva partida\n"
                + "2. Continuar partida\n"
                + "3. Mostrar estadisticas actuales\n"
                + "4. Salir";
        while(true) {
            try{
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(msg));
                return opcion;
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error, ingrese un número");
            }
        }
    }

    public char solicitarCaracter() {
        String msg = "Ingrese un carácter para adivinar";

        while (true) {
            try {
                String input = JOptionPane.showInputDialog(msg);

                if (input == null) {
                    JOptionPane.showMessageDialog(null, "Debe ingresar un caracter");
                    continue;
                }

                input = input.trim();

                if (input.length() != 1) {
                    JOptionPane.showMessageDialog(null, "Ingrese solo una letra");
                    continue;
                }

                char opcion = Character.toUpperCase(input.charAt(0));
                return opcion;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
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
