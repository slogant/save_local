/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.matis.bonito.vista;

import java.awt.Dialog;
import java.awt.Dialog.ModalExclusionType;
import org.matis.bonito.controller.*;
import org.matis.bonito.formularios.*;
import org.matis.bonito.model.*;

import javax.swing.*;

import static java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE;
import static java.awt.Dialog.ModalityType.TOOLKIT_MODAL;
import static java.awt.EventQueue.invokeLater;
import java.awt.event.ActionEvent;

import static java.awt.Toolkit.getDefaultToolkit;
import static java.lang.System.out;
import static javax.swing.JOptionPane.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

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
        menuEditaIng = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuEliminaIng = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        menuCrearSede = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        menuCrearPiso = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        menuCreaSO = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        menuCrearEquipo = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        menuCrearMarca = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        menuSalir = new javax.swing.JMenuItem();
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

        MenuAdmin.setMnemonic('o');
        MenuAdmin.setText("Admin");
        MenuAdmin.add(jSeparator1);

        menuCrearIng.setMnemonic('C');
        menuCrearIng.setText("Crear Ingeniero Soporte");
        MenuAdmin.add(menuCrearIng);
        MenuAdmin.add(jSeparator2);

        menuEditaIng.setMnemonic('E');
        menuEditaIng.setText("Editar Ingeniero Soporte");
        MenuAdmin.add(menuEditaIng);
        MenuAdmin.add(jSeparator4);

        menuEliminaIng.setMnemonic('m');
        menuEliminaIng.setText("Eliminar Ingeniero Soporte");
        MenuAdmin.add(menuEliminaIng);
        MenuAdmin.add(jSeparator3);

        menuCrearSede.setMnemonic('R');
        menuCrearSede.setText("Registrar sede");
        MenuAdmin.add(menuCrearSede);
        MenuAdmin.add(jSeparator5);

        menuCrearPiso.setMnemonic('e');
        menuCrearPiso.setText("Registrar piso");
        MenuAdmin.add(menuCrearPiso);
        MenuAdmin.add(jSeparator7);

        menuCreaSO.setMnemonic('o');
        menuCreaSO.setText("Registrar sistema operativo");
        MenuAdmin.add(menuCreaSO);
        MenuAdmin.add(jSeparator10);

        menuCrearEquipo.setMnemonic('t');
        menuCrearEquipo.setText("Registrar tipo equipo");
        MenuAdmin.add(menuCrearEquipo);
        MenuAdmin.add(jSeparator6);

        menuCrearMarca.setMnemonic('g');
        menuCrearMarca.setText("Registrar marca");
        MenuAdmin.add(menuCrearMarca);
        MenuAdmin.add(jSeparator9);

        menuSalir.setMnemonic('S');
        menuSalir.setText("Salir");
        MenuAdmin.add(menuSalir);
        MenuAdmin.add(jSeparator8);

        barraPrincipal.add(MenuAdmin);

        setJMenuBar(barraPrincipal);

        setSize(new java.awt.Dimension(1022, 606));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cargaComponentes() {
        var soporte = new IngenieroSoporte("Oscar Antonio", "Lopez", "Gonzalez", "65070610");
        var sede = new Sedes("Torre Tp", "F-000000000001");
        var piso = new Piso("PB1", "P-000000000001");
        var so = new SistemaOperativo("Windows 7 Pro", "x32", "S-000000000001");
        var tipoEquipo = new TipoEquipo("PC", "E-000000000001");
        var marcas = new MarcaEquipo("DELL", "M-000000000001", "000000000001");
        var ingSopController = new IngSopController();
        var sedesCotroller = new SedeController();
        var pisoController = new PisoController();
        var sistemaOpeControler = new SistemaOperativoController();
        var tipoEquipoController = new TipoEquipoController();
        var marcaControlador = new MarcaEquipoController();
        /*
        if (ingSopController.crearIngSop(soporte)) {
            out.println("Valor guardado");
        } else {
            out.println("No se logro el registro");
        }
        if (sedesCotroller.crearSede(sede)) {
            out.println("Sede guardada");
        } else {
            out.println("No se logro el registro de la sede......");
        }
        if (pisoController.crearPiso(piso)) {
            out.println("Piso guardado");
        } else {
            out.println("No se logro el registro del piso......");
        }
        if (sistemaOpeControler.crearSisOpe(so)) {
            out.println("Sistema Operativo creado");
        } else {
            out.println("No se logro el registro del sistema operativo......");
        }
        if (marcaControlador.crearMarcaEquipo(marcas)) {
            out.println("La marca de equipo se a creado........");
        } else {
            out.println("No se logro el registro de la marca......");
        }
        */
        if (tipoEquipoController.crearTipoEquipo(tipoEquipo)) {
            out.println("Tipo creado");
        } else {
            out.println("No se logro el registro del tipo......");
        }
        if (ingSopController.eliminarIngsop("23445564")) {
            out.println("Eliminado");
        } else {
            out.println("Sin eliminar");
        }
        var updatesoporte = new IngenieroSoporte("Matias", "Peque Bonito", "Mi Niño bonito", "20201982");
        if (ingSopController.actualizaIngSop("65070600", updatesoporte)) {
            out.println("Actualizados");
        } else {
            out.println("No Actualizados");
        }
        ingSopController.obtenerIngSop().forEachOrdered(out::println);
        ingSopController.otenerIngSopNumEmp("23425564").forEachOrdered(out::println);

        menuCrearIng.addActionListener(e -> invokeLater(() -> new CrearIngSop(new JFrame(), true).setVisible(true)));
        menuEditaIng.addActionListener(e -> invokeLater(() -> new EditarIngSop(new JFrame(), true).setVisible(true)));
        menuEliminaIng.addActionListener(e -> invokeLater(() -> new ElimnarIngSop(new JFrame(), true).setVisible(true)));
        menuCrearSede.addActionListener(e -> invokeLater(() -> new CrearSede(new JFrame(), true).setVisible(true)));
        menuCrearPiso.addActionListener(e -> invokeLater(() -> new CrearPiso(new JFrame(), true).setVisible(true)));
        menuCreaSO.addActionListener(e -> invokeLater(() -> new CrearSO(new JFrame(), true).setVisible(true)));
        menuCrearEquipo.addActionListener(e -> invokeLater(() -> new CreaTipoEquipo(new JFrame(), true).setVisible(true)));
        menuCrearMarca.addActionListener(e -> invokeLater(() -> new CrearMarca(new JFrame(), true).setVisible(true)));
        menuSalir.addActionListener(e -> {
            cerrarPrincipal(e);
        });
    }

    private void cerrarPrincipal(ActionEvent e) {
        final var pane = new JOptionPane("Desea cerrar la aplicación", QUESTION_MESSAGE, OK_CANCEL_OPTION);
        final var dialogo = pane.createDialog(this, "Monitor");
        dialogo.setModal(true);
        dialogo.setModalExclusionType(APPLICATION_EXCLUDE);
        dialogo.setModalityType(TOOLKIT_MODAL);
        dialogo.setVisible(true);
        dialogo.dispose();
        dialogo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        var value = ((Integer) pane.getValue());
        getDefaultToolkit().beep();
        //var close = JOptionPane.showConfirmDialog(this, "Desea cerrar la aplicación", "Monitor", JOptionPane.YES_NO_OPTION);
        if (value == YES_OPTION) {
            revalidate();
            repaint();
            dispose();
            System.gc();
            Runtime.getRuntime().gc();
            System.exit(0);
        } else {
            final var paneop = new JOptionPane("Cancelando cerrar aplicación", INFORMATION_MESSAGE);
            final var dialogoOp = paneop.createDialog(this, "Monitor");
            dialogoOp.setModal(true);
            dialogoOp.setModalExclusionType(APPLICATION_EXCLUDE);
            dialogoOp.setModalityType(TOOLKIT_MODAL);
            dialogoOp.setVisible(true);
            dialogoOp.dispose();
            dialogoOp.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            getDefaultToolkit().beep();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAdmin;
    private javax.swing.JPanel PanelPrincipal;
    private javax.swing.JMenuBar barraPrincipal;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JMenuItem menuCreaSO;
    private javax.swing.JMenuItem menuCrearEquipo;
    private javax.swing.JMenuItem menuCrearIng;
    private javax.swing.JMenuItem menuCrearMarca;
    private javax.swing.JMenuItem menuCrearPiso;
    private javax.swing.JMenuItem menuCrearSede;
    private javax.swing.JMenuItem menuEditaIng;
    private javax.swing.JMenuItem menuEliminaIng;
    private javax.swing.JMenuItem menuSalir;
    // End of variables declaration//GEN-END:variables
}
