/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package org.matis.bonito.formularios;

import com.google.zxing.WriterException;
import org.matis.bonito.controller.TipoEquipoController;
import org.matis.bonito.model.TipoEquipo;
import org.matis.bonito.validador.*;

import javax.swing.*;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;

import static java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE;
import static java.awt.Dialog.ModalityType.TOOLKIT_MODAL;
import static java.awt.EventQueue.invokeLater;
import static java.awt.KeyboardFocusManager.getCurrentKeyboardFocusManager;
import static java.awt.Toolkit.getDefaultToolkit;
import static java.awt.event.KeyEvent.VK_ESCAPE;
import static java.awt.event.KeyEvent.VK_M;
import static java.lang.System.out;
import static java.time.LocalDateTime.now;
import static java.time.format.DateTimeFormatter.ofPattern;
import static java.util.concurrent.Executors.newScheduledThreadPool;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.logging.Level.SEVERE;
import static javax.imageio.ImageIO.read;
import static javax.swing.JFileChooser.APPROVE_OPTION;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import static javax.swing.SwingConstants.CENTER;
import static org.matis.bonito.validador.QRCodeGenerator.generateQRCode;

/**
 *
 * @author oscar
 */
public class RegistraCertificacion extends JDialog {

    /*
     * Creates new form RegistraCertificacion
     *
     * @param parent
     * @param modal
     */
    public RegistraCertificacion(JFrame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargaMisComponentes();
    }

    private void cargaMisComponentes() {
        spinnerFecha.setEnabled(false);
        campoNombre.requestFocus();
        final var MAX_LENGTH = 120;
        var kb = getCurrentKeyboardFocusManager();
        imagenEnPanel = new ImagenEnPanel();
        var document = (PlainDocument) campoContrasenia.getDocument();
        scheduledExecutorService = newScheduledThreadPool(1);
        // Define una tarea que se ejecutará cada segundo para actualizar el reloj
        scheduledExecutorService.scheduleAtFixedRate(RegistraCertificacion::printTime, 0, 1000, MILLISECONDS);
        spinnerFecha.setEditor(new DateEditor(spinnerFecha, "yyyy-MM-dd HH:mm:ss a"));
        var tf = ((DefaultEditor) campoTipo.getEditor()).getTextField();
        tf.setEditable(false);
        tf.setBackground(Color.white);
        var editor = campoTipo.getEditor();
        if (editor instanceof DefaultEditor defaultEditor) {
            final var mensaje = "Selecciona un valor";
            new AtomicReference<>(defaultEditor).get().getTextField().setHorizontalAlignment(SwingConstants.CENTER);
            new AtomicReference<>(defaultEditor).get().getTextField().setEditable(false);
            new AtomicReference<>(defaultEditor).get().getTextField().setText(mensaje); // Establecer el texto dentro del editor
            new AtomicReference<>(defaultEditor).get().getTextField().setCaretPosition(mensaje.length()); // Colocar el cursor al final del texto
            new AtomicReference<>(defaultEditor).get().getTextField().setEditable(false);
        }
        mu.setVisible(false);
        areaSoft.setLineWrap(true);
        areaOb.setLineWrap(true);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
            }

            @Override
            public void windowClosing(WindowEvent e) {
                ventanaCerrar(e);
            }

            @Override
            public void windowClosed(WindowEvent e) {
            }

            @Override
            public void windowIconified(WindowEvent e) {
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
            }

            @Override
            public void windowActivated(WindowEvent e) {
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
            }
        });

        campoNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                final var tamano = 35;
                if (campoNombre.getText().length() > tamano) {
                    campoNombre.setText(campoNombre.getText().substring(0, tamano));
                }
            }
        });

        campoNombre.addActionListener(e -> {
            var textnombre = campoNombre.getText();
            if (textnombre.isEmpty()) {
                showMessageDialog(this, "El campo nombre está vacío", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                campoNombre.requestFocus();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });

        campoApellidoPat.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                final var tamano = 35;
                if (campoApellidoPat.getText().length() > tamano) {
                    campoApellidoPat.setText(campoApellidoPat.getText().substring(0, tamano));
                }
            }
        });

        campoApellidoPat.addActionListener(e -> {
            var apellidoPat = campoApellidoPat.getText();
            if (apellidoPat.isEmpty()) {
                showMessageDialog(this, "El campo apellido paterno está vacío", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                campoApellidoPat.requestFocus();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });

        campoApellidoMat.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                final var tamano = 35;
                if (campoApellidoMat.getText().length() > tamano) {
                    campoApellidoMat.setText(campoApellidoMat.getText().substring(0, tamano));
                }
            }
        });

        campoApellidoMat.addActionListener(e -> {
            var apellidoMat = campoApellidoMat.getText();
            if (apellidoMat.isEmpty()) {
                showMessageDialog(this, "El campo apellido materno está vacío", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                campoApellidoMat.requestFocus();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });

        campoNumEmp.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                final var tamano = 8;
                if (campoNumEmp.getText().length() > tamano) {
                    campoNumEmp.setText(campoNumEmp.getText().substring(0, tamano));
                }
            }
        });

        campoNumEmp.addActionListener(e -> {
            var textnumeroempleado = campoNumEmp.getText().trim();
            if (textnumeroempleado.isEmpty()) {
                showMessageDialog(this, "El campo número de empleado está vacío", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                campoNumEmp.requestFocus();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });

        campoTelefono.addActionListener(e -> {
            var texttelefono = (String) campoTelefono.getValue();
            if (texttelefono.isEmpty()) {
                showMessageDialog(this, "El campo teléfono esta vacío", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                campoTelefono.requestFocus();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });

        // Agrega un DocumentFilter para limitar el número de caracteres y evitar espacios en blanco
        document.setDocumentFilter(new DocumentFilter() {
            final int maxCharacters = 15; // Define el límite máximo de caracteres

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                // Verifica si el texto a insertar contiene espacios en blanco
                if (text != null && text.trim().length() > 0 && (fb.getDocument().getLength() + text.length() - length) <= maxCharacters) {
                    super.replace(fb, offset, length, text, attrs); // Permite la inserción
                } else {
                    // Muestra un mensaje de error o realiza otra acción
                    // En este ejemplo, simplemente ignoramos la inserción
                }
            }
        });

        campoContrasenia.addActionListener(e -> {
            var textcontra = new String(campoContrasenia.getPassword());
            if (textcontra.isEmpty()) {
                showMessageDialog(this, "El campo contraseña esta vacío", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                campoContrasenia.requestFocus();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });

        campoActivo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                final var tamano = 9;
                if (campoActivo.getText().length() > tamano) {
                    campoActivo.setText(campoActivo.getText().substring(0, tamano));
                }
            }
        });

        campoActivo.addActionListener(e -> {
            var textactivofijo = campoActivo.getText().trim();
            if (textactivofijo.isEmpty()) {
                showMessageDialog(this, "El campo activo fijo está vacío", "Monitor", ERROR_MESSAGE);
                getDefaultToolkit().beep();
                campoActivo.requestFocus();
            } else {
                ((JComponent) e.getSource()).transferFocus();
            }
        });

        areaSoft.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                final int tamano = 120;
                if (e.getSource() instanceof JTextArea source) {
                    if (source.getText().length() > tamano) {
                        source.setText(source.getText().substring(0, tamano));
                    }
                    if (e.getKeyCode() == VK_M && e.isControlDown()) {
                        getCurrentKeyboardFocusManager().focusNextComponent();
                    }
                }
            }
        });

        areaOb.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                final int tamano = 120;
                if (e.getSource() instanceof JTextArea source) {
                    if (source.getText().length() > tamano) {
                        source.setText(source.getText().substring(0, tamano));
                    }
                    if (e.getKeyCode() == VK_M && e.isControlDown()) {
                        getCurrentKeyboardFocusManager().focusNextComponent();
                    }
                }
            }
        });

        areaSoft.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null || areaSoft.getText().length() >= MAX_LENGTH) {
                    return;
                }
                super.insertString(offs, str, a);
            }
        });

        areaOb.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str == null || areaOb.getText().length() >= MAX_LENGTH) {
                    return;
                }
                super.insertString(offs, str, a);
            }
        });

        cancelar.addActionListener((var e) -> {

            out.println(campoTipo.getValue().toString());

            try {
                var qrImage = generateQRCode("Mi Matias", fantasma.getWidth(), fantasma.getHeight());
                if (qrImage != null) {
                    out.println("Hay imagen");
                    qrIcon = new ImageIcon(qrImage);
                    qrLabel = new JLabel(qrIcon);
                    JOptionPane.showMessageDialog(this, qrLabel, "Imagen", JOptionPane.PLAIN_MESSAGE);
                    fantasma.removeAll();
                    fantasma.add(qrLabel);
                    fantasma.repaint();
                } else {
                    out.println("no hay imagen.......................");
                    JLabel errorLabels = new JLabel("Error al cargar el código QR.");
                    fantasma.add(errorLabels);
                }

//                var qrIcon = new ImageIcon(qrImage);
//                JLabel qrLabel = new JLabel(qrIcon);
//                fantasma.add(qrLabel);
            } catch (WriterException ex) {
                ex.printStackTrace();
            }

        });

        //panelCargarImagen.add(imagePanel, CENTER);
        // Agregar el KeyListener al JFrame
//        this.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_M && e.isControlDown()) { // Ctrl + M
//                    mu.setVisible(!mu.isVisible());
//                }
//            }
//        });
        //setFocusable(true);
        //setFocusTraversalKeysEnabled(false);
        cargaImage.addActionListener((var e) -> {
            invokeLater(() -> {
                var ima = new ImagenDialog(new JFrame(), true);
                ima.setModalExclusionType(APPLICATION_EXCLUDE);
                ima.setModalityType(TOOLKIT_MODAL);
                var cargaImages = ima.archivosImagenes;
                cargaImages.setDialogTitle("Busca imagenes");
                cargaImages.setFileFilter(new FileNameExtensionFilter("Imagenes", "jpg", "png", "gif"));
                var respuesta = cargaImages.showOpenDialog(RegistraCertificacion.this);
                if (respuesta == APPROVE_OPTION) {
                    try {
                        var respuestas = cargaImages.getSelectedFile();
                        cargaImages.setCurrentDirectory(respuestas);
                        var imagen = read(respuestas);
                        if (imagen == null) {
                            out.println("No se pudo cargar la imagen");
                        }
                        imagenEnPanel.setImage(imagen);
                    } catch (IOException ex) {
                        Logger.getLogger(RegistraCertificacion.class.getName()).log(SEVERE, null, ex);
                        out.println(ex.getLocalizedMessage());
                    }
                }
            });
        });
        kb.addKeyEventPostProcessor(new KeyEventPostProcessor() {
            @Override
            public boolean postProcessKeyEvent(KeyEvent e) {
                if (e.getKeyCode() == VK_ESCAPE && this != null) {
                    out.println("Cerrando dialogo...");
                    dispose();
                }
                return false;
            }
        });
        panelImage.add(new ImagePanel(IMAGEN), SwingConstants.CENTER);
        panelCargarImagen.add(imagenEnPanel, SwingConstants.CENTER);
        this.toFront();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelCentral = new javax.swing.JPanel();
        spinnerFecha = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoApellidoPat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoApellidoMat = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoNumEmp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        campoTelefono = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        campoTipo = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        campoMarca = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        campoModelo = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        campoActivo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        campoLocalidad = new javax.swing.JSpinner();
        jLabel14 = new javax.swing.JLabel();
        campoPiso = new javax.swing.JSpinner();
        campoRespaldo = new javax.swing.JCheckBox();
        campoCargador = new javax.swing.JCheckBox();
        campoContrasenia = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaSoft = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaOb = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        aceptar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        cargaImage = new javax.swing.JButton();
        mu = new javax.swing.JLabel();
        panelCargarImagen = new javax.swing.JPanel();
        panelImage = new javax.swing.JPanel();
        fantasma = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registra equipo para certificación");
        setModal(true);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelCentral.setBackground(new java.awt.Color(255, 255, 255));

        spinnerFecha.setModel(new LocalDateTimeSpinnerModel(now()));

        jLabel2.setText("Nombre: ");

        campoNombre.setDocument(new LimitandorTexto(campoNombre,35));

        jLabel1.setText("Fecha: ");

        jLabel3.setText("Apellido Paterno: ");

        campoApellidoPat.setDocument(new LimitandorTexto(campoApellidoPat, 30));

        jLabel4.setText("Apellido Materno: ");

        campoApellidoMat.setDocument(new LimitandorTexto(campoApellidoMat,30));

        jLabel5.setText("Número empleado: ");

        campoNumEmp.setDocument(new JTextFieldLimit(8,false));

        jLabel6.setText("Teléfono: ");

        try {
            campoTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel7.setText("Contraseña Inicial: ");

        jLabel8.setText("Tipo de equipo: ");

        campoTipo.setModel(obtenerModelo());

        jLabel9.setText("Marca: ");

        jLabel10.setText("Modelo: ");

        jLabel12.setText("Activo fijo:  ");

        campoActivo.setDocument(new JTextFieldLimit(9, true));

        jLabel13.setText("Localidad: ");

        jLabel14.setText("Piso: ");

        campoRespaldo.setBackground(new java.awt.Color(255, 255, 255));
        campoRespaldo.setText("Respaldo");

        campoCargador.setBackground(new java.awt.Color(255, 255, 255));
        campoCargador.setText("Cargador");

        javax.swing.GroupLayout panelCentralLayout = new javax.swing.GroupLayout(panelCentral);
        panelCentral.setLayout(panelCentralLayout);
        panelCentralLayout.setHorizontalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCentralLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNombre))
                    .addGroup(panelCentralLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerFecha))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCentralLayout.createSequentialGroup()
                        .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6)
                                .addComponent(jLabel4))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoApellidoPat, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoApellidoMat, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoNumEmp, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoTelefono, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(campoTipo)
                            .addComponent(campoMarca)
                            .addComponent(campoModelo)
                            .addComponent(campoActivo)
                            .addComponent(campoLocalidad)
                            .addComponent(campoPiso)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCentralLayout.createSequentialGroup()
                                .addComponent(campoCargador)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addComponent(campoRespaldo))
                            .addComponent(campoContrasenia))))
                .addGap(0, 30, Short.MAX_VALUE))
        );
        panelCentralLayout.setVerticalGroup(
            panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinnerFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoApellidoPat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoApellidoMat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNumEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(campoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(campoModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(campoActivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(campoPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoRespaldo)
                    .addComponent(campoCargador))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        areaSoft.setColumns(20);
        areaSoft.setRows(5);
        areaSoft.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Software autorizado", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.TOP));
        jScrollPane1.setViewportView(areaSoft);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED), "Observaciones", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.BOTTOM));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        areaOb.setColumns(20);
        areaOb.setRows(5);
        jScrollPane2.setViewportView(areaOb);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        aceptar.setMnemonic('A');
        aceptar.setText("Aceptar");

        cancelar.setMnemonic('C');
        cancelar.setText("Cerrar");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aceptar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(cancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cargaImage.setText("Imagen");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cargaImage))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargaImage))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mu.setText("Muestrame");

        panelCargarImagen.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        panelCargarImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                MostrarArchivo(evt);
            }
        });
        panelCargarImagen.setLayout(new java.awt.BorderLayout());

        panelImage.setBackground(new java.awt.Color(255, 255, 255));
        panelImage.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        panelImage.setLayout(new java.awt.BorderLayout());

        fantasma.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(mu)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(fantasma, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelCargarImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141)
                        .addComponent(mu))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelCargarImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fantasma, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(967, 481));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MostrarArchivo(MouseEvent evt) {//GEN-FIRST:event_MostrarArchivo
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            // Double-click detected
            invokeLater(() -> {
                var ima = new ImagenDialog(new JFrame(), true);
                ima.setModalExclusionType(APPLICATION_EXCLUDE);
                ima.setModalityType(TOOLKIT_MODAL);
                var cargaImages = ima.archivosImagenes;
                cargaImages.setDialogTitle("Busca imagenes");
                cargaImages.setFileFilter(new FileNameExtensionFilter("Imagenes", "jpg", "png", "gif"));
                var respuesta = cargaImages.showOpenDialog(this);
                if (respuesta == APPROVE_OPTION) {
                    try {
                        var respuestas = cargaImages.getSelectedFile();
                        cargaImages.setCurrentDirectory(respuestas);
                        var imagen = read(respuestas);
                        if (imagen == null) {
                            out.println("No se pudo cargar la imagen");
                        }
                        imagenEnPanel.setImage(imagen);
                    } catch (IOException ex) {
                        Logger.getLogger(RegistraCertificacion.class.getName()).log(SEVERE, null, ex);
                        out.println(ex.getLocalizedMessage());
                    }
                }
            });
        }

    }//GEN-LAST:event_MostrarArchivo

    private void ventanaCerrar(WindowEvent e) {
        if (e.getSource() instanceof JDialog dia) {
            dia.dispose();
            scheduledExecutorService.close();
            if (scheduledExecutorService.isTerminated()) {
                out.println("Cerrandolos............");
                scheduledExecutorService.shutdown();
                if (scheduledExecutorService.isShutdown()) {
                    out.println("Hilo terminado...................");
                }
            }
        }
        out.println("Cerrando la ventana................................");
    }

    public static void printTime() {
        var ti = now().format(ofPattern("yyyy-MM-dd KK:mm:ss a"));
        spinnerFecha.setValue(new Date());
        out.println("Fecha y Hora actual: " + ti);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    private SpinnerListModel obtenerModelo() {
        TipoEquipoController tipoController = new TipoEquipoController();
        TipoEquipo[] tipos;
        try (var tipoEquipo = tipoController.obtenerTipoEquipos()) {
            var tipoEquipoList = new ArrayList<TipoEquipo>();
            tipoEquipo.forEach(tipoEquipoList::add);
            tipos = tipoEquipoList.toArray(TipoEquipo[]::new);
        } catch (Exception e) {
            e.printStackTrace(); // Manejo de excepciones según sea necesario
            tipos = new TipoEquipo[0]; // Si hay un error, devuelve un arreglo vacío
        }
        return new SpinnerListModel(tipos);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JButton aceptar;
    javax.swing.JTextArea areaOb;
    javax.swing.JTextArea areaSoft;
    javax.swing.JTextField campoActivo;
    javax.swing.JTextField campoApellidoMat;
    javax.swing.JTextField campoApellidoPat;
    javax.swing.JCheckBox campoCargador;
    javax.swing.JPasswordField campoContrasenia;
    javax.swing.JSpinner campoLocalidad;
    javax.swing.JSpinner campoMarca;
    javax.swing.JSpinner campoModelo;
    javax.swing.JTextField campoNombre;
    javax.swing.JTextField campoNumEmp;
    javax.swing.JSpinner campoPiso;
    javax.swing.JCheckBox campoRespaldo;
    javax.swing.JFormattedTextField campoTelefono;
    javax.swing.JSpinner campoTipo;
    javax.swing.JButton cancelar;
    javax.swing.JButton cargaImage;
    javax.swing.JPanel fantasma;
    javax.swing.JLabel jLabel1;
    javax.swing.JLabel jLabel10;
    javax.swing.JLabel jLabel12;
    javax.swing.JLabel jLabel13;
    javax.swing.JLabel jLabel14;
    javax.swing.JLabel jLabel2;
    javax.swing.JLabel jLabel3;
    javax.swing.JLabel jLabel4;
    javax.swing.JLabel jLabel5;
    javax.swing.JLabel jLabel6;
    javax.swing.JLabel jLabel7;
    javax.swing.JLabel jLabel8;
    javax.swing.JLabel jLabel9;
    javax.swing.JPanel jPanel1;
    javax.swing.JPanel jPanel2;
    javax.swing.JPanel jPanel3;
    javax.swing.JScrollPane jScrollPane1;
    javax.swing.JScrollPane jScrollPane2;
    javax.swing.JLabel mu;
    javax.swing.JPanel panelCargarImagen;
    javax.swing.JPanel panelCentral;
    javax.swing.JPanel panelImage;
    private static javax.swing.JSpinner spinnerFecha;
    // End of variables declaration//GEN-END:variables

    private ScheduledExecutorService scheduledExecutorService;
    static final private String IMAGEN = "/home/oscar/NetBeansProjects/MiMatis/src/main/java/org/matis/bonito/image/linux.jpg";
    private ImagenPanel imagePanel;
    private ImagenEnPanel imagenEnPanel;
    private ImageIcon qrIcon;
    private JLabel qrLabel;

}
