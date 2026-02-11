/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Gaby
 */
public class Cliente extends Persona {
    private String correo;
    
    public Cliente(String nombre, int identificacion, String correo) {
        super(nombre, identificacion);
        setCorreo(correo);
    }
    
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) throws IllegalArgumentException{
        if(!correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe incluir @ para ser válido");
        } else {
            this.correo = correo;
        }
    }
}
