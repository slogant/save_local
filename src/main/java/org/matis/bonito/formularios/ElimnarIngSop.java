/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.matis.bonito.formularios;

import java.awt.Color;
import static java.awt.Toolkit.getDefaultToolkit;
import static java.lang.StringTemplate.STR;
import static java.lang.System.out;
import java.util.Objects;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.table.DefaultTableModel;
import org.matis.bonito.controller.IngSopController;
import org.matis.bonito.validador.ForcedListSelectionModel;

/**
 *
 * @author oscar
 */
public class ElimnarIngSop extends javax.swing.JDialog {

    /**
     * Creates new form ElimnarIngSop
     *
     * @param parent
     * @param modal
     */
    public ElimnarIngSop(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = new DefaultTableModel(null, new Object[]{"Nombre", "Apellido Paterno", "Apellido Materno", "Número de empleado"});
        cargaMisComponente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        textNumEmpleado = new javax.swing.JTextField();
        scroll = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        eliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eliminar");
        setLocationByPlatform(true);
        setModal(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);

        jLabel1.setText("Número Emp: ");

        textNumEmpleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textNombreFocusLost(evt);
            }
        });
        textNumEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBuscarNumEmpKeyReleased(evt);
            }
        });

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        scroll.setViewportView(tabla);

        eliminar.setMnemonic('E');
        eliminar.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNumEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(eliminar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textNumEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eliminar)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(525, 343));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cargaMisComponente() {
        textNumEmpleado.requestFocus();
        tabla.setDefaultEditor(Object.class, null);
        tabla.setSelectionModel(new ForcedListSelectionModel());
        eliminar.setEnabled(false);
        textNumEmpleado.addActionListener(e -> {
            var numEmp = textNumEmpleado.getText();
            if ("".equals(numEmp)) {
                showMessageDialog(this, "El número de empleado esta vacío", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                textNumEmpleado.requestFocus();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });
        eliminar.addActionListener(e -> eliminado());
    }


    private void textBuscarNumEmpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscarNumEmpKeyReleased
        // TODO add your handling code here:
        var empleadoEncontrado = textNumEmpleado.getText();
        var ingSopController = new IngSopController();
        if (!empleadoEncontrado.isEmpty()) {
            var emp = ingSopController.otenerIngSopNumEmp(empleadoEncontrado);
            if (emp != null) {
                emp.filter(Objects::nonNull).forEach(e -> model.addRow(new Object[]{e.getNombre_ing(), e.getApellido_pat(), e.getApellido_mat(), e.getNumero_empleado()}));
                tabla.setModel(model);
            } else if (emp.count() == 0) {
                out.println(STR."Sin registro.....\{emp.count()
                
                }");
                var dm = (DefaultTableModel) tabla.getModel();
                model.setRowCount(0);
                tabla.setModel(dm);
                tabla.updateUI();
            }
        } else {
            var dm = (DefaultTableModel) tabla.getModel();
            model.setRowCount(0);
            tabla.setModel(dm);
            tabla.updateUI();
            out.println("Registro no encontrado");
            eliminar.setEnabled(false);
        }
    }//GEN-LAST:event_textBuscarNumEmpKeyReleased

    private void textNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textNombreFocusLost
        // TODO add your handling code here:
        var nombre = textNumEmpleado.getText();
        if (nombre.equals("")) {
            showMessageDialog(this, "El campo nombre está vacío", "Monitor", ERROR_MESSAGE);
            getDefaultToolkit().beep();
            textNumEmpleado.requestFocus();
        } else {
            ((JComponent) evt.getSource()).transferFocus();
        }
    }//GEN-LAST:event_textNombreFocusLost

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        if (tabla.getModel() != null) {
            var seleccion = tabla.getSelectedRow();
            if (seleccion >= 0) {
                eliminar.setEnabled(true);
            }
        } else {
            out.println("Error.........................");
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void eliminado() {
        if (tabla.getModel() != null) {
            var seleccion = tabla.getSelectedRow();
            if (seleccion >= 0) {
                var ingSopController = new IngSopController();
                var numemp = tabla.getValueAt(seleccion, 3).toString();
                if (!numemp.isEmpty()) {
                    if (ingSopController.eliminarIngsop(numemp)) {
                        JOptionPane.showMessageDialog(this, "Registro eliminado", "Monitor", JOptionPane.INFORMATION_MESSAGE);
                        eliminar.setEnabled(false);
                        textNumEmpleado.requestFocus();
                        textNumEmpleado.setText("");
                        var dm = (DefaultTableModel) tabla.getModel();
                        model.setRowCount(0);
                        tabla.setModel(dm);
                        tabla.updateUI();
                    } else {
                        JOptionPane.showMessageDialog(this, "No se logro eliminar registro", "Monitor", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } else {
            out.println("Error.........................");
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField textNumEmpleado;
    // End of variables declaration//GEN-END:variables

    private final DefaultTableModel model;
}
