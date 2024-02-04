/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.matis.bonito.formularios;

import org.matis.bonito.controller.SedeController;

import static java.awt.Color.CYAN;
import static java.awt.Toolkit.getDefaultToolkit;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;


import static java.lang.Integer.valueOf;
import static java.lang.String.format;
import static java.lang.System.out;
import static javax.swing.JOptionPane.*;

import org.matis.bonito.model.Sedes;
import org.matis.bonito.validador.LimitandorTexto;

/**
 *
 * @author oscar
 */
public class CrearSede extends JDialog {

    /**
     * Creates new form CrearSede
     *
     * @param parent
     * @param modal
     */
    public CrearSede(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        misComponentes();
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
        textoSede = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        guardar = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CrearSede");
        setLocationByPlatform(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);

        jLabel1.setText("Nombre sede:");

        textoSede.setDocument(new LimitandorTexto(textoSede,12));
        textoSede.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoSedeKeyReleased(evt);
            }
        });

        guardar.setMnemonic('G');
        guardar.setText("Guardar");

        cerrar.setMnemonic('C');
        cerrar.setText("Cerrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(textoSede, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(guardar)))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(cerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3))
        );

        setSize(new java.awt.Dimension(334, 142));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void misComponentes() {
        setUndecorated(true);
        guardar.setEnabled(false);
        textoSede.requestFocus();
        textoSede.addActionListener(e -> {
            var textSede = textoSede.getText();
            if (textSede.isEmpty()) {
                showMessageDialog(this, "El campo sede está vacío", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                textoSede.requestFocus();
            } else {
                var sedeControler = new SedeController();
                var sedescontrol = sedeControler.obtenerSede(textSede);
                if(sedescontrol != null) {
                    showMessageDialog(this, "Ya existe el registro de la sede", "Monitor", ERROR_MESSAGE);
                    getDefaultToolkit().beep();
                    guardar.setEnabled(false);
                    textoSede.selectAll();
                    textoSede.setSelectionColor(CYAN);
                    textoSede.requestFocus();
                } else {
                    if(textSede.length() == 1) {
                        showMessageDialog(this, "El nombre de la sede debe de contener más caracteres", "Monitor", ERROR_MESSAGE);
                        guardar.setEnabled(false);
                        getDefaultToolkit().beep();
                        textoSede.selectAll();
                        textoSede.setSelectionColor(CYAN);
                        textoSede.requestFocus();
                    } else {
                        guardar.setEnabled(true);
                        ((JComponent) e.getSource()).transferFocus();
                    }
                }
            }
        });
        this.getRootPane().setDefaultButton(cerrar);
        guardar.addActionListener(e -> guardandoSede());
        cerrar.addActionListener(e -> this.dispose());
        String formatoFolio = "F-%07d";
        /*IntStream.range(1,9999999).forEach(i->{String folio = String.format(formatoFolio, i);
            out.println(folio);
        });*/
    }

    private void textoSedeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoSedeKeyReleased
        // TODO add your handling code here:
        var formatoFolio = "F-%012d";
        nuevoNumeroFolio++;
        var folio = format(formatoFolio, nuevoNumeroFolio);
        var b = folio.substring(2,14);
        out.println(folio);
        out.println(b);
        var textSede = textoSede.getText();
        if (textSede.isEmpty()) {
            textoSede.requestFocus();
            getDefaultToolkit().beep();
        } else {
            var sedeControler = new SedeController();
            var sedeid = sedeControler.obtenerSedeActivo(textSede);
            if (sedeid != null) {
                showMessageDialog(this, "Sede ya registrada...", "Monitor", INFORMATION_MESSAGE);
                textoSede.requestFocus();
                textoSede.selectAll();
                textoSede.setSelectionColor(CYAN);
                getDefaultToolkit().beep();
                guardar.setEnabled(false);
                out.println(sedeid);
                var ca = sedeid.getCodigo_sede();
                out.println(ca);
            } else {
                //showMessageDialog(this, sedeid, "Monitor", INFORMATION_MESSAGE);
                out.println("Sin registro");
            }
        }
    }//GEN-LAST:event_textoSedeKeyReleased

    private void guardandoSede() {
        var textSede = textoSede.getText();
        if (textSede.isEmpty()) {
            textoSede.requestFocus();
            getDefaultToolkit().beep();
        } else {
            var sedeControler = new SedeController();
            var sedeid = sedeControler.obtenerSedeActivo(textSede);
            if (sedeid != null) {
                showMessageDialog(this, "Sede ya registrada...", "Monitor", INFORMATION_MESSAGE);
                textoSede.requestFocus();
                textoSede.selectAll();
                textoSede.setSelectionColor(CYAN);
                getDefaultToolkit().beep();
                guardar.setEnabled(false);
            } else {
                var miNuevaSede = new Sedes();
                var nombreSede = textoSede.getText();
                var elultimo = devuelveLastFolio();
                miNuevaSede.setNombre_sede(nombreSede);
                miNuevaSede.setCodigo_sede(elultimo);
                if(sedeControler.crearSede(miNuevaSede)) {
                    showMessageDialog(this, "Sede registrada exitosamente", "Monitor", INFORMATION_MESSAGE);
                    textoSede.requestFocus();
                    textoSede.setText("");
                    guardar.setEnabled(false);
                } else {
                    showMessageDialog(this, "No se creo la sede.............", "Monitor", ERROR_MESSAGE);
                    textoSede.requestFocus();
                }
            }
        }
    }
    private String devuelveLastFolio() {
        var sedeControler = new SedeController();
        out.println("Sin registro");
        guardar.setEnabled(true);
        var initFolio = sedeControler.obtenerUltimoRegistro().get().getCodigo_sede().substring(2,14);
        var aEntero = valueOf(initFolio);
        var incrementoFolio = aEntero + 1;
        var folioToSave = format(miFormatoFolio, incrementoFolio);
        return folioToSave;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField textoSede;
    // End of variables declaration//GEN-END:variables

    private int nuevoNumeroFolio = 1;
    final static String miFormatoFolio = "F-%012d";

}
