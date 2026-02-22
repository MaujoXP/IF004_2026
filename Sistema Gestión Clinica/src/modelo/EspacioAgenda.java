/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa un espacio dentro de la agenda de un médico, indicando una hora
 * específica y si se encuentra disponible o no.
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class EspacioAgenda {

    private String hora;
    private boolean disponible;

    /**
     * Constructor que inicializa un espacio de agenda con una hora específica y
     * su estado de disponibilidad.
     *
     * @param hora Hora del espacio de agenda.
     * @param disponible true si el espacio está disponible, false si está
     * ocupado.
     */
    public EspacioAgenda(String hora, boolean disponible) {
        this.hora = hora;
        this.disponible = disponible;
    }

    /**
     * Marca el espacio como ocupado.
     */
    public void ocupar() {
        this.disponible = false;
    }

    /**
     * Marca el espacio como disponible.
     */
    public void desocupar() {
        this.disponible = true;
    }

    /**
     * Obtiene la hora asociada al espacio de agenda.
     *
     * @return Hora del espacio.
     */
    public String getHora() {
        return hora;
    }

    /**
     * Indica si el espacio está disponible.
     *
     * @return true si está disponible, false si está ocupado.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Establece una nueva hora para el espacio de agenda.
     *
     * @param hora Nueva hora.
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Cambia el estado de disponibilidad del espacio.
     *
     * @param disponible true para establecer como disponible, false para
     * ocupado.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
