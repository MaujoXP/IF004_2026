/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Meowricio
 */
public class EspacioAgenda {
    private String hora;
    private boolean disponible;
    
    public EspacioAgenda(String hora, boolean disponible) {
        this.hora = hora;
        this.disponible = disponible;
    }

    public void ocupar() {
        this.disponible = false;
    }
    
    public void desocupar() {
        this.disponible = true;
    }
    
    public String getHora() {
        return hora;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
