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

public class GestorDatos {

    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Medico> medicos = new ArrayList<>();
    private ArrayList<Cita> citas = new ArrayList<>();

    //PACIENTES

    public void agregarPaciente(Paciente p) {
        if (p == null)
            throw new IllegalArgumentException("Paciente no puede ser null");

        pacientes.add(p);
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public Paciente buscarPacientePorId(int id) throws NoSuchElementException {
        for (Paciente p : pacientes) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new NoSuchElementException("No existe un paciente con ID: " + id);
    }
    
    public boolean existePaciente(int id) {
        for (Paciente p : pacientes) {
            if(p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    //MEDICOS

    public void agregarMedico(Medico m) {
        if (m == null)
            throw new IllegalArgumentException("Médico no puede ser null");

        medicos.add(m);
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }
    
    public boolean existeMedicoCodigo(int codigo) {
        for (Medico m : medicos) {
            if(m.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }
    
    public Medico buscarMedicoPorCodigo(int codigo) throws NoSuchElementException {
        for (Medico m : medicos) {
            if(m.getCodigo() == codigo) {
                return m;
            }
        }
        throw new NoSuchElementException("No existe un Medico con ese Código: " + codigo);
    }
    
    public boolean existeMedico(int id) {
        for (Medico m : medicos) {
            if(m.getId() == id) {
                return true;
            }
        }
        return false;
    }
    

    public ArrayList<Medico> getMedicosPorEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.isBlank())
            throw new IllegalArgumentException("Especialidad inválida");

        ArrayList<Medico> lista = new ArrayList<>();

        for (Medico m : medicos) {
            if (m.getEspecialidad().equalsIgnoreCase(especialidad)) {
                lista.add(m);
            }
        }

        if (lista.isEmpty())
            throw new NoSuchElementException("No hay médicos con especialidad: " + especialidad);

        return lista;
    }

    //CITAS

    public void agregarCita(Cita c) {
        if (c == null)
            throw new IllegalArgumentException("Cita no puede ser null");

        citas.add(c);
    }
    
    public boolean existeCita(Paciente paciente, Medico medico, LocalDate fecha, String hora) {
        for (Cita c : citas) {
            if (c.getPaciente().getId() == paciente.getId()
                && c.getMedico().getCodigo() == medico.getCodigo()
                && c.getFecha().equals(fecha)
                && c.getHora().equals(hora)) {
                return true; // ya existe la cita
            }
        }
        return false; // no existe
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public ArrayList<Cita> getCitasPorFecha(LocalDate fecha) {
        if (fecha == null)
            throw new IllegalArgumentException("Fecha no puede ser null");

        ArrayList<Cita> lista = new ArrayList<>();

        for (Cita c : citas) {
            if (c.getFecha().equals(fecha)) {
                lista.add(c);
            }
        }

        if (lista.isEmpty())
            throw new NoSuchElementException("No hay citas para la fecha: " + fecha);

        return lista;
    }
    
    public Cita getCitaPorDatos(String dia, String hora, LocalDate fecha, int idPaciente, String nombrePaciente) {
        if (dia == null || hora == null || fecha == null || nombrePaciente == null) {
            throw new IllegalArgumentException("Los parámetros no pueden ser nulos");
        }
        for (Cita c : citas) {
            if (c.getDia().equalsIgnoreCase(dia) && c.getHora().equalsIgnoreCase(hora) && c.getFecha().equals(fecha) && c.getPaciente().getId() == idPaciente && c.getPaciente().getNombre().equalsIgnoreCase(nombrePaciente)) {
                return c;
            }
        }
        throw new NoSuchElementException("No hay citas que coincidan con los datos proporcionados");
    }


    public ArrayList<Cita> getCitasPorMedico(int idMedico) {
        ArrayList<Cita> lista = new ArrayList<>();

        for (Cita c : citas) {
            if (c.getMedico().getCodigo() == idMedico) {
                lista.add(c);
            }
        }

        if (lista.isEmpty())
            throw new NoSuchElementException("El médico con ID " + idMedico + " no tiene citas registradas");

        return lista;
    }

    //REPORTES

    public ArrayList<Paciente> getPacientesOrdenados() {
        ArrayList<Paciente> copia = new ArrayList<>(pacientes);

        Collections.sort(copia, Comparator.comparing(Paciente::getNombre));

        return copia;
    }

    // Citas activas o canceladas
    
    public ArrayList<Cita> getCitasPorEstado(boolean activa) {
        ArrayList<Cita> lista = new ArrayList<>();

        for (Cita c : citas) {
            if (c.getActiva() == activa) {
                lista.add(c);
            }
        }

        if (lista.isEmpty())
            throw new NoSuchElementException(
                activa ? "No hay citas activas." : "No hay citas canceladas."
            );

        return lista;
    }
}
