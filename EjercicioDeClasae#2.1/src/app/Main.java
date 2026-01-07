/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import controlador.ControladorClasificador;
import modelo.Clasificador;
import vista.VistaClasificador;

/**
 *
 * @author Meowricio
 */
public class Main {
    public static void main(String args[]) {
        Clasificador modelo = new Clasificador();
        VistaClasificador vista = new VistaClasificador();
        ControladorClasificador controlador = new ControladorClasificador(modelo, vista);
        controlador.iniciar();
    }
}
