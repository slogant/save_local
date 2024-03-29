/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.matis.bonito.formularios;

import org.matis.bonito.controller.SistemaOperativoController;
import org.matis.bonito.model.SistemaOperativo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

import static java.awt.Color.CYAN;
import java.awt.KeyEventPostProcessor;
import java.awt.KeyboardFocusManager;
import static java.awt.Toolkit.getDefaultToolkit;
import java.awt.event.KeyEvent;
import static java.lang.Integer.valueOf;
import static java.lang.String.format;
import static java.lang.System.out;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Stream.of;
import static javax.swing.JOptionPane.*;
import static javax.swing.SwingConstants.RIGHT;

/**
 *
 * @author oscar
 */
public class CrearSO extends JDialog {

    /**
     * Creates new form CrearSO
     *
     * @param parent
     * @param modal
     */
    public CrearSO(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargaMisComponentes();
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
        textoSO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboBits = new javax.swing.JComboBox<>();
        guardar = new javax.swing.JButton();
        cerrar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Sstema Operativo");
        setLocationByPlatform(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        setResizable(false);

        jLabel1.setText("Sistema Operativo: ");

        textoSO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoSOKeyReleased(evt);
            }
        });

        jLabel2.setText("Bits: ");

        guardar.setMnemonic('A');
        guardar.setText("Aceptar");

        cerrar.setMnemonic('C');
        cerrar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(4, 4, 4)
                                .addComponent(comboBits, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(3, 3, 3)
                                .addComponent(textoSO, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cerrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(guardar)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator3)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoSO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(guardar)
                    .addComponent(cerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(381, 195));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cargaMisComponentes() {
        var mapa = of( new SimpleEntry<>(1, "x32"),
                 new SimpleEntry<>(2, "x64"))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
        setUndecorated(true);
        textoSO.requestFocus();
        guardar.setEnabled(false);
        this.getRootPane().setDefaultButton(guardar);
        comboBits.removeAllItems();
        comboBits.addItem("");
        ((JLabel) comboBits.getRenderer()).setHorizontalAlignment(RIGHT);
        //Stream.of("x32","x64").map(m-> m.toUpperCase()).forEach(s-> {comboBits.addItem(s);});
        mapa.forEach((x,y)-> {comboBits.addItem(y);});
        var kb = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        kb.addKeyEventPostProcessor(new KeyEventPostProcessor() {
            @Override
            public boolean postProcessKeyEvent(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE && this != null) {
                    System.out.println("Cerrando dialogo...");
                    dispose();
                }

                return false;
            }
        });
        textoSO.addActionListener(this::validaDatos);
        guardar.addActionListener(this::guardando);
        cerrar.addActionListener(e -> dispose());
    }

    private void validaDatos(ActionEvent e) {
        var sis = textoSO.getText();
        var bits_so = (String) comboBits.getSelectedItem();
        if (sis.isEmpty()) {
            showMessageDialog(this, "El campo sistema operativo está vacío", "Monitor", ERROR_MESSAGE);
            getDefaultToolkit().beep();
            textoSO.requestFocus();
        } else if(bits_so.equals("")) {
            showMessageDialog(this, "El campo bits del operativo está vacío", "Monitor", ERROR_MESSAGE);
            getDefaultToolkit().beep();
            comboBits.requestFocus();
            comboBits.setSelectedIndex(1);
        } else {
            var sistemController = new SistemaOperativoController();
            var nombreSO = sistemController.obtenerSistemaOperativoActivo(sis);
            if(nombreSO != null) {
                showMessageDialog(this, "Ya existe el registro de la sstema operativo", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                guardar.setEnabled(false);
                textoSO.selectAll();
                textoSO.setSelectionColor(CYAN);
                textoSO.requestFocus();
                comboBits.setSelectedIndex(0);
            } else {
                switch (sis.length()) {
                    case 1 -> {
                        showMessageDialog(this, "El nombre de la sede debe de contener más caracteres", "Monitor", ERROR_MESSAGE);
                        guardar.setEnabled(false);
                        getDefaultToolkit().beep();
                        textoSO.selectAll();
                        textoSO.setSelectionColor(CYAN);
                        textoSO.requestFocus();
                    }
                    default -> {
                        guardar.setEnabled(true);
                        ((JComponent) e.getSource()).transferFocus();
                    }
                }
            }
        }
    }

    private void textoSOKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoSOKeyReleased
        // TODO add your handling code here:
        var sis = textoSO.getText();
        if (sis.isEmpty()) {
            showMessageDialog(this, "El campo sistema operativo está vacío", "Monitor", ERROR_MESSAGE);
            getDefaultToolkit().beep();
            textoSO.requestFocus();
        } else {
            var sistemaOpeControl = new SistemaOperativoController();
            var sistema = sistemaOpeControl.obtenerSistemaOperativoActivo(sis);
            if (sistema != null) {
                showMessageDialog(this, "Sistema ya registrado...", "Monitor", INFORMATION_MESSAGE);
                textoSO.requestFocus();
                textoSO.selectAll();
                textoSO.setSelectionColor(CYAN);
                getDefaultToolkit().beep();
                guardar.setEnabled(false);
                out.println(sistema);
                var ca = sistema.getCodigo_so();
                out.println(ca);
            } else {
                //showMessageDialog(this, sedeid, "Monitor", INFORMATION_MESSAGE);
                out.println("Sin registro");
            }
        }
    }//GEN-LAST:event_textoSOKeyReleased

    private void guardando(ActionEvent e) {
        var textoSis = textoSO.getText();
        if (textoSis.isEmpty()) {
            textoSO.requestFocus();
            getDefaultToolkit().beep();
        } else {
            var sistemaOpeControl = new SistemaOperativoController();
            var sistema = sistemaOpeControl.obtenerSistemaOperativoActivo(textoSis);
            if (sistema != null) {
                showMessageDialog(this, "Sistema ya registrado...", "Monitor", INFORMATION_MESSAGE);
                textoSO.requestFocus();
                textoSO.selectAll();
                textoSO.setSelectionColor(CYAN);
                getDefaultToolkit().beep();
                guardar.setEnabled(false);
            } else {
                var nombreSO = textoSO.getText();
                var bits_so = (String) comboBits.getSelectedItem();
                var elultimo = devuelveLastFolio();
                var miSo = new SistemaOperativo(nombreSO,bits_so,elultimo);
                if(sistemaOpeControl.crearSisOpe(miSo)) {
                    showMessageDialog(this, "Sistema Operativo registrado exitosamente", "Monitor", INFORMATION_MESSAGE);
                    textoSO.requestFocus();
                    textoSO.setText("");
                    comboBits.setSelectedIndex(0);
                    guardar.setEnabled(false);
                } else {
                    showMessageDialog(this, "No se creo el sistema operativo", "Monitor", ERROR_MESSAGE);
                    textoSO.requestFocus();
                }
            }
        }
    }

    private String devuelveLastFolio() {
        var sistemaOperativoController = new SistemaOperativoController();
        guardar.setEnabled(true);
        var initFolio = sistemaOperativoController.obtenerUltimoRegistro().get().getCodigo_so().substring(2,14);
        var aEntero = valueOf(initFolio);
        var incrementoFolio = aEntero + 1;
        var folioToSave = format(miFormatoFolio, incrementoFolio);
        return folioToSave;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cerrar;
    private javax.swing.JComboBox<String> comboBits;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField textoSO;
    // End of variables declaration//GEN-END:variables
    private int nuevoNumeroFolio = 1;
    final static String miFormatoFolio = "S-%012d";
}
