/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Arreglo;
import vista.VistaArreglo;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class ControladorArreglo {
    private Arreglo modelo;
    private VistaArreglo vista;
    
    /**
     * Constructor del controlador.
     *
     * @param modelo instancia del modelo que contiene la lógica de datos.
     * @param vista instancia de la vista que muestra mensajes al usuario.
     */
    public ControladorArreglo(Arreglo modelo, VistaArreglo vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    /**
     * Método principal que inicia el flujo del programa.
     * Muestra el menú al usuario y ejecuta la acción correspondiente.
     * 
     * El método se llama recursivamente después de cada acción
     * para volver a mostrar el menú, excepto en la opción 7 (salir).
     */
    public void inicio() {
        String msg = "";
        int opcion = this.vista.showMenu();
        switch (opcion) {
            case 1:
                modelo.fillArray();
                vista.mostrarEvento("Arreglo rellenado");
                inicio();
                break;
            case 2:
                vista.mostrarEvento(modelo.toString());
                inicio();
                break;
            case 3:
                msg = "Promedio: " + modelo.getAvg();
                vista.mostrarEvento(msg);
                inicio();
                break;
            case 4:
                modelo.orderArray();
                msg = "Arreglo ordenado";
                vista.mostrarEvento(msg);
                inicio();
                break;
            case 5: 
                msg = "Números mayores al promedio: " + modelo.sumMaxAvg();
                vista.mostrarEvento(msg);
                inicio();
                break;
            case 6: 
                msg = "Números opuestos sumados\n";
                int[] sumaOpuestos = modelo.sumOpposites();
                for(int num:sumaOpuestos) {
                    msg += num + ", ";
                }
                vista.mostrarEvento(msg);
                inicio();
                break;
            case 7:
                break;
            default:
                inicio();
                break;
                
       
        }
    }
}
