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
    
    public void menuInicio() {
        String palabra = modelo.generateNewWord();
        modelo.startNewGame(palabra, 5);
        
        int opcion = vista.opcionMenu();
        switch (opcion) {
            case 1:
                modelo.resetGuessedWords();
                partida(palabra);
                break;
            case 2:
                partida(palabra);
                break;
            case 3:
                String estado = modelo.gameStatus();
                vista.mostrarEvento(estado);
                menuInicio();
                break;
            case 4:
                break;
            default:
                menuInicio();
                break;
        }
    }
    
    public void partida(String palabra) {
        int victorias = modelo.getGuessedWords().length;
        vista.mostrarEvento("¿LISTO?");
        
        while(true) {
            String msg = modelo.getMaskedWord();
            vista.mostrarEvento(msg);
            if (modelo.isWon() || modelo.isLost()) {
                break;
            }
            char intento = vista.solicitarCaracter();
            modelo.guess(intento);

        }
        if(modelo.isWon()) {
            victorias++;
            modelo.addWordGuessed(palabra);
            if(victorias == 5) {
                String mensajeVictoria = "Has ganado\n" + modelo.getVictoryMessage();
                vista.mostrarEvento(mensajeVictoria);
                modelo.resetGuessedWords();
            }
        }
        menuInicio();
    }
    
}
