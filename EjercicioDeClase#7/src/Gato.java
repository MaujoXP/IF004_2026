/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gaby
 */
public class Gato extends Animal {
    private String color;
    
    public Gato(String nombre, int edad, String color) {
        super(nombre, edad);
        this.color = color;
    }
    
    @Override
    public String hacerSonido() {
        return "Miau";
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColor() {
        return this.color;
    }
}
