/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Gaby
 */
public class Persona {
    private String nombre;
    private int identificacion;
    
    public Persona(String persona, int identificacion) {
        setNombre(nombre);
        setIdentificacion(identificacion);
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setNombre(String nombre) throws IllegalArgumentException{
        if(nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre de persona no debe estar en blanco");
        } else {
            this.nombre = nombre;
        }
    }

    public void setIdentificacion(int identificacion) throws IllegalArgumentException {
        if(identificacion <= 0) {
            throw new IllegalArgumentException("Número de identificación debe ser mayor a 0");
        } else {
            this.identificacion = identificacion;
        }
    }
}
