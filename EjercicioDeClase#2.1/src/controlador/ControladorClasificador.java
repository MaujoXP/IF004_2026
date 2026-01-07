/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Clasificador;
import vista.VistaClasificador;

/**
 *
 * @author Meowricio
 */
public class ControladorClasificador {
    private Clasificador modelo;
    private VistaClasificador vista;
    
    public ControladorClasificador(Clasificador modelo, VistaClasificador vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void iniciar() {
        int numero = vista.leerNumero();
        String resultado = modelo.clasificacion(numero);
        vista.mostrarResultado(resultado);
    }
}
