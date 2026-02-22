/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Clase base que representa a cualquier persona del sistema. Contiene
 * información común: ID, nombre y edad. Es extendida por clases como Paciente y
 * Medico.
 * 
 * @author Mauricio León Bermúdez C5G444
 */
public class Persona {

    private int id;
    private String nombre;
    private int edad;

    /**
     * Constructor de la clase Persona.
     *
     * @param id Identificador único de la persona.
     * @param nombre Nombre de la persona.
     * @param edad Edad de la persona.
     */
    public Persona(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Obtiene el ID de la persona.
     *
     * @return ID de la persona.
     */
    public int getId() {
        return id;
    }

    /**
     * Obtiene el nombre de la persona.
     *
     * @return Nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la edad de la persona.
     *
     * @return Edad de la persona.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece un nuevo ID para la persona.
     *
     * @param id Nuevo identificador.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Establece un nuevo nombre para la persona.
     *
     * @param nombre Nombre actualizado.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece una nueva edad para la persona.
     *
     * @param edad Edad actualizada.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Representación en texto de la persona.
     *
     * @return Cadena con ID, nombre y edad.
     */
    @Override
    public String toString() {
        return "(Persona)" + "Id: " + id + ", Nombre: " + nombre + ", Edad: " + edad;
    }

}
