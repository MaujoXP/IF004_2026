/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import controlador.ControladorMatriz;
import modelo.Matriz;
import vista.VistaMatriz;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Main {
    public static void main(String args[]) {
        Matriz modelo = new Matriz();
        VistaMatriz vista = new VistaMatriz();
        ControladorMatriz controlador = new ControladorMatriz(modelo, vista);
        controlador.inicio();
    }
}
