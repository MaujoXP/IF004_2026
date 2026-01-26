/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Gaby
 */
public class Perro extends Animal{
    private String raza;
    
    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);
        this.raza = raza;
    }
    
    @Override
    public String hacerSonido() {
        return "Guau";
    }
    
    public void setRaza(String raza) {
        this.raza = raza;
    }
    
    public String getRaza() {
        return this.raza;
    }
}
