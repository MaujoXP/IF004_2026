/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import controlador.ControladorAhorcado;
import modelo.Ahorcado;
import vista.VistaAhorcado;

/**
 *
 * @author Meowricio
 */
public class Main {
    public static void main(String[] args) {
        Ahorcado modelo = new Ahorcado();
        VistaAhorcado vista = new VistaAhorcado();
        ControladorAhorcado controlador = new ControladorAhorcado(modelo, vista);
        controlador.inicio();
    }
        
}
