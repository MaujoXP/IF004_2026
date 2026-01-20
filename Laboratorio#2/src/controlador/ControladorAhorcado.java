/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Ahorcado;
import vista.VistaAhorcado;

/**
 *
 * @author Meowricio
 */
public class ControladorAhorcado {
    private Ahorcado modelo;
    private VistaAhorcado vista;
    
    public ControladorAhorcado(Ahorcado modelo, VistaAhorcado vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void inicio() {
        int victorias = modelo.getGuessedWords().length;
        while(victorias < 5) {
            String palabra = modelo.generateNewWord();
            modelo.startNewGame(palabra, 5);
            String estado = modelo.gameStatus();
            vista.mostrarEvento(estado);
            vista.mostrarEvento("¿LISTO?");
            
            while(!modelo.isWon() && !modelo.isLost()) {
                String msg = modelo.getMaskedWord();
                vista.mostrarEvento(msg);

                char intento = vista.solicitarCaracter();
                modelo.guess(intento);

                // 🚨 verificar inmediatamente después del intento
                if (modelo.isLost()) {
                    break; // ya no pedir otra letra
                }
                
            }
            
            if(modelo.isWon()) {
                victorias++;
                modelo.addWordGuessed(palabra);
            }
        }
        
    }
    
}
