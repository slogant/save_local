/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.matis.bonito.formularios;

import static java.awt.Color.CYAN;
import static java.awt.Toolkit.getDefaultToolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Integer.valueOf;
import static java.lang.String.format;
import static java.lang.System.out;
import javax.swing.JComponent;
import javax.swing.JFrame;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import org.matis.bonito.controller.MarcaEquipoController;
import org.matis.bonito.model.MarcaEquipo;

/**
 *
 * @author oscar
 */
public class CrearMarca extends javax.swing.JDialog {

    /**
     * Creates new form CrearMarca
     *
     * @param parent
     * @param modal
     */
    public CrearMarca(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarMisComponentes();
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
        textMarca = new javax.swing.JTextField();
        cerrar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Crear");
        setAlwaysOnTop(true);
        setLocationByPlatform(true);
        setResizable(false);

        jLabel1.setText("Marca: ");

        cerrar.setMnemonic('C');
        cerrar.setText("Cerrar");

        guardar.setMnemonic('A');
        guardar.setText("Aceptar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(cerrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(guardar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1))
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cerrar)
                    .addComponent(guardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(311, 168));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cargarMisComponentes() {
        setUndecorated(true);
        guardar.setEnabled(false);
        this.getRootPane().setDefaultButton(guardar);
        textMarca.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                keyCampo(evt);
            }
        });
        textMarca.addActionListener(e -> validaCampos(e));
        guardar.addActionListener(e -> guardando(e));
        cerrar.addActionListener(e -> dispose());
    }

    private void keyCampo(KeyEvent evt) {
        var marca = textMarca.getText();
        if (marca.isEmpty()) {
            showMessageDialog(this, "El campo marca está vacío", "Monitor", ERROR_MESSAGE);
            getDefaultToolkit().beep();
            textMarca.requestFocus();
        } else {
            var marcaController = new MarcaEquipoController();
            var marcaActiva = marcaController.obtenerMarcaActivo(marca);
            if (marcaActiva != null) {
                showMessageDialog(this, "Sistema ya registrado...", "Monitor", INFORMATION_MESSAGE);
                textMarca.requestFocus();
                textMarca.selectAll();
                textMarca.setSelectionColor(CYAN);
                getDefaultToolkit().beep();
                guardar.setEnabled(false);
                out.println(marcaActiva);
                var ca = marcaActiva.getCodigo_marca();
                out.println(ca);
            } else {
                //showMessageDialog(this, sedeid, "Monitor", INFORMATION_MESSAGE);
                out.println("Sin registro");
            }
        }
    }

    private void validaCampos(ActionEvent e) {
        var marca = textMarca.getText();
        if (marca.isEmpty()) {
            showMessageDialog(this, "El campo marca está vacío", "Monitor", ERROR_MESSAGE);
            getDefaultToolkit().beep();
            textMarca.requestFocus();
        } else {
            var marcaController = new MarcaEquipoController();
            var marcaActiva = marcaController.obtenerMarcaActivo(marca);
            if (marcaActiva != null) {
                showMessageDialog(this, "Ya existe el registro de la marca", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                guardar.setEnabled(false);
                textMarca.selectAll();
                textMarca.setSelectionColor(CYAN);
                textMarca.requestFocus();
            } else {
                switch (marca.length()) {
                    case 1 -> {
                        showMessageDialog(this, "El nombre de la narca debe de contener más caracteres", "Monitor", ERROR_MESSAGE);
                        guardar.setEnabled(false);
                        getDefaultToolkit().beep();
                        textMarca.selectAll();
                        textMarca.setSelectionColor(CYAN);
                        textMarca.requestFocus();
                    }
                    default -> {
                        guardar.setEnabled(true);
                        ((JComponent) e.getSource()).transferFocus();
                    }
                }
            }
        }
    }

    private void guardando(ActionEvent e) {
        var marca = textMarca.getText();
        if (marca.isEmpty()) {
            showMessageDialog(this, "El campo marca está vacío", "Monitor", ERROR_MESSAGE);
            getDefaultToolkit().beep();
            textMarca.requestFocus();
        } else {
            var marcaController = new MarcaEquipoController();
            var marcaActiva = marcaController.obtenerMarcaActivo(marca);
            if (marcaActiva != null) {
                showMessageDialog(this, "Marca ya registrada..", "Monitor", INFORMATION_MESSAGE);
                textMarca.requestFocus();
                textMarca.selectAll();
                textMarca.setSelectionColor(CYAN);
                getDefaultToolkit().beep();
                guardar.setEnabled(false);
            } else {
                var marcas = textMarca.getText();
                var elultimo = devuelveLastFolio();
                var marcaIngresa = new MarcaEquipo(marcas,elultimo, elultimo);
                if(marcaController.crearMarcaEquipo(marcaIngresa)) {
                    showMessageDialog(this, "Marca registrada exitosamente", "Monitor", INFORMATION_MESSAGE);
                    textMarca.requestFocus();
                    textMarca.setText("");
                    guardar.setEnabled(false);
                } else {
                    showMessageDialog(this, "No se creo la marca", "Monitor", ERROR_MESSAGE);
                    textMarca.requestFocus();
                }
            }
        }
    }

    private String devuelveLastFolio() {
        var marcaController = new MarcaEquipoController();
        guardar.setEnabled(true);
        var initFolio = marcaController.obtenerUltimoRegistroMarca().get().getCodigo_marca().substring(2, 14);
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
    private javax.swing.JTextField textMarca;
    // End of variables declaration//GEN-END:variables

    private int nuevoNumeroFolio = 1;
    final static String miFormatoFolio = "M-%012d";
}
