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
public class VistaLibro {
    
    /**
    * Muestra el menú principal y solicita al usuario una opción numérica.
    * Realiza validación para asegurar que la entrada sea un número entero.
    *
    * @return la opción seleccionada por el usuario.
    */
    public int opcionMenu() {
        String msg = "1. Agregar libro nuevo\n"
                + "2. Ver información del libro\n"
                + "3. Ver/Modificar título\n"
                + "4. Ver/Modificar autor\n"
                + "5. Ver/Modificar número de páginas\n"
                + "6. Ver/Modificar precio\n" 
                + "7. Ver/Modificar año de publicación\n"
                + "8. Calcular porciento sobre el precio\n"
                + "9. Verificar si es antiguo\n"
                + "10. Verificar si excede presupuesto\n"
                + "11. Salir";
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
    * @return el texto ingresado por el usuario.
    */
    public String pedirString() {
        String texto;
        do {
            texto = JOptionPane.showInputDialog("Ingrese el dato");
            if(texto == null || texto.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un texto válido.");
            }
        } while(texto == null || texto.trim().isEmpty());

        return texto.trim();
    }
    
    /**
    * Solicita al usuario un número entero mediante un cuadro de diálogo.
    * Realiza validación para evitar errores por entradas inválidas.
    *
    * @return el número entero ingresado por el usuario.
    */
    public int pedirInt() {
        while(true) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese el dato");
                return Integer.parseInt(input);
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número entero válido.");
            }
        }
    }
    
    /**
    * Solicita al usuario un número decimal mediante un cuadro de diálogo.
    * Valida que la entrada sea un número de tipo double.
    *
    * @return el número decimal ingresado por el usuario.
    */
    public double pedirDouble() {
        while(true) {
            try {
                String input = JOptionPane.showInputDialog("Ingrese el dato");
                return Double.parseDouble(input);
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número decimal válido.");
            }
        }
    }
    
    /**
    * Pregunta al usuario si desea modificar un dato específico del libro.
    *
    * @param nombreVariable el nombre del atributo que se desea confirmar.
    * @return JOptionPane.YES_OPTION si el usuario acepta, NO_OPTION si rechaza.
    */
    public int eleccionUsuario(String nombreVariable) {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea modificar el " + nombreVariable + "?", "Confirmación", JOptionPane.YES_NO_OPTION);
        return respuesta;
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
