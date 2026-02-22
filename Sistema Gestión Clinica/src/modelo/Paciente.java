/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 * Representa un paciente dentro del sistema. Extiende la clase Persona y añade
 * información de contacto telefónico.
 * 
 * @author Mauricio León Bermúdez C5G444
 */
public class Paciente extends Persona {

    private int contacto;

    /**
     * Constructor de la clase Paciente.
     *
     * @param id ID del paciente.
     * @param nombre Nombre del paciente.
     * @param edad Edad del paciente.
     * @param contacto Número de contacto telefónico.
     */
    public Paciente(int id, String nombre, int edad, int contacto) {
        super(id, nombre, edad);
        this.contacto = contacto;
    }

    /**
     * Obtiene el número de contacto del paciente.
     *
     * @return Número de contacto.
     */
    public int getContacto() {
        return contacto;
    }

    /**
     * Establece un nuevo número de contacto.
     *
     * @param contacto Nuevo número de contacto.
     */
    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    /**
     * Devuelve una representación en texto del paciente.
     *
     * @return Cadena con información del paciente.
     */
    @Override
    public String toString() {
        return super.toString() + "(Paciente)" + "Contacto: " + contacto + "\n";
    }

}
