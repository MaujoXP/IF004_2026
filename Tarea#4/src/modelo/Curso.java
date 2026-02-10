/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Curso {
    private String curso;
    private String nombre;
    private int creditos;
    
    /**
    * Construye un nuevo curso con su código, nombre y cantidad de créditos.
    *
    * @param curso   el código del curso (por ejemplo: "CI-1311")
    * @param nombre  el nombre del curso (por ejemplo: "Programación I")
    * @param creditos la cantidad de créditos que tiene el curso
    */
    public Curso(String curso, String nombre, int creditos) {
        this.curso = curso;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getCurso() {
        return curso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    
    @Override
    public String toString() {
        return "====Curso====\nCurso: " + curso + "\nNombre: " + nombre + "\nCreditos: " + creditos;
    }
}
