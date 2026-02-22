/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.Cita;
import modelo.GestorArchivo;
import modelo.GestorDatos;
import modelo.Medico;
import modelo.Paciente;
import vista.VentanaPrincipal;
import vista.VistaCita;
import vista.VistaEliminar;
import vista.VistaLogin;
import vista.VistaMenu;
import vista.VistaRegistroMedico;
import vista.VistaRegistroObservacionesMedicas;
import vista.VistaRegistroPaciente;
import vista.VistaReporte;

/**
 *
 * @author Meowricio
 */
public class Controlador implements ActionListener {

    private GestorDatos gestorDatos;
    private VentanaPrincipal frame;
    private VistaLogin login;
    private VistaMenu menu;
    private VistaRegistroPaciente registroPaciente;
    private VistaRegistroMedico registroMedico;
    private VistaCita vistaCita;
    private VistaRegistroObservacionesMedicas registroObservaciones;
    private VistaReporte vistaReporte;
    private VistaEliminar vistaEliminar;
    private GestorArchivo gestorArchivo;

    public Controlador() {
        gestorDatos = new GestorDatos();
        frame = new VentanaPrincipal();
        login = new VistaLogin();
        menu = new VistaMenu();
        registroPaciente = new VistaRegistroPaciente();
        registroMedico = new VistaRegistroMedico();
        vistaCita = new VistaCita(gestorDatos);
        registroObservaciones = new VistaRegistroObservacionesMedicas(gestorDatos);
        vistaReporte = new VistaReporte(gestorDatos);
        vistaEliminar = new VistaEliminar(gestorDatos);
        gestorArchivo = new GestorArchivo();
        cargarDatosIniciales();

        login.getBtnIngresar().addActionListener(this);
        menu.getBtnCitas().addActionListener(this);
        menu.getBtnMenu().addActionListener(this);
        menu.getBtnRegistroPaciente().addActionListener(this);
        menu.getBtnRegistroMedico().addActionListener(this);
        menu.getBtnReportes().addActionListener(this);
        menu.getBtnArchivo().addActionListener(this);
        menu.getBtnEliminar().addActionListener(this);
        menu.getBntRegistrarObservacion().addActionListener(this);
        menu.getBtnEliminarArchivo().addActionListener(this);
        registroPaciente.getBtnMenu().addActionListener(this);
        registroPaciente.getBtnRegistrar().addActionListener(this);
        registroMedico.getBtnMenu().addActionListener(this);
        registroMedico.getBtnRegistrar().addActionListener(this);
        vistaCita.getBtnMenu().addActionListener(this);
        vistaCita.getBtnRegistrarCita().addActionListener(this);
        registroObservaciones.getBtnRegistrar().addActionListener(this);
        registroObservaciones.getBtnMenu().addActionListener(this);
        vistaReporte.getBtnMenu().addActionListener(this);
        vistaEliminar.getBtnMenu().addActionListener(this);
        vistaEliminar.getBtnPaciente().addActionListener(this);
        vistaEliminar.getBtnMedico().addActionListener(this);
        vistaEliminar.getBtnCita().addActionListener(this);

        frame.setContentPane(login);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == login.getBtnIngresar()) {
            cambiarPanel(menu);
        }

        if (e.getSource() == menu.getBtnCitas()) {
            cambiarPanel(vistaCita);
            vistaCita.iniciarListeners();
        }

        if (e.getSource() == menu.getBtnMenu()) {
            cambiarPanel(login);
        }

        if (e.getSource() == menu.getBtnRegistroPaciente()) {
            cambiarPanel(registroPaciente);
        }

        if (e.getSource() == menu.getBtnRegistroMedico()) {
            cambiarPanel(registroMedico);
        }

        if (e.getSource() == menu.getBntRegistrarObservacion()) {
            cambiarPanel(registroObservaciones);
            registroObservaciones.cargarCitas();
        }

        if (e.getSource() == menu.getBtnReportes()) {
            cambiarPanel(vistaReporte);
        }

        if (e.getSource() == menu.getBtnEliminar()) {
            cambiarPanel(vistaEliminar);
            vistaEliminar.cargarComboBox();
        }

        if (e.getSource() == menu.getBtnArchivo()) {
            try {
                gestorArchivo.guardarTodo(gestorDatos.getMedicos(), gestorDatos.getPacientes(), gestorDatos.getCitas());
                JOptionPane.showMessageDialog(menu, "Datos guardados correctamente en RegistroHospital.txt");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(menu, "Error al guardar datos: " + ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == menu.getBtnEliminarArchivo()) {
            try {
                gestorArchivo.eliminarArchivo();
                JOptionPane.showMessageDialog(menu, "Archivo eliminado correctamente.\n" + "Para ver los cambios reflejados debe reiniciar el programa,\n" + "o guardar lo actual y luego reiniciar.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(menu, "Error al eliminar archivo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == registroPaciente.getBtnMenu()) {
            cambiarPanel(menu);
        }

        if (e.getSource() == registroPaciente.getBtnRegistrar()) {
            try {
                registrarPaciente();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(registroPaciente, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == registroMedico.getBtnMenu()) {
            cambiarPanel(menu);
        }

        if (e.getSource() == registroMedico.getBtnRegistrar()) {
            try {
                registrarMedico();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(registroMedico, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == vistaCita.getBtnMenu()) {
            cambiarPanel(menu);
        }

        if (e.getSource() == vistaCita.getBtnRegistrarCita()) {
            try {
                registrarCita();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(registroMedico, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == registroObservaciones.getBtnMenu()) {
            cambiarPanel(menu);
        }

        if (e.getSource() == registroObservaciones.getBtnRegistrar()) {
            try {
                registrarObservacion();
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(registroObservaciones, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == vistaReporte.getBtnMenu()) {
            cambiarPanel(menu);
        }

        if (e.getSource() == vistaEliminar.getBtnMenu()) {
            cambiarPanel(menu);
        }

        if (e.getSource() == vistaEliminar.getBtnPaciente()) {
            eliminarPaciente();
        }

        if (e.getSource() == vistaEliminar.getBtnMedico()) {
            eliminarMedico();
        }

        if (e.getSource() == vistaEliminar.getBtnCita()) {
            cancelarCita();
        }
    }

    private void cambiarPanel(JPanel nuevo) {
        frame.setContentPane(nuevo);
        frame.revalidate();
        frame.repaint();
    }

    private void cargarDatosIniciales() {
        try {
            ArrayList<String> lineas = gestorArchivo.leerLineas();
            for (String linea : lineas) {
                Object obj = gestorArchivo.procesarLinea(linea, gestorDatos.getMedicos(), gestorDatos.getPacientes());
                if (obj instanceof Medico) {
                    gestorDatos.getMedicos().add((Medico) obj);
                } else if (obj instanceof Paciente) {
                    gestorDatos.getPacientes().add((Paciente) obj);
                } else if (obj instanceof Cita) {
                    gestorDatos.getCitas().add((Cita) obj);
                }
            }
            JOptionPane.showMessageDialog(vistaEliminar, "Archivo de Datos Cargado Correctamente");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarObservacion() {
        Object citaSel = registroObservaciones.getComboCitas().getSelectedItem();
        String observaciones = registroObservaciones.getTxtObservaciones().getText().trim();

        if (citaSel == null) {
            JOptionPane.showMessageDialog(registroObservaciones, "Debe seleccionar una cita, si no hay, registrela", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (observaciones.isEmpty()) {
            JOptionPane.showMessageDialog(registroObservaciones, "Debe agregar algo en Observaciones", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (observaciones.length() < 3) {
            JOptionPane.showMessageDialog(registroObservaciones, "Agregue algo más extenso en las Observaciones", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] partes = citaSel.toString().split(" - ");
        String dia = partes[0];
        String hora = partes[1];
        LocalDate fecha = LocalDate.parse(partes[2]);
        int id = Integer.parseInt(partes[3]);
        String nombre = partes[4];

        Cita c = gestorDatos.getCitaPorDatos(dia, hora, fecha, id, nombre);

        String actuales = c.getObservaciones();

        // Verificar si la Cita tenía Observaciones
        // Agregar en caso que existan o Setear si no tiene
        if (actuales != null && !actuales.isBlank()) {
            if (actuales.equalsIgnoreCase(observaciones.trim())) {
                registroObservaciones.getTxtObservaciones().setText("");
                JOptionPane.showMessageDialog(registroObservaciones,
                        "La observación que intenta agregar es la misma que la última registrada.\nPor favor escriba algo diferente.",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            } else {
                c.setObservaciones(actuales + "/" + observaciones.trim());
            }
        } else {
            c.setObservaciones(observaciones.trim());
        }
        registroObservaciones.getTxtObservaciones().setText("");
        JOptionPane.showMessageDialog(registroObservaciones, "Registro de Observación exitoso");
    }

    private void eliminarPaciente() {
        Object sel = vistaEliminar.getComboPacientes().getSelectedItem();
        if (sel == null) {
            JOptionPane.showMessageDialog(vistaEliminar, "Debe seleccionar un paciente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idPaciente = Integer.parseInt(sel.toString().split(" - ")[0]);
        try {
            Paciente p = gestorDatos.buscarPacientePorId(idPaciente);
            gestorDatos.getPacientes().remove(p); // Eliminar de la lista de Pacientes
            JOptionPane.showMessageDialog(vistaEliminar, "Paciente eliminado correctamente");
            vistaEliminar.getComboPacientes().removeItem(sel); // Refrescar combobox
        } catch (NoSuchElementException ex) {
            JOptionPane.showMessageDialog(vistaEliminar, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarMedico() {
        Object sel = vistaEliminar.getComboMedicos().getSelectedItem();
        if (sel == null) {
            JOptionPane.showMessageDialog(vistaEliminar, "Debe seleccionar un médico", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int codigoMedico = Integer.parseInt(sel.toString().split(" - ")[0]);
        try {
            Medico m = gestorDatos.buscarMedicoPorCodigo(codigoMedico);
            gestorDatos.getMedicos().remove(m); // ELiminar de la lista de Medicos
            JOptionPane.showMessageDialog(vistaEliminar, "Médico eliminado correctamente");
            vistaEliminar.getComboMedicos().removeItem(sel); // Refrescar combobox
        } catch (NoSuchElementException ex) {
            JOptionPane.showMessageDialog(vistaEliminar, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelarCita() {
        Object sel = vistaEliminar.getComboCitas().getSelectedItem();
        if (sel == null) {
            JOptionPane.showMessageDialog(vistaEliminar, "Debe seleccionar una cita", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[] partes = sel.toString().split(" \\| ");
        int idPaciente = Integer.parseInt(partes[0]);
        int codigoMedico = Integer.parseInt(partes[1]);
        LocalDate fecha = LocalDate.parse(partes[2]);
        String hora = partes[3];

        // Buscar la cita exacta
        try {
            Cita citaCancelar = null;
            for (Cita c : gestorDatos.getCitas()) {
                if (c.getPaciente().getId() == idPaciente
                        && c.getMedico().getCodigo() == codigoMedico
                        && c.getFecha().equals(fecha)
                        && c.getHora().equals(hora)
                        && c.getActiva()) {
                    citaCancelar = c;
                    break;
                }
            }

            if (citaCancelar != null) {
                citaCancelar.setActiva(false); // Anular Cita
                citaCancelar.getMedico().desocuparEspacio(citaCancelar.getDia(), citaCancelar.getHora()); // Desocupar agenda del Medico
                JOptionPane.showMessageDialog(vistaEliminar, "Cita cancelada correctamente");
                vistaEliminar.refrescarCitas(); // Refrescar combobox
            } else {
                JOptionPane.showMessageDialog(vistaEliminar, "No se encontró la cita seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vistaEliminar, "Error al cancelar la cita: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarCita() {
        Object diaSel = vistaCita.getComboDias().getSelectedItem();
        Object medicoSel = vistaCita.getComboCodigoMedico().getSelectedItem();
        Object horaSel = vistaCita.getComboHoras().getSelectedItem();
        Object pacienteSel = vistaCita.getComboPacientes().getSelectedItem();

        if (diaSel == null || medicoSel == null || horaSel == null || pacienteSel == null) {
            JOptionPane.showMessageDialog(vistaCita, "Debe seleccionar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String dia = diaSel.toString().split(" ")[0];
        LocalDate fecha = LocalDate.parse(diaSel.toString().split(" ")[1]);

        int idMedico = Integer.parseInt(medicoSel.toString().split(" - ")[0]);
        Medico medico = gestorDatos.buscarMedicoPorCodigo(idMedico);

        String horaCita = horaSel.toString();

        int idPaciente = Integer.parseInt(pacienteSel.toString().split(" - ")[0]);
        Paciente paciente = gestorDatos.buscarPacientePorId(idPaciente);

        // Validar que no exista ya una cita activa en ese espacio
        for (Cita c : gestorDatos.getCitas()) {
            if (c.getMedico().getCodigo() == idMedico
                    && c.getFecha().equals(fecha)
                    && c.getHora().equals(horaCita)
                    && c.getActiva()) {
                JOptionPane.showMessageDialog(vistaCita,
                        "Ya existe una cita activa en ese espacio",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        try {
            medico.ocuparEspacio(dia, horaCita);
            gestorDatos.agregarCita(new Cita(dia, horaCita, medico, paciente, fecha, true, ""));
            JOptionPane.showMessageDialog(vistaCita, "Registro exitoso");
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(vistaCita, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarMedico() throws IllegalArgumentException {
        String nombre = registroMedico.getTxtNombre().getText().trim();

        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        // Solo letras
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new IllegalArgumentException("El nombre solo puede contener letras y espacios");
        }

        // Separar el texto por palabras
        String[] partes = nombre.split("\\s+");
        if (partes.length < 3) {
            throw new IllegalArgumentException("Debe ingresar al menos un nombre y dos apellidos");
        }

        // Validar que las dos últimas partes sean apellidos
        String apellido1 = partes[partes.length - 2];
        String apellido2 = partes[partes.length - 1];
        if (apellido1.length() < 2 || apellido2.length() < 2) {
            throw new IllegalArgumentException("Los apellidos deben tener al menos 2 letras.");
        }

        String idTexto = registroMedico.getTxtId().getText().trim();
        if (idTexto.isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vacío.");
        }

        // Solo números
        if (!idTexto.matches("\\d+")) {
            throw new IllegalArgumentException("El ID solo puede contener números.");
        }

        // 9 dígitos exactos
        if (idTexto.length() != 9) {
            throw new IllegalArgumentException("El ID debe tener exactamente 9 dígitos.");
        }

        int id = Integer.parseInt(idTexto);
        Integer edad = (Integer) registroPaciente.getComboEdad().getSelectedItem();
        if (edad == null) {
            throw new IllegalArgumentException("Debe seleccionar una edad.");
        }

        String codTexto = registroMedico.getTxtCodigo().getText().trim();
        if (codTexto.isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío.");
        }
        //Solo números
        if (!codTexto.matches("\\d+")) {
            throw new IllegalArgumentException("El código solo puede contener números.");
        }
        // Tamaño 4
        if (codTexto.length() != 4) {
            throw new IllegalArgumentException("El código debe tener exactamente 4 dígitos.");
        }
        int codigo = Integer.parseInt(codTexto);

        String horario = registroMedico.getComboHorario().getSelectedItem().toString();
        if (horario == null) {
            throw new IllegalArgumentException("Debe seleccionar un horario");
        }

        String especialidad = registroMedico.getComboEspecialidad().getSelectedItem().toString();
        if (especialidad == null) {
            throw new IllegalArgumentException("Debe seleccionar una especialidad");
        }

        // Validar si existe ya
        if (gestorDatos.existeMedicoCodigo(codigo)) {
            JOptionPane.showMessageDialog(registroMedico, "Ya existe un medico registrado con ese código", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (gestorDatos.existeMedico(id)) {
            JOptionPane.showMessageDialog(registroMedico, "Ya existe un medico registrado con esa identificación", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Registra
        gestorDatos.agregarMedico(new Medico(id, nombre, edad, codigo, especialidad, horario));
        JOptionPane.showMessageDialog(registroMedico, "Registro exitoso");
    }

    private void registrarPaciente() throws IllegalArgumentException {
        String nombre = registroPaciente.getTxtNombre().getText().trim();
        if (nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        // Solo letras
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new IllegalArgumentException("El nombre solo puede contener letras y espacios");
        }
        String[] partes = nombre.split("\\s+");
        // Almenos 1 nombre y 2 apellidos
        if (partes.length < 3) {
            throw new IllegalArgumentException("Debe ingresar al menos un nombre y dos apellidos");
        }
        // Validar que las dos últimas partes sean apellidos
        String apellido1 = partes[partes.length - 2];
        String apellido2 = partes[partes.length - 1];

        if (apellido1.length() < 2 || apellido2.length() < 2) {
            throw new IllegalArgumentException("Los apellidos deben tener al menos 2 letras.");
        }

        // Validacion ID
        String idTexto = registroPaciente.getTxtId().getText().trim();
        if (idTexto.isEmpty()) {
            throw new IllegalArgumentException("El ID no puede estar vacío.");
        }

        // Solo números
        if (!idTexto.matches("\\d+")) {
            throw new IllegalArgumentException("El ID solo puede contener números.");
        }
        // 9 dígitos exactos
        if (idTexto.length() != 9) {
            throw new IllegalArgumentException("El ID debe tener exactamente 9 dígitos.");
        }
        int id = Integer.parseInt(idTexto);

        // Validacion Contacto
        String contactoTexto = registroPaciente.getTxtContacto().getText().trim();
        if (contactoTexto.isEmpty()) {
            throw new IllegalArgumentException("El # no puede estar vacío");
        }
        // Solo números
        if (!contactoTexto.matches("\\d+")) {
            throw new IllegalArgumentException("El # solo puede contener números");
        }
        // 9 dígitos exactos
        if (contactoTexto.length() != 8) {
            throw new IllegalArgumentException("El # debe tener exactamente 8 dígitos, sin espacios");
        }
        int contacto = Integer.parseInt(contactoTexto);

        // ValidarEdad
        Integer edad = (Integer) registroPaciente.getComboEdad().getSelectedItem();
        if (edad == null) {
            throw new IllegalArgumentException("Debe seleccionar una edad.");
        }

        // Validar si existe ya
        if (gestorDatos.existePaciente(id)) {
            JOptionPane.showMessageDialog(registroPaciente, "Ya existe un paciente registrado con esa identificación.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Registra
        gestorDatos.agregarPaciente(new Paciente(id, nombre, edad, contacto));
        JOptionPane.showMessageDialog(registroPaciente, "Registro exitoso");
    }
}
