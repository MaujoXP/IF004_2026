/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Piloto extends Deportista{
    private String tipoLicencia;
    private int carrerasGanadas;
    
    /**
     * Crea un piloto con los datos especificados.
     *
     * @param nombre nombre del piloto
     * @param estatura estatura en cm
     * @param tipoLicencia tipo de licencia
     * @param carrerasGanadas número inicial de carreras ganadas
     */
    public Piloto(String nombre, int estatura, String tipoLicencia, int carrerasGanadas) {
        super(nombre, estatura);
        this.carrerasGanadas = carrerasGanadas;
        this.tipoLicencia = tipoLicencia;
    }
    
    /**
     * Incrementa en 1 la cantidad de carreras ganadas.
     */
    public void agregarVictoria() {
        this.carrerasGanadas++;
    }
    
    /**
     * Calcula el salario del piloto.
     * Por cada carrera ganada recibe $5000.
     *
     * @return salario total según carreras ganadas
     */
    @Override
    public double calcularSalario() {
        return this.carrerasGanadas * 5000;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public int getCarrerasGanadas() {
        return carrerasGanadas;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public void setCarrerasGanadas(int carrerasGanadas) {
        this.carrerasGanadas = carrerasGanadas;
    }
}
