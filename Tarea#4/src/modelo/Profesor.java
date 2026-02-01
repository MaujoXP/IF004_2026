/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Profesor extends Persona{
    private String codigoEmpleado;
    private String especialidad;
    private Curso cursoImpartido;
    
    /**
    * Construye un nuevo profesor con nombre, edad, código de empleado
    * y especialidad.
    *
    * @param nombre          el nombre del profesor
    * @param edad            la edad del profesor
    * @param codigoEmpleado  el código único del profesor
    * @param especialidad    la especialidad del profesor
    */
    public Profesor(String  nombre, int edad, String codigoEmpleado, String especialidad) {
        super(nombre, edad);
        this.codigoEmpleado = codigoEmpleado;
        this.especialidad = especialidad;
    }
    
    
    /**
     * Asigna el curso que será impartido por el profesor.
     *
     * @param cursoImpartido el curso que se asignará al profesor
     */
    public void asignarCurso(Curso cursoImpartido) {
        this.cursoImpartido = cursoImpartido;
    }
    
    /**
    * Retira el curso actualmente asignado al profesor, dejándolo sin curso impartido.
    */
    public void retirarCurso() {
        this.cursoImpartido = null;
    }
    
    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    
    public Curso getCursoImpartido() {
        return cursoImpartido;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public void setCursoImpartido(Curso cursoImpartido) {
        this.cursoImpartido = cursoImpartido;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\n====Profesor====\n" + "Codigo de Empleado: " + codigoEmpleado + "\nEspecialidad: " + especialidad;
    }
}
