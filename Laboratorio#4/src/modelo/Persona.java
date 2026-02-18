/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * Representa a una persona con un nombre y un número de identificación.
 * Valida que los datos ingresados sean correctos para evitar valores inválidos.
 * 
 * @author Mauricio León Bermúdez C5G444
 */
public class Persona {
    private String nombre;
    private int identificacion;
    
    /**
        * Crea una nueva persona con nombre e identificación.
        *
        * @param nombre nombre de la persona, no puede estar en blanco
        * @param identificacion número de identificación, debe ser mayor a 0
        * @throws IllegalArgumentException si alguno de los valores no es válido
        */
    public Persona(String nombre, int identificacion) {
        setNombre(nombre);
        setIdentificacion(identificacion);
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    /**
    * Establece el nombre de la persona.
    *
    * @param nombre no puede ser nulo ni estar en blanco
    * @throws IllegalArgumentException si el nombre es inválido
    */
    public void setNombre(String nombre) throws IllegalArgumentException{
        if(nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre de persona no debe estar en blanco");
        } else {
            this.nombre = nombre;
        }
    }

    /**
    * Establece el número de identificación.
    *
    * @param identificacion debe ser mayor a 0
    * @throws IllegalArgumentException si el número es inválido
    */
    public void setIdentificacion(int identificacion) throws IllegalArgumentException {
        if(identificacion <= 0) {
            throw new IllegalArgumentException("Número de identificación debe ser mayor a 0");
        } else {
            this.identificacion = identificacion;
        }
    }
}
