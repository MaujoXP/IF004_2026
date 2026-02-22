/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Meowricio
 */
public class Paciente extends Persona{
    private int contacto;

    public Paciente(int id, String nombre, int edad, int contacto) {
        super(id, nombre, edad);
        this.contacto = contacto;
    }
    
    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return super.toString() + "(Paciente)" + "Contacto: " + contacto + "\n";
    }
    
}
