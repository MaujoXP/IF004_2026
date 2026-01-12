/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import controlador.ControladorArreglo;
import modelo.Arreglo;
import vista.VistaArreglo;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Main {
    public static void main(String args[]) {
        Arreglo modelo = new Arreglo();
        VistaArreglo vista = new VistaArreglo();
        ControladorArreglo controlador = new ControladorArreglo(modelo, vista);
        controlador.inicio();
    }
}
