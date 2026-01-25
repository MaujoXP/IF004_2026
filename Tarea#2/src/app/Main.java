/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import controlador.ControladorLibro;
import modelo.Libro;
import vista.VistaLibro;

/**
 *
 * @author Meowricio
 */
public class Main {
    public static void main(String args[]) {
        Libro modelo = new Libro();
        VistaLibro vista = new VistaLibro();
        ControladorLibro controlador = new ControladorLibro(modelo, vista);
        controlador.menuInicio();
    }
}
