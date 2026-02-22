/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Meowricio
 */
public class Cita {
    private String dia;
    private String hora;
    private Medico medico;
    private Paciente paciente;
    private LocalDate fecha;
    private boolean activa;
    private String observaciones;

    public Cita(String dia, String hora, Medico medico, Paciente paciente, LocalDate fecha) throws IllegalStateException{
        this.dia = dia;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
        this.fecha = fecha;
        this.activa = true;
        this.observaciones = "";
    }
    
    public Cita(String dia, String hora, Medico medico, Paciente paciente, LocalDate fecha, boolean activa, String observaciones) throws IllegalStateException{
        this.dia = dia;
        this.hora = hora;
        this.medico = medico;
        this.paciente = paciente;
        this.fecha = fecha;
        this.activa = activa;
        this.observaciones = observaciones;
    }
    
    public void desocuparCita() {
        medico.desocuparEspacio(dia, hora);
    }

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    
    public boolean getActiva() {
        return activa;
    }
    
    public String getObservaciones() {
        return observaciones;
    }
    
    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "(Cita)\n" +
               "Día: " + dia + "\n" +
               "Hora: " + hora + "\n" +
               "Médico: " + medico.getNombre() + " (ID: " + medico.getCodigo() + ")\n" +
               "Paciente: " + paciente.getNombre() + " (ID: " + paciente.getId() + ")\n" +
               "Fecha: " + fecha + "\n" +
               "Activa: " + (activa ? "Sí" : "No") + "\n" +
               "Observaciones: " + (observaciones != null ? observaciones : "Ninguna") + "\n";
    }

    
    
}
