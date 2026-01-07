package domain;

import javax.swing.JOptionPane;

/**
 *
 * @author Yahir y Mauricio
 */
public class EjercicioTres{
    
    /*
    * Metodo para adivinar un numero entre 0 y 20
    @ return retorna un mensaje pista diciendo si es mayor o menor hasta adivinarlo
    */
    public void adivinarNumero() {
        String mensaje = "";
        int aleatorio = (int) (Math.random() * 21);
        int numero;
        do {
            numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero"));
            if (aleatorio < numero) {
                mensaje = "El número es menor";
            } else if (aleatorio > numero) {
                mensaje = "El número es mayor";
            } else if (numero > 20 || numero < 0) {
                mensaje = "El número debe de ser entre 0 y 20";
            } else if (numero == aleatorio) {
                mensaje = "Adivinaste el número! El número es " + numero;
            }
            JOptionPane.showMessageDialog(null, mensaje);
        } while (numero != aleatorio);
    }
}

