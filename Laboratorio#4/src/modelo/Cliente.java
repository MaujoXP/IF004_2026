/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa un cliente que hereda los datos básicos de una persona,
 * agregando un correo electrónico como información adicional.
 * 
 * @author Mauricio León Bermúdez C5G444
 */
public class Cliente extends Persona {
    private String correo;
    
    /**
    * Crea un cliente con nombre, identificación y correo electrónico.
    *
    * @param nombre nombre del cliente
    * @param identificacion número de identificación del cliente
    * @param correo correo electrónico válido
    * @throws IllegalArgumentException si el correo no contiene '@'
    */
    public Cliente(String nombre, int identificacion, String correo) {
        super(nombre, identificacion);
        setCorreo(correo);
    }
    
    public String getCorreo() {
        return this.correo;
    }
    
    /**
    * Establece el correo electrónico del cliente.
    * El correo debe contener el carácter '@' para considerarse válido.
    *
    * @param correo correo electrónico a asignar
    * @throws IllegalArgumentException si el correo no es válido
    */
    public void setCorreo(String correo) throws IllegalArgumentException{
        if(!correo.contains("@")) {
            throw new IllegalArgumentException("El correo debe incluir @ para ser válido");
        } else {
            this.correo = correo;
        }
    }
}
