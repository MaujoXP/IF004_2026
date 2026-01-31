/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Meowricio
 */
public class Bicicleta extends Vehiculo{
    private String tipoFrenado;
    
    public Bicicleta(int cantidadLlantas, int cantidadPasajeros, String color, String tipoFrenado) {
        super(cantidadLlantas, cantidadPasajeros, color);
        this.tipoFrenado = tipoFrenado;
    }
    
    @Override
    public void avanzar() {
        System.out.println("Avanzas pedaleando");
    }
    
    @Override
    public void frenar() {
        System.out.println("Frenas con " + this.tipoFrenado);
    }

    public String getTipoFrenado() {
        return tipoFrenado;
    }

    public void setTipoFrenado(String tipoFrenado) {
        this.tipoFrenado = tipoFrenado;
    }
    
    
}
