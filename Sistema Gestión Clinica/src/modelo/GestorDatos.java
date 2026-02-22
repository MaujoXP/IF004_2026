/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * Gestor que administra todas las colecciones del sistema: pacientes, médicos y
 * citas. Permite agregar, buscar y generar reportes relacionados con estos
 * datos.
 * 
 * @author Mauricio León Bermúdez C5G444
 */
public class GestorDatos {

    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Medico> medicos = new ArrayList<>();
    private ArrayList<Cita> citas = new ArrayList<>();

    // PACIENTES
    /**
     * Agrega un nuevo paciente a la lista.
     *
     * @param p Paciente a agregar.
     * @throws IllegalArgumentException si el paciente es null.
     */
    public void agregarPaciente(Paciente p) {
        if (p == null) {
            throw new IllegalArgumentException("Paciente no puede ser null");
        }

        pacientes.add(p);
    }

    /**
     * Obtiene la lista completa de pacientes.
     *
     * @return Lista de pacientes.
     */
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    /**
     * Busca un paciente por su ID.
     *
     * @param id ID del paciente.
     * @return Paciente encontrado.
     * @throws NoSuchElementException si no existe un paciente con ese ID.
     */
    public Paciente buscarPacientePorId(int id) throws NoSuchElementException {
        for (Paciente p : pacientes) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new NoSuchElementException("No existe un paciente con ID: " + id);
    }

    /**
     * Verifica si existe un paciente con el ID proporcionado.
     *
     * @param id ID a verificar.
     * @return true si existe, false si no.
     */
    public boolean existePaciente(int id) {
        for (Paciente p : pacientes) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    // MEDICOS
    /**
     * Agrega un médico a la lista.
     *
     * @param m Médico a agregar.
     * @throws IllegalArgumentException si el médico es null.
     */
    public void agregarMedico(Medico m) {
        if (m == null) {
            throw new IllegalArgumentException("Médico no puede ser null");
        }

        medicos.add(m);
    }

    /**
     * Obtiene la lista completa de médicos.
     *
     * @return Lista de médicos.
     */
    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    /**
     * Verifica si existe un médico con un código específico.
     *
     * @param codigo Código a verificar.
     * @return true si existe, false si no.
     */
    public boolean existeMedicoCodigo(int codigo) {
        for (Medico m : medicos) {
            if (m.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Busca un médico por su código único.
     *
     * @param codigo Código del médico.
     * @return Médico encontrado.
     * @throws NoSuchElementException si no existe uno con ese código.
     */
    public Medico buscarMedicoPorCodigo(int codigo) throws NoSuchElementException {
        for (Medico m : medicos) {
            if (m.getCodigo() == codigo) {
                return m;
            }
        }
        throw new NoSuchElementException("No existe un Medico con ese Código: " + codigo);
    }

    /**
     * Verifica si existe un médico por ID.
     *
     * @param id ID a verificar.
     * @return true si existe, false si no.
     */
    public boolean existeMedico(int id) {
        for (Medico m : medicos) {
            if (m.getId() == id) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene todos los médicos que tengan la especialidad indicada.
     *
     * @param especialidad Especialidad buscada.
     * @return Lista de médicos con esa especialidad.
     * @throws IllegalArgumentException si la especialidad es inválida.
     * @throws NoSuchElementException si no hay médicos con esa especialidad.
     */
    public ArrayList<Medico> getMedicosPorEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("Especialidad inválida");
        }

        ArrayList<Medico> lista = new ArrayList<>();

        for (Medico m : medicos) {
            if (m.getEspecialidad().equalsIgnoreCase(especialidad)) {
                lista.add(m);
            }
        }

        if (lista.isEmpty()) {
            throw new NoSuchElementException("No hay médicos con especialidad: " + especialidad);
        }

        return lista;
    }

    // CITAS
    /**
     * Agrega una nueva cita al sistema.
     *
     * @param c Cita a agregar.
     * @throws IllegalArgumentException si la cita es null.
     */
    public void agregarCita(Cita c) {
        if (c == null) {
            throw new IllegalArgumentException("Cita no puede ser null");
        }

        citas.add(c);
    }

    /**
     * Verifica si ya existe una cita con los datos proporcionados.
     *
     * @param paciente Paciente involucrado.
     * @param medico Médico involucrado.
     * @param fecha Fecha de la cita.
     * @param hora Hora de la cita.
     * @return true si existe, false si no.
     */
    public boolean existeCita(Paciente paciente, Medico medico, LocalDate fecha, String hora) {
        for (Cita c : citas) {
            if (c.getPaciente().getId() == paciente.getId()
                    && c.getMedico().getCodigo() == medico.getCodigo()
                    && c.getFecha().equals(fecha)
                    && c.getHora().equals(hora)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene la lista completa de citas.
     *
     * @return Lista de citas.
     */
    public ArrayList<Cita> getCitas() {
        return citas;
    }

    /**
     * Obtiene todas las citas para una fecha exacta.
     *
     * @param fecha Fecha de búsqueda.
     * @return Lista de citas correspondientes.
     * @throws IllegalArgumentException si la fecha es null.
     * @throws NoSuchElementException si no hay citas en esa fecha.
     */
    public ArrayList<Cita> getCitasPorFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("Fecha no puede ser null");
        }

        ArrayList<Cita> lista = new ArrayList<>();

        for (Cita c : citas) {
            if (c.getFecha().equals(fecha)) {
                lista.add(c);
            }
        }

        if (lista.isEmpty()) {
            throw new NoSuchElementException("No hay citas para la fecha: " + fecha);
        }

        return lista;
    }

    /**
     * Busca una cita según múltiples parámetros.
     *
     * @param dia Día de la cita.
     * @param hora Hora de la cita.
     * @param fecha Fecha de la cita.
     * @param idPaciente ID del paciente.
     * @param nombrePaciente Nombre del paciente.
     * @return Cita encontrada.
     * @throws IllegalArgumentException si algún parámetro es null.
     * @throws NoSuchElementException si no se encuentra coincidencia.
     */
    public Cita getCitaPorDatos(String dia, String hora, LocalDate fecha, int idPaciente, String nombrePaciente) {
        if (dia == null || hora == null || fecha == null || nombrePaciente == null) {
            throw new IllegalArgumentException("Los parámetros no pueden ser nulos");
        }
        for (Cita c : citas) {
            if (c.getDia().equalsIgnoreCase(dia) && c.getHora().equalsIgnoreCase(hora) && c.getFecha().equals(fecha)
                    && c.getPaciente().getId() == idPaciente && c.getPaciente().getNombre().equalsIgnoreCase(nombrePaciente)) {
                return c;
            }
        }
        throw new NoSuchElementException("No hay citas que coincidan con los datos proporcionados");
    }

    /**
     * Obtiene todas las citas asociadas a un médico específico.
     *
     * @param idMedico Código del médico.
     * @return Lista de citas asignadas a ese médico.
     * @throws NoSuchElementException si el médico no tiene citas.
     */
    public ArrayList<Cita> getCitasPorMedico(int idMedico) {
        ArrayList<Cita> lista = new ArrayList<>();

        for (Cita c : citas) {
            if (c.getMedico().getCodigo() == idMedico) {
                lista.add(c);
            }
        }

        if (lista.isEmpty()) {
            throw new NoSuchElementException("El médico con ID " + idMedico + " no tiene citas registradas");
        }

        return lista;
    }

    // REPORTES
    /**
     * Devuelve una lista de pacientes ordenada alfabéticamente por nombre.
     *
     * @return Lista ordenada de pacientes.
     */
    public ArrayList<Paciente> getPacientesOrdenados() {
        ArrayList<Paciente> copia = new ArrayList<>(pacientes);

        Collections.sort(copia, Comparator.comparing(Paciente::getNombre));

        return copia;
    }

    /**
     * Obtiene todas las citas filtradas por su estado (activa/cancelada).
     *
     * @param activa true para citas activas, false para canceladas.
     * @return Lista de citas que cumplen con el estado.
     * @throws NoSuchElementException si no hay citas con ese estado.
     */
    public ArrayList<Cita> getCitasPorEstado(boolean activa) {
        ArrayList<Cita> lista = new ArrayList<>();

        for (Cita c : citas) {
            if (c.getActiva() == activa) {
                lista.add(c);
            }
        }

        if (lista.isEmpty()) {
            throw new NoSuchElementException(
                    activa ? "No hay citas activas." : "No hay citas canceladas."
            );
        }

        return lista;
    }
}