/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.matis.bonito.validador;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Math.PI;
import static java.lang.Math.sin;
import static javax.imageio.ImageIO.read;

/**
 *
 * @author oscar
 */
public class ImagePanel extends JPanel {


    public ImagePanel(String imagePath) {
        try {
            // Carga la imagen en color desde el archivo
            colorImage = read(new File(imagePath));
            // Convierte la imagen en blanco y negro
            var grayImage = toGrayScale(colorImage);
            // Inicializa la imagen actual como la imagen en color
            currentImage = colorImage;
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        // Inicia el ciclo de animación en un hilo de fondo
        var worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                do {
                    // Actualiza el ángulo de rotación, la transición de color y el factor de zoom
                    rotationAngle += PI / 180; // Incremento de 1 grado en radianes
                    if (rotationAngle >= PI * 2) {
                        rotationAngle = 0; // Reinicia la rotación después de 360 grados
                    }
                    transitionValue = (float) ((1 + sin(rotationAngle)) / 2); // Aplica una función seno para la transición de color
                    zoomFactor += 0.01f; // Incrementa el factor de zoom
                    if (zoomFactor > 1.5f) {
                        zoomFactor = 1.0f; // Reinicia el zoom después de 1.5 veces
                    }
                    repaint(); // Vuelve a pintar el panel
                    Thread.sleep(50); // Cambia el intervalo según la velocidad de la animación (en milisegundos)
                } while (true);
            }
        };
        worker.execute();
    }

    // Método para convertir la imagen en blanco y negro
    private BufferedImage toGrayScale(BufferedImage originalImage) {
        var grayImage = new BufferedImage(originalImage.getWidth(), originalImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
        var g = grayImage.getGraphics();
        g.drawImage(originalImage, 0, 0, null);
        g.dispose();
        return grayImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var g2d = (Graphics2D) g;
        // Aplica la transformación para el zoom
        AtomicReference<AffineTransform> originalTransform = new AtomicReference<>(g2d.getTransform());
        g2d.scale(zoomFactor, zoomFactor);

        // Dibuja la imagen actual con la transición de color y la rotación
        g2d.rotate(rotationAngle, (double) getWidth() / 2 / zoomFactor, (double) getHeight() / 2 / zoomFactor); // Rotación centrada en el panel
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f - transitionValue));
        g2d.drawImage(currentImage, 0, 0, getWidth(), getHeight(), null);

        // Restaura la transformación original
        g2d.setTransform(originalTransform.get());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int) (colorImage.getWidth() * zoomFactor), (int) (colorImage.getHeight() * zoomFactor));
    }

    private BufferedImage colorImage;
    private BufferedImage currentImage; // Imagen actual a mostrar (color o en blanco y negro)
    private double rotationAngle = 0.0;
    private float transitionValue = 0.0f;
    private float zoomFactor = 1.0f;
}
