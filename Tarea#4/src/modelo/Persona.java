/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Persona {
    protected String nombre;
    protected int edad;
    
    /**
    * Construye una nueva persona con su nombre y edad.
    *
    * @param nombre el nombre de la persona
    * @param edad   la edad de la persona
    */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "====Persona====\n" + "Nombre: " + nombre + "\nEdad: " + edad;
    }
}
