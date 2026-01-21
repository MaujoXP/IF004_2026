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
    
    /**
    * Muestra el menú inicial del juego y gestiona la selección del usuario.
    * 
    * Este método genera una nueva palabra para la partida, inicializa los
    * intentos y presenta las opciones del menú principal. Según la elección 
    * del jugador, puede iniciar una nueva partida, continuar usando las palabras 
    * ya adivinadas, mostrar el estado actual del juego o salir.
    */
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
    
    /**
    * Ejecuta una partida del juego del ahorcado usando la palabra indicada.
    * 
    * El método muestra el progreso del jugador, solicita letras y detiene 
    * el ciclo cuando el jugador haya ganado o perdido. Si la palabra es 
    * adivinada correctamente, se agrega al registro de palabras correctas.
    *
    * Además, si el jugador adivina 5 palabras diferentes, se muestra un mensaje 
    * de victoria final y se reinicia el contador de palabras adivinadas.
    *
    * @param palabra la palabra que debe ser adivinada durante la partida.
    */
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
