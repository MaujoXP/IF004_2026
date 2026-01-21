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
    
    private char[] getRandomWord() {
        String[] palabras = words.trim().split(" & ");
        Random rdm = new Random();
        int indice = rdm.nextInt(palabras.length);
        char[] palabra = palabras[indice].toCharArray();
        
        return palabra;  
    }
    
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
    
    public void startNewGame(String word, int maxAttempts) {
        setWord(word);
        setAttempts(maxAttempts);
    }
    
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
    
    public void setWord(String word) {
        this.word = word.toCharArray();
    }
    
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    
    public void addWordGuessed(String word) {
        if (this.guessedWords.isEmpty()) {
            this.guessedWords = word;
        } else {
            this.guessedWords += " & " + word;
        }
    }
    
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
    
    public String[] getGuessedWords() {
        String temp = this.guessedWords.trim();
        if(temp.isEmpty()) {
            return new String[0];
        } else {
            return temp.split(" & ");
        }
    }
    
    public void resetGuessedWords() {
        this.guessedWords = "";
    }
    
    public int getAttempts() {
        return this.attempts;
    }
    
    public String getVictoryMessage() {
        return this.AHORCADO_VICTORIA;
    }
}
