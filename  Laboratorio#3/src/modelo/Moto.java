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
 * Clase hija que hereda de Vehiculo.
 */
public class Moto extends Vehiculo {

    private int cilindraje;

    /**
     * Constructor de Moto.
     * Utiliza el constructor de Vehiculo para inicializar la marca y la velocidad máxima,
     * y establece el cilindraje de la moto.
     *
     * @param marca marca de la moto.
     * @param velocidadMax velocidad máxima permitida.
     * @param cilindraje cilindraje en centímetros cúbicos.
     */
    public Moto(String marca, int velocidadMax, int cilindraje) {
        super(marca, velocidadMax);
        setCilindraje(cilindraje);
    }
    
    /**
     * Selecciona una marcha de la moto.
     * Lanza una excepción si la marcha no está entre 1 y 5.
     *
     * @param marcha número de marcha a seleccionar.
     * @throws IndexOutOfBoundsException si la marcha es inválida.
     */
    public void seleccionarMarcha(int marcha) {
        int[] marchas = {1, 2, 3, 4, 5};
        if (marcha < 1 || marcha > 5) {
            throw new IndexOutOfBoundsException("Esa marcha no existe en la moto");
        }
    }
    
    public int getCilindraje() {
        return cilindraje;
    }

    /**
     * Establece el cilindraje de la moto.
     * Lanza una excepción si el cilindraje es menor o igual a cero.
     *
     * @param cilindraje nuevo cilindraje en cc.
     * @throws IllegalStateException si el cilindraje no es válido.
     */
    public void setCilindraje(int cilindraje) {
        if(cilindraje <= 0) {
            throw new IllegalStateException("El cilindraje debe ser mayor a 0");
        }
        this.cilindraje = cilindraje;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cilindraje: " + cilindraje + " cc";
    }
}
