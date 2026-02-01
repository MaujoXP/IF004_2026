/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Estudiante extends Persona{
    private String carnet;
    private String carrera;
    private Curso curso;
    
    /**
    * Construye un nuevo estudiante con nombre, edad, carnet y carrera.
    *
    * @param nombre  el nombre del estudiante
    * @param edad    la edad del estudiante
    * @param carnet  el número de carnet del estudiante
    * @param carrera la carrera que estudia el estudiante
    */
    public Estudiante(String nombre, int edad, String carnet, String carrera) {
        super(nombre, edad);
        this.carnet = carnet;
        this.carrera = carrera;
    }
    
    /**
    * Matricula al estudiante en el curso indicado.
    *
    * @param curso el curso que el estudiante desea matricular
    */
    public void matricularCurso(Curso curso) {
        this.curso = curso;
    }
    
    /**
    * Retira el curso actual del estudiante, dejándolo sin curso matriculado.
    */
    public void retirarCurso() {
        this.curso = null;
    }
    
    public String getCarnet() {
        return carnet;
    }

    public String getCarrera() {
        return carrera;
    }
    
    public Curso getCurso() {
        return curso;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return super.toString() + "\n====Estudiante====\n" + "Carnet: " + carnet + "\nCarrera: " + carrera;
    }
}
