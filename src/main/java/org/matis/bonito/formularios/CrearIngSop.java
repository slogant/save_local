/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.matis.bonito.formularios;

import javax.swing.*;

import org.matis.bonito.controller.IngSopController;
import org.matis.bonito.model.IngenieroSoporte;
import org.matis.bonito.validador.JTextFieldLimit;
import org.matis.bonito.validador.LimitandorTexto;

import java.awt.event.ActionEvent;

import static java.awt.Toolkit.getDefaultToolkit;
import static javax.swing.JOptionPane.*;

/**
 *
 * @author oscar
 */
public class CrearIngSop extends javax.swing.JDialog {


    public CrearIngSop(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        misComponentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        textoApellidoPat = new javax.swing.JTextField();
        textApellidoMat = new javax.swing.JTextField();
        textNumEmp = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar ing");
        setLocationByPlatform(true);
        setModal(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Nombre: ");

        jLabel2.setText("Apellido Pat: ");

        jLabel3.setText("Apelido Mat: ");

        jLabel4.setText("Número Emp: ");

        textoNombre.setDocument(new LimitandorTexto(textoNombre,35));

        textoApellidoPat.setDocument(new LimitandorTexto(textoApellidoPat, 30));

        textNumEmp.setDocument(new JTextFieldLimit(8,false));

        guardar.setMnemonic('G');
        guardar.setText("Guardar");

        cerrar.setMnemonic('C');
        cerrar.setText("Cerrar");

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 13, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(30, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textNumEmp))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textApellidoMat))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textoApellidoPat, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cerrar)
                        .addGap(6, 6, 6)))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textoApellidoPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textApellidoMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(cerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(487, 245));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void misComponentes() {
        this.setUndecorated(true);
        guardar.setEnabled(false);
        textoNombre.addActionListener(e->{
            var textnombre = textoNombre.getText();
            if (textnombre.isEmpty()) {
                showMessageDialog(this, "El campo nombre está vacío", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                textoNombre.requestFocus();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });
        textoApellidoPat.addActionListener(e->{
            var apellidoPat = textoApellidoPat.getText();
            if (apellidoPat.isEmpty()) {
                showMessageDialog(this,"El campo apellido paterno esta vacío...","Monitor", ERROR_MESSAGE);
                textoApellidoPat.requestFocus();
                getDefaultToolkit().beep();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });

        textApellidoMat.addActionListener(e->{
            var apellidoPat = textApellidoMat.getText();
            if (apellidoPat.isEmpty()) {
                showMessageDialog(this,"El campo apellido materno esta vacío...","Monitor", ERROR_MESSAGE);
                textApellidoMat.requestFocus();
                getDefaultToolkit().beep();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });

        textNumEmp.addActionListener(e -> {
            var numEmp = textNumEmp.getText();
            if (numEmp.isEmpty()) {
                showMessageDialog(this,"El campo apellido paterno esta vacío...","Monitor", ERROR_MESSAGE);
                textNumEmp.requestFocus();
                getDefaultToolkit().beep();
            } else {
                ((JComponent) e.getSource()).transferFocus();
                guardar.setEnabled(true);
            }
        });

        guardar.addActionListener(this::actionPerformed);
        cerrar.addActionListener(this::actionPerformed2);
    }
    private void actionPerformed(ActionEvent e) {
        guardarDatos();
    }
    private void actionPerformed2(ActionEvent e) {
        this.dispose();
    }
    private void guardarDatos() {
        var ingSoporte = new IngenieroSoporte();
        var nombre = textoNombre.getText();
        var apellidoPat = textoApellidoPat.getText();
        var apellidoMat = textApellidoMat.getText();
        var numEmp = textNumEmp.getText();
        ingSoporte.setNombre_ing(nombre);
        ingSoporte.setApellido_pat(apellidoPat);
        ingSoporte.setApellido_mat(apellidoMat);
        ingSoporte.setNumero_empleado(numEmp);
        var ingSopController = new IngSopController();
        if(nombre.isEmpty()) {
            showMessageDialog(this,"El campo nombre esta vacío...","Monitor", ERROR_MESSAGE);
            textoNombre.requestFocus();
        } else if(apellidoPat.isEmpty()) {
            showMessageDialog(this,"El campo apellido paterno esta vacío...","Monitor", ERROR_MESSAGE);
            textoApellidoPat.requestFocus();
        } else if(apellidoMat.isEmpty()) {
            showMessageDialog(this,"El campo apellido materno esta vacío...","Monitor", ERROR_MESSAGE);
            textApellidoMat.requestFocus();
        } else if(numEmp.isEmpty()) {
            showMessageDialog(this,"El campo numero empleado esta vacío...","Monitor", ERROR_MESSAGE);
            textNumEmp.requestFocus();
        } else if(ingSopController.crearIngSop(ingSoporte)) {
            showMessageDialog(this,"Datos gardados correctamente","Monitor", INFORMATION_MESSAGE);
            textoNombre.requestFocus();
            textoNombre.setText("");
            textoApellidoPat.setText("");
            textApellidoMat.setText("");
            textNumEmp.setText("");
            guardar.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField textApellidoMat;
    private javax.swing.JTextField textNumEmp;
    private javax.swing.JTextField textoApellidoPat;
    private javax.swing.JTextField textoNombre;

    // End of variables declaration//GEN-END:variables
}
