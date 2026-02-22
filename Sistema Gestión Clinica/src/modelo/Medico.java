/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa a un médico dentro del sistema. Extiende la clase Persona y
 * contiene información sobre su código, especialidad, turno y un horario
 * semanal con espacios disponibles para citas.
 * 
 * @author Mauricio León Bermúdez C5G444
 */
public class Medico extends Persona {

    private int codigo;
    private String especialidad;
    private String turno;
    private EspacioAgenda[][] horario = new EspacioAgenda[7][8];

    /**
     * Constructor de la clase Medico. Inicializa la información básica del
     * médico y genera el horario según el turno indicado.
     *
     * @param id ID heredado de Persona.
     * @param nombre Nombre del médico.
     * @param edad Edad del médico.
     * @param codigo Código único del médico.
     * @param especialidad Especialidad médica.
     * @param horario Turno del médico (mañana, tarde o noche).
     */
    public Medico(int id, String nombre, int edad, int codigo, String especialidad, String horario) {
        super(id, nombre, edad);
        this.codigo = codigo;
        this.especialidad = especialidad;
        this.turno = horario;
        setHorario(horario);
    }

    /**
     * Verifica si un espacio específico del horario está disponible.
     *
     * @param dia Índice del día (0 = lunes, 6 = domingo).
     * @param hora Hora a buscar en formato String.
     * @return true si está disponible, false en caso contrario.
     */
    private boolean estaDisponible(int dia, String hora) {
        for (int i = 0; i < horario[dia].length; i++) {
            EspacioAgenda espacio = horario[dia][i];

            if (espacio.getHora().equalsIgnoreCase(hora)) {
                return espacio.isDisponible();
            }
        }
        return false;
    }

    /**
     * Ocupa un espacio del horario para el día y hora especificados.
     *
     * @param diaString Nombre del día (ej. "MONDAY").
     * @param hora Hora a ocupar.
     * @throws IllegalStateException si el espacio no existe o está ocupado.
     */
    public void ocuparEspacio(String diaString, String hora) throws IllegalStateException {
        int dia = indiceDia(diaString);

        for (int i = 0; i < horario[dia].length; i++) {
            EspacioAgenda espacio = horario[dia][i];

            if (espacio != null && espacio.getHora().trim().equalsIgnoreCase(hora.trim())) {
                if (!espacio.isDisponible()) {
                    throw new IllegalStateException("El espacio ya está ocupado: día " + diaString + " hora " + hora);
                }
                espacio.ocupar();
                return;
            }
        }

        throw new IllegalStateException("No existe un espacio para la hora " + hora + " en el día " + diaString);
    }

    /**
     * Libera un espacio previamente ocupado del horario.
     *
     * @param diaString Nombre del día.
     * @param hora Hora a desocupar.
     * @throws IllegalStateException si el espacio no existe o ya estaba libre.
     */
    public void desocuparEspacio(String diaString, String hora) throws IllegalStateException {
        int dia = indiceDia(diaString);
        for (int i = 0; i < horario[dia].length; i++) {
            EspacioAgenda espacio = horario[dia][i];
            if (espacio != null && espacio.getHora().equalsIgnoreCase(hora)) {
                if (espacio.isDisponible()) {
                    throw new IllegalStateException("El espacio no estaba ocupado: día " + dia + " hora " + hora);
                }

                espacio.desocupar();
                return;
            }
        }
    }

    /**
     * Obtiene el código único del médico.
     *
     * @return Código del médico.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Obtiene la especialidad del médico.
     *
     * @return Especialidad del médico.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Devuelve la matriz completa del horario del médico.
     *
     * @return Matriz de EspacioAgenda.
     */
    public EspacioAgenda[][] getHorario() {
        return horario;
    }

    /**
     * Obtiene el turno asignado al médico.
     *
     * @return Turno del médico.
     */
    public String getTurno() {
        return turno;
    }

    /**
     * Establece el código del médico.
     *
     * @param codigo Nuevo código.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Establece la especialidad médica.
     *
     * @param especialidad Nueva especialidad.
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    /**
     * Genera y asigna el horario del médico según su turno. Cada turno contiene
     * 8 horas predefinidas.
     *
     * @param turno Turno del médico.
     */
    public void setHorario(String turno) {
        String[] horas;

        if (turno.equalsIgnoreCase("MAÑANA")) {
            horas = new String[]{"06:00 AM", "07:00 AM", "08:00 AM", "09:00 AM",
                "10:00 AM", "11:00 AM", "01:00 PM", "02:00 PM"};
        } else if (turno.equalsIgnoreCase("TARDE")) {
            horas = new String[]{"02:00 PM", "03:00 PM", "04:00 PM", "05:00 PM",
                "06:00 PM", "07:00 PM", "08:00 PM", "09:00 PM"};
        } else {
            horas = new String[]{"10:00 PM", "11:00 PM", "12:00 AM", "01:00 AM",
                "02:00 AM", "03:00 AM", "04:00 AM", "05:00 AM"};
        }

        for (int d = 0; d < 7; d++) {
            for (int c = 0; c < 8; c++) {
                if (horario[d][c] == null) {
                    horario[d][c] = new EspacioAgenda(horas[c], true);
                }
            }
        }
    }

    /**
     * Establece el turno del médico.
     *
     * @param turno Nuevo turno.
     */
    public void setTurno(String turno) {
        this.turno = turno;
    }

    /**
     * Convierte un día en formato String a un índice numérico.
     *
     * @param dia Día en texto (ej: "MONDAY").
     * @return Índice correspondiente.
     * @throws IllegalArgumentException si el día no es válido.
     */
    private int indiceDia(String dia) throws IllegalArgumentException {
        dia = dia.toUpperCase();

        switch (dia) {
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

    /**
     * Representación en texto del médico con sus datos principales.
     *
     * @return Cadena con información del médico.
     */
    @Override
    public String toString() {
        return super.toString() + "(Medico)" + "Codigo: " + codigo + ", Especialidad: " + especialidad + "\n";
    }
}
