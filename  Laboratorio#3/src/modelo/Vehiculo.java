/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */

/**
 * Clase padre que representa un vehículo.
 */
public class Vehiculo {

    private String marca;
    private int velocidadMax;

    /**
     * Constructor de Vehiculo.
     * Inicializa la marca y la velocidad máxima usando sus métodos set.
     *
     * @param marca marca del vehículo.
     * @param velocidadMax velocidad máxima permitida.
     */
    public Vehiculo(String marca, int velocidadMax) {
        setMarca(marca);
        setVelocidadMax(velocidadMax);
    }
    
    /**
     * Verifica que la velocidad ingresada no supere la velocidad máxima del vehículo.
     * Lanza una excepción si la velocidad es mayor al límite permitido.
     *
     * @param velocidad velocidad a evaluar.
     * @throws UnsupportedOperationException si la velocidad excede la velocidad máxima.
     */
    public void verificarVelocidad(int velocidad) throws UnsupportedOperationException {
        if(velocidad > velocidadMax) {
            throw new UnsupportedOperationException("Esa velocidad excede el límite del vehículo");
        }
    }
    
    public String getMarca() {
        return marca; 
    }

    public int getVelocidadMax() {
        return velocidadMax;
    }

     /**
     * Establece la velocidad máxima del vehículo.
     * Lanza una excepción si la velocidad es menor o igual a cero.
     *
     * @param velocidadMax nueva velocidad máxima.
     * @throws IllegalStateException si la velocidad no es válida.
     */
    public void setVelocidadMax(int velocidadMax) {
        if(velocidadMax <= 0) {
            throw new IllegalStateException("La velocidad debe ser mayor a 0");
        }
        this.velocidadMax = velocidadMax;
    }
    
     /**
     * Establece la marca del vehículo.
     * Lanza una excepción si la marca es nula o está vacía.
     *
     * @param marca nueva marca del vehículo.
     * @throws NullPointerException si la marca está vacía o es null.
     */
    public void setMarca(String marca) {
        if(marca == null || marca.trim().isEmpty()) {
            throw new NullPointerException("La marca no puede estar vacía");
        }
        this.marca = marca;
    }
    
    @Override
    public String toString() {
        return "Vehículo marca " + marca + ", Velocidad Máxima: " + velocidadMax + " km/h";
    }
}
