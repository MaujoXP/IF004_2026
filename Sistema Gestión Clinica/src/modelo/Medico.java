/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Meowricio
 */
public class Medico extends Persona{
    private int codigo;
    private String especialidad;
    private String turno;
    private EspacioAgenda[][] horario = new EspacioAgenda[7][8];

    public Medico(int id, String nombre, int edad, int codigo, String especialidad, String horario) {
        super(id, nombre, edad);
        this.codigo = codigo;
        this.especialidad = especialidad;
        this.turno = horario;
        setHorario(horario);
    }   

    private boolean estaDisponible(int dia, String hora) {
        for(int i = 0; i < horario[dia].length; i++) {
            EspacioAgenda espacio = horario[dia][i];

            if(espacio.getHora().equalsIgnoreCase(hora)) {
                return espacio.isDisponible();
            }
        }

        return false;
    }
    
    public void ocuparEspacio(String diaString, String hora) throws IllegalStateException {
        int dia = indiceDia(diaString);

        for (int i = 0; i < horario[dia].length; i++) {
            EspacioAgenda espacio = horario[dia][i];
            
            if (espacio != null && espacio.getHora().trim().equalsIgnoreCase(hora.trim())) {
                if(!espacio.isDisponible()) {
                    throw new IllegalStateException("El espacio ya está ocupado: día " + diaString + " hora " + hora);
                }
                espacio.ocupar(); // marca el espacio como ocupado
                return;           // termina el método después de ocupar
            }
        }

        // Si no se encontró la hora en ese día
        throw new IllegalStateException("No existe un espacio para la hora " + hora + " en el día " + diaString);
    }

    
    public void desocuparEspacio(String diaString, String hora) throws IllegalStateException {
        int dia = indiceDia(diaString);
        for(int i = 0; i < horario[dia].length; i++) {
            EspacioAgenda espacio = horario[dia][i];
            if(espacio != null && espacio.getHora().equalsIgnoreCase(hora)) {
                if(espacio.isDisponible()) {
                    throw new IllegalStateException("El espacio no estaba ocupado: día " + dia + " hora " + hora);
                }

                espacio.desocupar();
                return;
            }
        }
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public EspacioAgenda[][] getHorario() {
        return horario;
    }
    
    public String getTurno() {
        return turno;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setHorario(String turno) {
        String[] horas;

        if (turno.equalsIgnoreCase("MAÑANA")) {
            horas = new String[] { "06:00 AM", "07:00 AM", "08:00 AM", "09:00 AM",
                                   "10:00 AM", "11:00 AM", "01:00 PM", "02:00 PM" };
        } else if (turno.equalsIgnoreCase("TARDE")) {
            horas = new String[] { "02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM",
                                   "06:00 PM", "07:00 PM", "08:00 PM", "09:00 PM" };
        } else {
            horas = new String[] { "10:00 PM", "11:00 PM", "12:00 AM", "01:00 AM",
                                   "02:00 AM", "03:00 AM", "04:00 AM", "05:00 AM" };
        }

        for (int d = 0; d < 7; d++) {
            for (int c = 0; c < 8; c++) {
                // ⚠️ Solo inicializar si no existe
                if (horario[d][c] == null) {
                    horario[d][c] = new EspacioAgenda(horas[c], true);
                }
            }
        }
    }
    
    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    private int indiceDia(String dia) throws IllegalArgumentException{
        dia = dia.toUpperCase();

        switch(dia) {
            case "MONDAY":
                return 0;
            case "TUESDAY":
                return 1;
            case "WEDNESDAY":
                return 2;
            case "THURSDAY":
                return 3;
            case "FRIDAY":
                return 4;
            case "SATURDAY":
                return 5;
            case "SUNDAY":
                return 6;
            default:
                throw new IllegalArgumentException("Día inválido: " + dia);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "(Medico)" + "Codigo: " + codigo + ", Especialidad: " + especialidad + "\n";
    }
}
