/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 * Clase que representa una cita médica, con información del día, hora, médico,
 * paciente, fecha y estado.
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class Cita {

    private String dia;
    private String hora;
    private Medico medico;
    private Paciente paciente;
    private LocalDate fecha;
    private boolean activa;
    private String observaciones;

    /**
     * Constructor para crear una cita activa sin observaciones iniciales.
     *
     * @param dia Día de la cita.
     * @param hora Hora de la cita.
     * @param medico Médico asignado a la cita.
     * @param paciente Paciente asignado a la cita.
     * @param fecha Fecha específica de la cita.
     * @throws IllegalStateException si ocurre un problema al asignar la cita.
     */
    public Cita(String dia, String hora, Medico medico, Paciente paciente, LocalDate fecha) throws IllegalStateException {
        this.dia = dia;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
        this.fecha = fecha;
        this.activa = true;
        this.observaciones = "";
    }

    /**
     * Constructor para crear una cita con todos sus valores, incluyendo si está
     * activa y las observaciones.
     *
     * @param dia Día de la cita.
     * @param hora Hora de la cita.
     * @param medico Médico asignado.
     * @param paciente Paciente asignado.
     * @param fecha Fecha de la cita.
     * @param activa Indica si la cita está activa.
     * @param observaciones Comentarios u observaciones adicionales.
     * @throws IllegalStateException si ocurre un problema al asignar la cita.
     */
    public Cita(String dia, String hora, Medico medico, Paciente paciente, LocalDate fecha, boolean activa, String observaciones) throws IllegalStateException {
        this.dia = dia;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
        this.fecha = fecha;
        this.activa = activa;
        this.observaciones = observaciones;
    }

    /**
     * Libera el espacio ocupado en la agenda del médico correspondiente.
     */
    public void desocuparCita() {
        medico.desocuparEspacio(dia, hora);
    }

    /**
     * @return Día de la cita.
     */
    public String getDia() {
        return dia;
    }

    /**
     * @return Hora de la cita.
     */
    public String getHora() {
        return hora;
    }

    /**
     * @return Médico asignado a la cita.
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * @return Paciente asignado.
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @return Fecha específica de la cita.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * @return true si la cita está activa, false si está desactivada.
     */
    public boolean getActiva() {
        return activa;
    }

    /**
     * @return Observaciones de la cita.
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Establece el día de la cita.
     *
     * @param dia Nuevo día.
     */
    public void setDia(String dia) {
        this.dia = dia;
    }

    /**
     * Establece la hora de la cita.
     *
     * @param hora Nueva hora.
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /**
     * Asigna un nuevo médico a la cita.
     *
     * @param medico Médico a asignar.
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * Asigna un paciente a la cita.
     *
     * @param paciente Paciente a asignar.
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Cambia la fecha de la cita.
     *
     * @param fecha Nueva fecha.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Cambia el estado de la cita.
     *
     * @param activa true para activar la cita, false para desactivarla.
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    /**
     * Establece nuevas observaciones para la cita.
     *
     * @param observaciones Texto de observaciones.
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return Representación en texto de los datos de la cita.
     */
    @Override
    public String toString() {
        return "(Cita)\n"
                + "Día: " + dia + "\n"
                + "Hora: " + hora + "\n"
                + "Médico: " + medico.getNombre() + " (ID: " + medico.getCodigo() + ")\n"
                + "Paciente: " + paciente.getNombre() + " (ID: " + paciente.getId() + ")\n"
                + "Fecha: " + fecha + "\n"
                + "Activa: " + (activa ? "Sí" : "No") + "\n"
                + "Observaciones: " + (observaciones != null ? observaciones : "Ninguna") + "\n";
    }

}
