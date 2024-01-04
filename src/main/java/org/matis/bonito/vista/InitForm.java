/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.matis.bonito.vista;

import static java.awt.EventQueue.invokeLater;
import org.matis.bonito.controller.IngSopController;
import org.matis.bonito.model.IngenieroSoporte;

import static java.lang.System.out;
import javax.swing.JFrame;
import org.matis.bonito.controller.formularios.CrearIngSop;

/**
 *
 * @author oscar
 */
public class InitForm extends javax.swing.JFrame {

    /**
     * Creates new form InitForm
     */
    public InitForm() {
        initComponents();
        cargaComponentes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings(value = "unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelPrincipal = new javax.swing.JPanel();
        barraPrincipal = new javax.swing.JMenuBar();
        MenuAdmin = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuCrearIng = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem7 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EntryForm");
        setLocationByPlatform(true);
        setResizable(false);

        PanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout PanelPrincipalLayout = new javax.swing.GroupLayout(PanelPrincipal);
        PanelPrincipal.setLayout(PanelPrincipalLayout);
        PanelPrincipalLayout.setHorizontalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
        );
        PanelPrincipalLayout.setVerticalGroup(
            PanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );

        getContentPane().add(PanelPrincipal, java.awt.BorderLayout.CENTER);

        MenuAdmin.setText("Admin");
        MenuAdmin.add(jSeparator1);

        menuCrearIng.setText("Crear Ingeniero Soporte");
        MenuAdmin.add(menuCrearIng);
        MenuAdmin.add(jSeparator2);

        jMenuItem2.setText("Editar Ingeniero Soporte");
        MenuAdmin.add(jMenuItem2);
        MenuAdmin.add(jSeparator4);

        jMenuItem3.setText("Eliminar Ingeniero Soporte");
        MenuAdmin.add(jMenuItem3);
        MenuAdmin.add(jSeparator3);

        jMenuItem4.setText("Registrar sede");
        MenuAdmin.add(jMenuItem4);
        MenuAdmin.add(jSeparator5);

        jMenuItem6.setText("Registrar piso");
        MenuAdmin.add(jMenuItem6);
        MenuAdmin.add(jSeparator7);

        jMenuItem5.setText("Registrar sistema ope");
        MenuAdmin.add(jMenuItem5);
        MenuAdmin.add(jSeparator6);

        jMenuItem7.setText("Registrar marca");
        MenuAdmin.add(jMenuItem7);
        MenuAdmin.add(jSeparator9);

        jMenuItem8.setText("Salir");
        MenuAdmin.add(jMenuItem8);
        MenuAdmin.add(jSeparator8);

        barraPrincipal.add(MenuAdmin);

        setJMenuBar(barraPrincipal);

        setSize(new java.awt.Dimension(1022, 606));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cargaComponentes() {
        var soporte = new IngenieroSoporte("Oscar Antonio", "Lopez", "Gonzalez","65070610");
        var ingSopController = new IngSopController();
        if (ingSopController.crearIngSop(soporte)) {
            out.println("Valor guardado");
        } else {
            out.println("No se logro el registro");
        }
        if (ingSopController.eliminarIngsop("23445564")) {
            out.println("Eliminado");
        } else {
            out.println("Sin eliminar");
        }
        var updatesoporte = new IngenieroSoporte("Matias","Peque Bonito","Mi Niño bonito","20201982");
        if(ingSopController.actualizaIngSop("65070600", updatesoporte)) {
            out.println("Actualizado");
        } else {
            out.println("No Actualizado");
        }
        ingSopController.obtenerIngSop().forEachOrdered(out::println);
        ingSopController.otenerIngSopNumEmp("23425564").forEachOrdered(out::println);
        
        menuCrearIng.addActionListener(e->{
        invokeLater(() -> new CrearIngSop(new JFrame(),true));
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAdmin;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JMenuBar barraPrincipal;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuItem menuCrearIng;
    // End of variables declaration//GEN-END:variables
}
