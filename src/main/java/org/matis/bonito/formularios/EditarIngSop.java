/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.matis.bonito.formularios;

import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.matis.bonito.controller.IngSopController;
import org.matis.bonito.model.IngenieroSoporte;

import static java.awt.Toolkit.getDefaultToolkit;
import static java.lang.System.out;
import java.util.Objects;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import org.matis.bonito.validador.ForcedListSelectionModel;
import org.matis.bonito.validador.JTextFieldLimit;
import org.matis.bonito.validador.LimitandorTexto;

/**
 *
 * @author oscar
 */
public class EditarIngSop extends javax.swing.JDialog {

    public EditarIngSop(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = new DefaultTableModel(null, new Object[]{"Nombre", "Apellido Paterno", "Apellido Materno", "Número de empleado"});
        cargandoMisComponentes();
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
        comboEmpleado = new javax.swing.JComboBox<>();
        scroll = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        textBuscarNumEmp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textApePat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textApeMat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textNumEmp = new javax.swing.JTextField();
        btnSave = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar");
        setLocationByPlatform(true);
        setModal(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setText("Numero empleado: ");

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        scroll.setViewportView(tabla);

        textBuscarNumEmp.setDocument(new JTextFieldLimit(8,true));
        textBuscarNumEmp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textBuscarNumEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textBuscarNumEmpKeyReleased(evt);
            }
        });

        jLabel2.setText("Nombre: ");

        textNombre.setDocument(new LimitandorTexto(textNombre,35));
        textNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textNombreFocusLost(evt);
            }
        });

        jLabel3.setText("Apellido Paterno: ");

        textApePat.setDocument(new LimitandorTexto(textApePat, 30));
        textApePat.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel4.setText("Apellido Materno: ");

        textApeMat.setDocument(new LimitandorTexto(textApeMat,35));
        textApeMat.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel5.setText("Número emp: ");

        textNumEmp.setDocument(new JTextFieldLimit(8, true));
        textNumEmp.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnSave.setMnemonic('A');
        btnSave.setText("Actualizar");

        cerrar.setMnemonic('e');
        cerrar.setText("Cerrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textBuscarNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(194, 194, 194)
                                .addComponent(comboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel5)
                                        .addGap(25, 25, 25))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(textNumEmp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                                        .addComponent(textApeMat, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textApePat, javax.swing.GroupLayout.Alignment.LEADING)))))
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(cerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave))
                    .addComponent(scroll))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textBuscarNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textApePat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textApeMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSave)
                    .addComponent(cerrar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(643, 383));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cargandoMisComponentes() {
        var ing = new IngSopController();
        tabla.setDefaultEditor(Object.class, null);
        tabla.setSelectionModel(new ForcedListSelectionModel());
        tabla.setFocusable(false);
        tabla.setRowSelectionAllowed(true);
        tabla.setDefaultEditor(Object.class, null);
        btnSave.setEnabled(false);
        textNombre.addActionListener(e -> {
            var textnombre = textNombre.getText();
            if (textnombre.isEmpty()) {
                showMessageDialog(this, "El campo nombre está vacío", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                textNombre.requestFocus();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });
        textApePat.addActionListener(e -> {
            var textapellidopaterno = textApePat.getText();
            if (textapellidopaterno.isEmpty()) {
                showMessageDialog(this, "El campo apellido paterno está vacío", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                textApePat.requestFocus();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });
        textApeMat.addActionListener(e -> {
            var textapellidomaterno = textApeMat.getText();
            if (textapellidomaterno.isEmpty()) {
                showMessageDialog(this, "El campo apellido materno está vacío", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                textApeMat.requestFocus();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });
        textNumEmp.addActionListener(e -> {
            var numEmp = textNumEmp.getText();
            if ("".equals(numEmp)) {
                showMessageDialog(this, "El número de empleado esta vacío", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                textNumEmp.requestFocus();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });
        comboEmpleado.removeAllItems();
        comboEmpleado.addItem(null);
        ing.obtenerIngSop().forEach(this::ingresa);
        btnSave.addActionListener(e -> actualizaDatos());
        cerrar.addActionListener(e-> dispose());
    }

    private void ingresa(IngenieroSoporte ing) {
        comboEmpleado.addItem(ing);
        //model.addRow(new Object[]{ing.getNombre_ing(), ing.getApellido_pat(), ing.getApellido_mat(), ing.getNumero_empleado()});
        out.println(ing.getId_ing_soporte());
    }

    @SuppressWarnings("null")
    private void textBuscarNumEmpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscarNumEmpKeyReleased
        // TODO add your handling code here:
        var empleadoEncontrado = textBuscarNumEmp.getText();
        var ingSopController = new IngSopController();
        if (!empleadoEncontrado.isEmpty()) {
            var emp = ingSopController.otenerIngSopNumEmp(empleadoEncontrado);
            if (emp != null) {
                emp.filter(Objects::nonNull).forEach(e -> model.addRow(new Object[]{e.getNombre_ing(), e.getApellido_pat(), e.getApellido_mat(), e.getNumero_empleado()}));
                tabla.setModel(model);
            } else if (emp.count() == 0) {
                out.println(STR."Sin registro.....\{emp.count()}");
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
            btnSave.setEnabled(false);
        }

    }//GEN-LAST:event_textBuscarNumEmpKeyReleased

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        // TODO add your handling code here:
        if (tabla.getModel() != null) {
            var seleccion = tabla.getSelectedRow();
            if (seleccion >= 0) {
                textNombre.setText(tabla.getValueAt(seleccion, 0).toString());
                textApePat.setText(tabla.getValueAt(seleccion, 1).toString());
                textApeMat.setText(tabla.getValueAt(seleccion, 2).toString());
                textNumEmp.setText(tabla.getValueAt(seleccion, 3).toString());
                textBuscarNumEmp.setEnabled(false);
                textNombre.requestFocus();
                textNombre.selectAll();
                textNombre.setSelectedTextColor(Color.RED);
                btnSave.setEnabled(true);
            }
        } else {
            out.println("Error.........................");
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void textNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textNombreFocusLost
        var nombre = textNombre.getText();
        if (nombre.isEmpty()) {
            showMessageDialog(this, "El campo nombre está vacío", "Monitor", ERROR_MESSAGE);
            getDefaultToolkit().beep();
            textNombre.requestFocus();
        } else {
            ((JComponent) evt.getSource()).transferFocus();
        }
    }//GEN-LAST:event_textNombreFocusLost

    private void actualizaDatos() {
        var nombre = textNombre.getText();
        var apellidopat = textApePat.getText();
        var apellidomat = textApeMat.getText();
        var numemp = textNumEmp.getText();
        var ingSopController = new IngSopController();
        var ingeniero = new IngenieroSoporte(nombre, apellidopat, apellidomat, numemp);
        if (ingSopController.crearIngSop(ingeniero)) {
            showMessageDialog(this, "Dato actualizado correctamente.....", "Monitor", INFORMATION_MESSAGE);
            var dm = (DefaultTableModel) tabla.getModel();
            model.setRowCount(0);
            tabla.setModel(dm);
            tabla.updateUI();
            btnSave.setEnabled(false);
            textBuscarNumEmp.setEnabled(true);
            textBuscarNumEmp.setText("");
            textBuscarNumEmp.requestFocus();
            textNombre.setText("");
            textApePat.setText("");
            textApeMat.setText("");
            textNumEmp.setText("");
        } else {
            showMessageDialog(this, "No se guardaron los datos", "Monitor", ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JButton cerrar;
    private javax.swing.JComboBox<IngenieroSoporte> comboEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField textApeMat;
    private javax.swing.JTextField textApePat;
    private javax.swing.JTextField textBuscarNumEmp;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textNumEmp;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel model;
}
