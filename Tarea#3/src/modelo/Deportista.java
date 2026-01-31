/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public abstract class Deportista {
    protected String nombre;
    protected int estatura;
    
    /**
     * Constructor base para un deportista.
     *
     * @param nombre nombre del deportista
     * @param estatura estatura en centímetros
     */
    public Deportista(String nombre, int estatura) {
        this.estatura = estatura;
        this.nombre = nombre;
    }
    
    /**
     * Calcula el salario del deportista.
     *
     * @return salario correspondiente al deportista
     */
    public abstract double calcularSalario();

    public String getNombre() {
        return nombre;
    }

    public int getEstatura() {
        return estatura;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstatura(int estatura) {
        this.estatura = estatura;
    }
}
