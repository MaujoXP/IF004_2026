/*
 * VistaCita es un panel gráfico encargado de gestionar la creación de citas
 * médicas del sistema hospitalario. Permite seleccionar:
 * - El día disponible para la cita (solo próximos 7 días)
 * - El médico por especialidad
 * - Las horas disponibles del médico ese día
 * - El paciente que recibirá la cita
 */
package vista;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.EspacioAgenda;
import modelo.GestorDatos;
import modelo.Medico;
import modelo.Paciente;

/*
 * VistaCita es un panel gráfico encargado de gestionar la creación de citas
 * médicas del sistema hospitalario.
 *
 * @author Mauricio León Bermúdez C5G444
 */
public class VistaCita extends javax.swing.JPanel {

    private GestorDatos gestorDatos;

    /**
     * Constructor del panel VistaCita.
     * @param gestorDatos objeto administrador con acceso a médicos, pacientes y citas.
     */
    public VistaCita(GestorDatos gestorDatos) {
        this.gestorDatos = gestorDatos;
        initComponents();

    }

    /**
     * Inicia los listeners de los componentes visuales.
     * Configura el comportamiento de los combos al seleccionar días o médicos.
     */
    public void iniciarListeners() {
        colocarCitasDisponibles();
        cargarMedicos();
        cargarPacientes();
        comboDias.addActionListener(e -> {
            if (comboDias.getSelectedItem() == null) {
                return;
            }
            String texto = comboDias.getSelectedItem().toString();
            String fechaStr = texto.split(" ")[1];
            LocalDate fecha = LocalDate.parse(fechaStr);

            if (comboCodigoMedico.getSelectedItem() != null) {
                actualizarHorasDisponibles(fecha);
            }
        });

        comboCodigoMedico.addActionListener(e -> {
            if (comboDias.getSelectedItem() == null) {
                return;
            }
            String texto = comboDias.getSelectedItem().toString();
            String fechaStr = texto.split(" ")[1];
            LocalDate fecha = LocalDate.parse(fechaStr);

            actualizarHorasDisponibles(fecha);
        });

    }

    /**
     * Carga en el combo todos los médicos del sistema ordenados por especialidad.
     */
    private void cargarMedicos() {
        comboCodigoMedico.removeAllItems();

        String[] especialidades = {"Medicina General", "Pediatría", "Ortopedia", "Cardiología", "Ginecología", "Cirugía General"};

        for (String esp : especialidades) {
            try {
                ArrayList<Medico> lista = gestorDatos.getMedicosPorEspecialidad(esp);

                for (Medico m : lista) {
                    comboCodigoMedico.addItem(m.getCodigo() + " - " + m.getNombre());
                }

            } catch (NoSuchElementException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Carga todos los pacientes registrados en el sistema.
     */
    private void cargarPacientes() {
        comboPacientes.removeAllItems();
        ArrayList<Paciente> lista = gestorDatos.getPacientes();

        for (Paciente p : lista) {
            comboPacientes.addItem(p.getId() + " - " + p.getNombre());
        }
    }

    /**
     * Actualiza el combo de horas disponibles según el médico y el día elegido.
     * @param fecha día seleccionado por el usuario.
     */
    private void actualizarHorasDisponibles(LocalDate fecha) {
        comboHoras.removeAllItems();

        if (comboCodigoMedico.getSelectedItem() == null) {
            return;
        }

        int indiceDia = fecha.getDayOfWeek().ordinal();
        int codigo = Integer.parseInt(comboCodigoMedico.getSelectedItem().toString().split(" - ")[0]);
        Medico m = gestorDatos.buscarMedicoPorCodigo(codigo);

        boolean agregado = false;
        for (int c = 0; c < 8; c++) {
            EspacioAgenda espacio = m.getHorario()[indiceDia][c];
            if (espacio.isDisponible()) {
                comboHoras.addItem(espacio.getHora());
                agregado = true;
            }
        }

        if (!agregado) {
            comboHoras.addItem("No hay horas disponibles");
        }
    }

    /**
     * Rellena los próximos 7 días como opciones para agendar citas.
     */
    private void colocarCitasDisponibles() {
        comboDias.removeAllItems();
        LocalDate hoy = LocalDate.now();
        LocalDate dia = hoy.plusDays(1); // Dia de mañana

        for (int i = 0; i < 7; i++) {
            comboDias.addItem(formatearDia(dia));
            dia = dia.plusDays(1);
        }

        if (comboDias.getItemCount() > 0) {
            comboDias.setSelectedIndex(0);
        }
    }

    /**
     * Convierte la fecha a formato: "DIA YYYY-MM-DD"
     * @param d fecha
     * @return texto formateado
     */
    private String formatearDia(LocalDate d) {
        String nombre = d.getDayOfWeek().toString().toUpperCase();
        return nombre + " " + d.toString();
    }

    public GestorDatos getGestorDatos() {
        return gestorDatos;
    }

    public JButton getBtnMenu() {
        return btnMenu;
    }

    public JButton getBtnRegistrarCita() {
        return btnRegistrarCita;
    }

    public JComboBox<String> getComboCodigoMedico() {
        return comboCodigoMedico;
    }

    public JComboBox<String> getComboDias() {
        return comboDias;
    }

    public JComboBox<String> getComboHoras() {
        return comboHoras;
    }

    public JComboBox<String> getComboPacientes() {
        return comboPacientes;
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
        comboDias = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        comboCodigoMedico = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        comboHoras = new javax.swing.JComboBox<>();
        comboPacientes = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnRegistrarCita = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();

        jLabel1.setText("Días para agendar cita:");

        jLabel2.setText("Médico Especialista:");

        jLabel3.setText("Horas Disponibles:");

        jLabel4.setText("Paciente a Agendar:");

        btnRegistrarCita.setText("Registrar Cita");

        btnMenu.setText("Volver");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboDias, 0, 238, Short.MAX_VALUE)
                    .addComponent(comboCodigoMedico, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboHoras, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboPacientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(btnRegistrarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnMenu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboDias, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboCodigoMedico, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboHoras, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboPacientes, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnRegistrarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMenu)
                        .addContainerGap())))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnRegistrarCita;
    private javax.swing.JComboBox<String> comboCodigoMedico;
    private javax.swing.JComboBox<String> comboDias;
    private javax.swing.JComboBox<String> comboHoras;
    private javax.swing.JComboBox<String> comboPacientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
