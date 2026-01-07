/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.RussianMultiplicationModel;
import view.RussianMultiplicationView;

/**
 *
 * @author Mauricio
 */
public class RussianMultiplicationController { 
    private final RussianMultiplicationModel model; 
    private final RussianMultiplicationView view; 
    public RussianMultiplicationController(RussianMultiplicationModel model, 
                                           RussianMultiplicationView view) { 
        this.model = model; 
        this.view = view; 
    } 
    public void start() { 
        long a;
        long b;
        long result;
        
        int opcion = view.leerOpcionMenu();
        switch (opcion) {
            case 1: 
                a = view.readNumber("Ingrese A: "); 
                b = view.readNumber("Ingrese B: "); 
                result = model.multiply(a, b); 
                view.showResult(result);
                break;
            case 2: 
                a = view.leerNumero("Ingrese A: "); 
                b = view.leerNumero("Ingrese B: "); 
                result = model.multiply(a, b); 
                view.mostrarResultado(result);
                break;
            default:
                start();
                break;
        }
             
    } 
}