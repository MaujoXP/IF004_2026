/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Meowricio
 */
public class Ahorcado {
    private String words = "CARIBE & PLAYA & CULTURA & AFRODESCENDIENTE & MUSICA & CALIPSO & REGGAE & "
            + "CARNAVAL & PUERTO & BANANO & CACAO & TURISMO & BIODIVERSIDAD & SELVA & LLUVIA & CALOR & MAR "
            + "& CORAL & ARRECIFE & TORTUGUERO & CAHUITA & PUERTO VIEJO & NATURALEZA & FAUNA & FLORA & RIOS "
            + "& CANALES & PESCA & COMERCIO & HISTORIA & IDENTIDAD & TRADICION & PLAYA BONITA & HOSPITALIDAD "
            + "& IDIOMAS & INGLES CRIOLLO & MANZANILLO & CIENEGUITA & PUNTA UVA & RITMO & SABOR & COMIDA & "
            + "COCO & RICE AND BEANS & FERROCARRIL & PATI & RONDON & DEPORTE & FUTBOL & MOIN & SURF & "
            + "ECONOMIA & CALIPSO & MIGRACION & DIVERSIDAD & DIA DEL NEGRO & SIQUIRRES & GUAPILES & HERENCIA "
            + "& PAISAJE & COSTA & MANGLAR & TORTUGA & TAMBORES & BAILE & ALEGRIA & RESILIENCIA & TRADICIONES "
            + "& IDENTIDAD CARIBEÑA & TURISMO SOSTENIBLE & PAN BON & PLAYA COCLES & PAYASOS & SOL & ARENA & "
            + "BRISA & ESPERANZA & CONVIVENCIA"; 
    private char[] word;
    private char[] letters;
    private int attempts;
    private String guessedWords = "";
    private final String AHORCADO_VICTORIA= """
                                            \\o/
                                              |
                                             / \\
                                              """;
    private final String[] AHORCADO = {"""
    PERDISTE:P
    _________
    |  |
    |  X
    |
    |
    =========""","""
    _________
    |  |
    |  0
    |
    |
    =========""","""
    _________
    |  |
    |  0
    | /|
    |
    =========""","""
    _________
    |  |
    |  0
    | /|\\
    |
    =========""","""
    _________
    |  |
    |  0
    | /|\\
    | /
    =========""", """
    _________
    |  |
    |  0
    | /|\\
    | / \\
    ========="""};
                                    
    
    public Ahorcado() {
        
    }
    
    /**
    * Obtiene una palabra aleatoria del conjunto de palabras disponibles.
    * 
    * @return un arreglo de caracteres que representa la palabra seleccionada.
    */
    private char[] getRandomWord() {
        String[] palabras = words.trim().split(" & ");
        Random rdm = new Random();
        int indice = rdm.nextInt(palabras.length);
        char[] palabra = palabras[indice].toCharArray();
        
        return palabra;  
    }
    /**
    * Procesa un intento del jugador verificando si la letra pertenece
    * a la palabra objetivo.
    *
    * @param letter letra ingresada por el jugador.
    * @return true si la letra está en la palabra, false en caso contrario.
    */
    public boolean guess(char letter) {
        boolean acierto = false;
        for(int i = 0; i < this.word.length; i++) {
            if(this.word[i] == letter) {
                acierto = true;
            }
        }
        addLetter(letter);
        
        if(!acierto) {
            this.attempts--;
        }
        return acierto;
    }
    /**
    * Genera una versión de la palabra con letras adivinadas visibles
    * y letras no encontradas como guiones bajos. Incluye también 
    * información del ahorcado, letras intentadas y los intentos restantes.
    *
    * @return cadena con el estado actual de la palabra.
    */
    public String getMaskedWord() {
        StringBuilder msg = new StringBuilder();
        msg.append(this.AHORCADO[this.attempts] + "\n");
        
        for(int i = 0; i < this.word.length; i++) {
            if(this.word[i] == ' ') {
                    msg.append(" ");
                    continue;
            }
            boolean encontrada = false;
            for(int j = 0; j < this.letters.length; j++) {
                if(this.word[i] == this.letters[j]) {
                    msg.append(this.letters[j]);
                    encontrada = true;
                    break;
                }
            }
            if(!encontrada) {
                msg.append("_");
            }
        }
        msg.append("\nLetras intentadas: ");
        for(char letras:this.letters) {
            msg.append(letras);
        }
        
        msg.append("\nIntentos restantes: " + this.attempts);
        
        return msg.toString();
    }
    
    /**
    * Verifica si el jugador ha adivinado completamente la palabra.
    *
    * @return true si todas las letras han sido encontradas, false si falta alguna.
    */
    public boolean isWon() {
        boolean[] encontrados = new boolean[this.word.length];
        boolean gano = false;
        
        for(int i = 0; i < this.word.length; i++) {
            for(int j = 0; j < this.letters.length; j++) {
                if(this.word[i] == ' ') {
                    encontrados[i] = true;
                    continue;
                }
                if(this.word[i] == this.letters[j]) {
                    encontrados[i] = true;
                    break;
                }
            }
        }
        
        for(boolean encontrado:encontrados) {
            if(!encontrado) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
    * Verifica si el jugador ha perdido el juego.
    * La derrota ocurre solo si no ha ganado y los intentos llegan a 0.
    *
    * @return true si el jugador ha perdido, false en caso contrario.
    */
    public boolean isLost() {
        if(isWon()) {
            return false;
        }
        else if(this.attempts <= 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
    * Genera una nueva palabra para la siguiente ronda, evitando aquellas
    * que ya hayan sido adivinadas previamente.
    *
    * @return la nueva palabra seleccionada.
    */

    public String generateNewWord() {
        String palabra = new String(getRandomWord());
        String[] palabrasAdivinadas = getGuessedWords();
        for(String palabras:palabrasAdivinadas) {
            if(palabra.equals(palabras))
                return generateNewWord();
        }
        
        this.letters = new char[0];
        return palabra;
    }
    
    /**
    * Inicia una nueva partida configurando una nueva palabra
    * y la cantidad máxima de intentos.
    *
    * @param word palabra que debe adivinarse.
    * @param maxAttempts número máximo de intentos disponibles.
    */
    public void startNewGame(String word, int maxAttempts) {
        setWord(word);
        setAttempts(maxAttempts);
    }
    
    /**
    * Devuelve el estado completo del juego, incluyendo la palabra enmascarada,
    * las palabras adivinadas y la cantidad que faltan para ganar.
    *
    * @return cadena descriptiva con el estado actual del juego.
    */
    public String gameStatus() {
        String msg = getMaskedWord();
        msg += "\nPalabras adivinadas: ";
        String[] palabras = getGuessedWords();
        for(String palabra:palabras) {
            msg += palabra + "-";
        }
        int cantidad = 5 - palabras.length;
        msg += "\nPalabras por adivinar para ganar: " + cantidad;
        
        return msg;
    }
    
    /**
    * Establece la palabra a adivinar convirtiéndola a arreglo de caracteres.
    *
    * @param word palabra objetivo.
    */
    public void setWord(String word) {
        this.word = word.toCharArray();
    }
    
    /**
    * Establece la cantidad de intentos restantes.
    *
    * @param attempts número de intentos permitidos.
    */
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    
    /**
    * Agrega una palabra que el jugador ya adivinó correctamente.
    *
    * @param word palabra adivinada.
    */
    public void addWordGuessed(String word) {
        if (this.guessedWords.isEmpty()) {
            this.guessedWords = word;
        } else {
            this.guessedWords += " & " + word;
        }
    }
    
    /**
    * Agrega una nueva letra al registro de letras intentadas,
    * evitando duplicados.
    *
    * @param newLetter letra que desea agregarse.
    */
    public void addLetter(char newLetter) {
        if (this.letters == null) { 
            this.letters = new char[]{newLetter};
        } else {
            boolean repetida = false;
            
            for(char letra:this.letters) {
                if(letra == newLetter) {
                    repetida = true;
                }
            }
            if(!repetida) {
                char[] nuevo = new char[this.letters.length + 1];
                for (int i = 0; i < this.letters.length; i++) {
                    nuevo[i] = this.letters[i];
                }
                nuevo[nuevo.length - 1] = newLetter;
                this.letters = nuevo; 
            }
        }
    }
    
    /**
    * Obtiene todas las palabras que el jugador ha adivinado correctamente.
    *
    * @return arreglo de palabras adivinadas.
    */
    public String[] getGuessedWords() {
        String temp = this.guessedWords.trim();
        if(temp.isEmpty()) {
            return new String[0];
        } else {
            return temp.split(" & ");
        }
    }
    
    /**
    * Reinicia el registro de palabras adivinadas.
    */
    public void resetGuessedWords() {
        this.guessedWords = "";
    }
    
    /**
    * Obtiene el número actual de intentos restantes.
    *
    * @return intentos restantes.
    */
    public int getAttempts() {
        return this.attempts;
    }
    
    /**
    * Devuelve el mensaje gráfico de victoria.
    *
    * @return representación ASCII de victoria.
    */
    public String getVictoryMessage() {
        return this.AHORCADO_VICTORIA;
    }
}
