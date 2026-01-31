/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Futbolista extends Deportista {
    private String posicion;
    private int golesAnotados;
    private ArrayList<Tarjeta> tarjetasAcumuladas = new ArrayList<>();
    
    /**
     * Crea un futbolista con los datos especificados.
     *
     * @param nombre nombre del futbolista
     * @param estatura estatura en cm
     * @param posicion posición en el campo
     * @param golesAnotados cantidad inicial de goles
     */
    public Futbolista(String nombre, int estatura, String posicion, int golesAnotados) {
        super(nombre, estatura);
        this.posicion = posicion;
        this.golesAnotados = golesAnotados;
    }
    
    /**
     * Agrega una tarjeta al registro del futbolista.
     *
     * @param tarjeta objeto tipo Tarjeta a agregar
     */
    public void agregarTarjeta(Tarjeta tarjeta) {
        tarjetasAcumuladas.add(tarjeta);
    }
    
    /**
     * Calcula el salario del futbolista.
     * Por cada gol anotado recibe $500.
     *
     * @return salario total según goles anotados
     */
    @Override
    public double calcularSalario() {
        return this.golesAnotados * 500;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getGolesAnotados() {
        return golesAnotados;
    }

    public ArrayList<Tarjeta> getTarjetasAcumuladas() {
        return tarjetasAcumuladas;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    public void setTarjetasAcumuladas(ArrayList<Tarjeta> tarjetasAcumuladas) {
        this.tarjetasAcumuladas = tarjetasAcumuladas;
    }
}
