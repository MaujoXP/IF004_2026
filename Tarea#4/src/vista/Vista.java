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
public class Vista {
    
    /**
    * Muestra el menú principal mediante un cuadro de diálogo y solicita al
    * usuario que ingrese una opción numérica. Si el usuario ingresa un valor
    * inválido, se le solicita nuevamente hasta que se ingrese un número válido.
    *
    * @return la opción seleccionada por el usuario como un número entero
    */
    public int opcionMenu() {
        String msg = "1. Crear Curso\n"
                + "2. Crear Estudiante\n"
                + "3. Crear Profesor\n"
                + "4. Matricular Estudiante a un Curso\n"
                + "5. Asignar Curso a Profesor\n"
                + "6. Desmatricular Curso a un Estudiante\n"
                + "7. Desasignar Curso a Profesor\n"
                + "8. Mostrar datos de Estudiantes\n"
                + "9. Mostrar datos de Profesores\n"
                + "10. Salir";
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
    * Solicita al usuario un texto mediante un cuadro de diálogo.
    * Repite la solicitud hasta recibir una entrada válida y no vacía.
    *
    * @param dato Nombre del dato que se solicita
    * @return el texto ingresado por el usuario.
    */
    public String pedirString(String dato) {
        String texto;
        do {
            texto = JOptionPane.showInputDialog("Ingrese " + dato);
            if(texto == null || texto.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un texto válido.");
            }
        } while(texto == null || texto.trim().isEmpty());

        return texto.trim();
    }
    
    /**
    * Solicita al usuario un número entero mediante un cuadro de diálogo.
    * Realiza validación para evitar errores por entradas inválidas.
    * @param dato Nombre del dato que se solicita
    * @return el número entero ingresado por el usuario.
    */
    public int pedirInt(String dato) {
        while(true) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese " + dato);
                return Integer.parseInt(input);
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número entero válido.");
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
