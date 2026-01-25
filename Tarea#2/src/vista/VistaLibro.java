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
public class VistaLibro {
    
    /**
    * Muestra el menú principal de la biblioteca mediante un cuadro de diálogo
    * y solicita al usuario ingresar una opción numérica.
    * 
    * El método valida que el usuario ingrese un número entero. En caso de
    * error o ingreso inválido, vuelve a solicitar la opción hasta recibir
    * una respuesta correcta.
    *
    * @return la opción seleccionada por el usuario en forma de número entero.
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
