/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import controller.RussianMultiplicationController;
import model.RussianMultiplicationModel;
import view.RussianMultiplicationView;

/**
 *
 * @author Mauricio
 */
public class Main { 
    public static void main(String[] args) { 
        RussianMultiplicationModel model = new RussianMultiplicationModel(); 
        RussianMultiplicationView view = new RussianMultiplicationView(); 
        RussianMultiplicationController controller = 
                new RussianMultiplicationController(model, view); 
        controller.start(); 
    } 
}
