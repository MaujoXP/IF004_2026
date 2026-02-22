/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import javax.swing.JButton;
import modelo.Cita;
import modelo.GestorDatos;
import modelo.Medico;
import modelo.Paciente;

/**
 *
 * @author Meowricio
 */
public class VistaReporte extends javax.swing.JPanel {
    
    private GestorDatos gestorDatos;
    /**
     * Creates new form VistaReporte
     */
    public VistaReporte(GestorDatos gestorDatos) {
        this.gestorDatos = gestorDatos;
        initComponents();
        comboReporte.addActionListener(e -> {
            int opcion = comboReporte.getSelectedIndex();

            switch(opcion) {
                case 0:
                    cargarPacientesOrdenados();
                    break;
                case 1:
                    cargarMedicosPorEspecialidad();
                    break;
                case 2:
                    cargarCitasPorMedico();
                    break;
                case 3:
                    cargarHistorialClinico();
                    break;
                case 4:
                    cargarReporteEstadoCitas();
                    break;
                default:
                    break;
            }
        });
    }
    
    private void cargarPacientesOrdenados() {
        ArrayList<Paciente> pacientes = gestorDatos.getPacientesOrdenados();
        StringBuilder msg = new StringBuilder();

        if (pacientes.isEmpty()) {
            msg.append("No hay pacientes registrados.").append(System.lineSeparator());
        } else {
            for (Paciente p : pacientes) {
                msg.append(p).append(System.lineSeparator());
            }
        }

        txtReporte.setText(msg.toString());
    }

    private void cargarMedicosPorEspecialidad() {
        String[] especialidades = {
            "Medicina General",
            "Pediatría",
            "Ortopedia",
            "Cardiología",
            "Ginecología",
            "Cirugía General"
        };

        StringBuilder msg = new StringBuilder();

        for (String esp : especialidades) {
            msg.append("Especialidad: ").append(esp).append(System.lineSeparator());
            try {
                ArrayList<Medico> medicos = gestorDatos.getMedicosPorEspecialidad(esp);
                for (Medico m : medicos) {
                    msg.append(m.toString()).append(System.lineSeparator());
                }
                msg.append("Total de médicos: ").append(medicos.size())
                   .append(System.lineSeparator());
            } catch (NoSuchElementException ex) {
                msg.append("No hay médicos registrados en esta especialidad")
                   .append(System.lineSeparator());
            }
            msg.append(System.lineSeparator());
        }

        txtReporte.setText(msg.toString());
    }


    
    private void cargarCitasPorMedico() {
        ArrayList<Medico> medicos = gestorDatos.getMedicos();
        StringBuilder msg = new StringBuilder();

        if (medicos.isEmpty()) {
            msg.append("No hay médicos registrados en el sistema.")
               .append(System.lineSeparator());
        } else {
            for (Medico m : medicos) {
                msg.append("Médico: ").append(m.getNombre())
                   .append(" (ID: ").append(m.getCodigo())
                   .append(" - Especialidad: ").append(m.getEspecialidad())
                   .append(")").append(System.lineSeparator());

                try {
                    ArrayList<Cita> citasMedico = gestorDatos.getCitasPorMedico(m.getCodigo());
                    for (Cita c : citasMedico) {
                        msg.append(c.toString())
                           .append(System.lineSeparator());
                    }
                    msg.append("Total de citas: ").append(citasMedico.size())
                       .append(System.lineSeparator());
                } catch (NoSuchElementException ex) {
                    msg.append("No tiene citas registradas")
                       .append(System.lineSeparator());
                }

                msg.append(System.lineSeparator()); // separación entre médicos
            }
        }

        txtReporte.setText(msg.toString());
    }
    
    private void cargarHistorialClinico() {
        ArrayList<Paciente> pacientesOrdenados = gestorDatos.getPacientesOrdenados();
        StringBuilder msg = new StringBuilder();

        if (pacientesOrdenados.isEmpty()) {
            msg.append("No hay pacientes registrados.")
               .append(System.lineSeparator());
        } else {
            for (Paciente p : pacientesOrdenados) {
                msg.append("Paciente: ").append(p.getNombre())
                   .append(" (ID: ").append(p.getId()).append(")")
                   .append(System.lineSeparator());

                // Buscar todas las citas de este paciente
                ArrayList<Cita> citasPaciente = new ArrayList<>();
                for (Cita c : gestorDatos.getCitas()) {
                    if (c.getPaciente().getId() == p.getId()) {
                        citasPaciente.add(c);
                    }
                }

                if (citasPaciente.isEmpty()) {
                    msg.append("No tiene citas registradas")
                       .append(System.lineSeparator());
                }

                for (Cita c : citasPaciente) {
                    msg.append("Fecha: ").append(c.getFecha())
                       .append(" | Hora: ").append(c.getHora())
                       .append(System.lineSeparator());
                    msg.append("Médico: ").append(c.getMedico().getNombre())
                       .append(" - ").append(c.getMedico().getEspecialidad())
                       .append(System.lineSeparator());
                    msg.append("Observaciones: ")
                       .append(c.getObservaciones() != null ? c.getObservaciones() : "Ninguna")
                       .append(System.lineSeparator());
                    msg.append("Estado: ").append(c.getActiva() ? "Activa" : "Cancelada")
                       .append(System.lineSeparator());
                    msg.append(System.lineSeparator());
                }
                msg.append(System.lineSeparator()); // separación entre pacientes
            }
        }

        txtReporte.setText(msg.toString());
    }

    
    private void cargarReporteEstadoCitas() {
        StringBuilder msg = new StringBuilder();

        // Reporte de citas activas
        msg.append("Citas Activas:").append(System.lineSeparator());
        try {
            ArrayList<Cita> activas = gestorDatos.getCitasPorEstado(true);
            for (Cita c : activas) {
                msg.append(c.toString()).append(System.lineSeparator());
            }
            msg.append("Total de citas activas: ").append(activas.size())
               .append(System.lineSeparator());
        } catch (NoSuchElementException ex) {
            msg.append("No hay citas activas.").append(System.lineSeparator());
        }

        msg.append(System.lineSeparator());

        // Reporte de citas canceladas
        msg.append("Citas Canceladas:").append(System.lineSeparator());
        try {
            ArrayList<Cita> canceladas = gestorDatos.getCitasPorEstado(false);
            for (Cita c : canceladas) {
                msg.append(c.toString()).append(System.lineSeparator());
            }
            msg.append("Total de citas canceladas: ").append(canceladas.size())
               .append(System.lineSeparator());
        } catch (NoSuchElementException ex) {
            msg.append("No hay citas canceladas.").append(System.lineSeparator());
        }

        txtReporte.setText(msg.toString());
    }


    public JButton getBtnMenu() {
        return btnMenu;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboReporte = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtReporte = new javax.swing.JTextArea();
        btnMenu = new javax.swing.JButton();

        jLabel1.setText("Seleccione el Reporte que desea ver:");

        comboReporte.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pacientes en Orden Alfabetico", "Medicos por Especialidad", "Citas por Médico", "Historial Clinico de Paciente", "Reporte Citas Atendidas/Canceladas" }));

        txtReporte.setColumns(20);
        txtReporte.setRows(5);
        jScrollPane1.setViewportView(txtReporte);

        btnMenu.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboReporte, 0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addGap(159, 159, 159))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JComboBox<String> comboReporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtReporte;
    // End of variables declaration//GEN-END:variables
}
