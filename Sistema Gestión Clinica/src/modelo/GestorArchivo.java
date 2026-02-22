/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Clase encargada de gestionar la lectura, escritura y eliminación del archivo
 * donde se almacena la información del sistema hospitalario. Permite guardar
 * médicos, pacientes y citas en un archivo de texto, además de procesar líneas
 * para reconstruir objetos.
 * 
 * @author Mauricio León Bermúdez C5G444
 */
public class GestorArchivo {

    private static final String ARCHIVO = "RegistroHospital.txt";

    /**
     * Guarda en el archivo todos los médicos, pacientes y citas proporcionados.
     * Reemplaza el contenido previo del archivo.
     *
     * @param medicos Lista de médicos a guardar.
     * @param pacientes Lista de pacientes a guardar.
     * @param citas Lista de citas a guardar.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public void guardarTodo(ArrayList<Medico> medicos, ArrayList<Paciente> pacientes, ArrayList<Cita> citas) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO, false))) {
            // Guardar médicos
            for (Medico m : medicos) {
                bw.write("MEDICO;" + m.getId() + ";" + m.getCodigo() + ";" + m.getNombre() + ";"
                        + m.getEdad() + ";" + m.getEspecialidad() + ";" + m.getTurno());
                bw.newLine();
            }

            // Guardar pacientes
            for (Paciente p : pacientes) {
                bw.write("PACIENTE;" + p.getId() + ";" + p.getNombre() + ";"
                        + p.getEdad() + ";" + p.getContacto());
                bw.newLine();
            }

            // Guardar citas
            for (Cita c : citas) {
                bw.write("CITA;" + c.getDia() + ";" + c.getHora() + ";" + c.getFecha() + ";"
                        + c.getPaciente().getId() + ";" + c.getMedico().getCodigo() + ";"
                        + (c.getActiva() ? "ACTIVA" : "CANCELADA") + ";"
                        + (c.getObservaciones() == null ? "" : c.getObservaciones()));
                bw.newLine();
            }
        }
    }

    /**
     * Procesa una línea del archivo y reconstruye el objeto correspondiente:
     * Médico, Paciente o Cita. También actualiza la agenda del médico si la
     * cita está activa.
     *
     * @param linea Línea leída del archivo.
     * @param medicos Lista donde se almacenan médicos ya creados.
     * @param pacientes Lista donde se almacenan pacientes ya creados.
     * @return El objeto creado a partir de la línea o null si no coincide con
     * ningún tipo válido.
     */
    public Object procesarLinea(String linea, ArrayList<Medico> medicos, ArrayList<Paciente> pacientes) {
        int id;
        int codigo;
        int edad;
        String[] partes = linea.split(";");
        switch (partes[0]) {
            case "MEDICO":
                id = Integer.parseInt(partes[1]);
                codigo = Integer.parseInt(partes[2]);
                String nombreM = partes[3];
                edad = Integer.parseInt(partes[4]);
                String especialidad = partes[5];
                String turno = partes[6];
                return new Medico(id, nombreM, edad, codigo, especialidad, turno);

            case "PACIENTE":
                id = Integer.parseInt(partes[1]);
                String nombreP = partes[2];
                edad = Integer.parseInt(partes[3]);
                int contacto = Integer.parseInt(partes[4]);
                return new Paciente(id, nombreP, edad, contacto);

            case "CITA":
                String dia = partes[1];
                String hora = partes[2];
                LocalDate fecha = LocalDate.parse(partes[3]);
                int idPaciente = Integer.parseInt(partes[4]);
                int codigoMedico = Integer.parseInt(partes[5]);
                boolean activa = partes[6].trim().equalsIgnoreCase("ACTIVA");
                String observaciones = partes.length > 7 ? partes[7] : "";

                Paciente p = pacientes.stream()
                        .filter(pa -> pa.getId() == idPaciente)
                        .findFirst()
                        .orElse(null);
                Medico m = medicos.stream()
                        .filter(me -> me.getCodigo() == codigoMedico)
                        .findFirst()
                        .orElse(null);

                if (p != null && m != null) {
                    Cita cita = new Cita(dia, hora, m, p, fecha, activa, observaciones);

                    // Si está activo, ocupa el espacio
                    if (activa) {
                        try {
                            m.ocuparEspacio(dia, hora);
                        } catch (IllegalStateException ex) {
                            System.out.println("Advertencia: espacio ya ocupado al cargar archivo -> " + ex.getMessage());
                        }
                    }

                    return cita;
                }

                break;
        }
        return null;
    }

    /**
     * Lee todas las líneas del archivo de registro y las devuelve en una lista.
     *
     * @return Lista de líneas encontradas en el archivo.
     * @throws IOException Si ocurre un error al leer el archivo.
     */
    public ArrayList<String> leerLineas() throws IOException {
        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }

    /**
     * Elimina el archivo de registro si existe.
     *
     * @throws IOException Si el archivo no existe o no se puede eliminar.
     */
    public void eliminarArchivo() throws IOException {
        File archivo = new File(ARCHIVO);
        if (archivo.exists()) {
            if (!archivo.delete()) {
                throw new IOException("No se pudo eliminar el archivo.");
            }
        } else {
            throw new IOException("El archivo no existe.");
        }
    }
}
