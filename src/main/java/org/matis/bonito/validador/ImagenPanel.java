/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.matis.bonito.validador;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import static javax.imageio.ImageIO.read;

/**
 *
 * @author oscar
 */
public class ImagenPanel extends JPanel {

    private BufferedImage image;

    public ImagenPanel() {
        // Constructor
    }

    public void loadImage(String imageName) {
        // Obtener el ClassLoader asociado con la clase ImagePanel
        ClassLoader classLoader = ImagePanel.class.getClassLoader();

        try {
            // Cargar la imagen utilizando el ClassLoader
            InputStream inputStream = classLoader.getResourceAsStream(imageName);
            if (inputStream != null) {
                image = ImageIO.read(inputStream);
                // Redimensionar la imagen si es necesario
                resizeImage();
                // Repintar el JPanel para mostrar la imagen cargada
                repaint();
            } else {
                System.err.println("No se pudo encontrar la imagen: " + imageName);
            }
        } catch (IOException e) {
            // Manejar errores de lectura de la imagen
            e.printStackTrace();
        }
    }


    private void resizeImage() {
        if (image != null && image.getWidth() > 0 && image.getHeight() > 0) {
            // Redimensionar la imagen si tiene dimensiones válidas
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Calcular el factor de escala para ajustar la imagen al panel
            double scaleX = (double) panelWidth / image.getWidth();
            double scaleY = (double) panelHeight / image.getHeight();
            double scale = Math.min(scaleX, scaleY);

            // Redimensionar la imagen utilizando el factor de escala
            int newWidth = (int) (image.getWidth() * scale);
            int newHeight = (int) (image.getHeight() * scale);

            // Crear una nueva imagen redimensionada
            BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = resizedImage.createGraphics();
            g2d.drawImage(image, 0, 0, newWidth, newHeight, null);
            g2d.dispose();

            // Asignar la imagen redimensionada
            image = resizedImage;
        } else {
            System.err.println("La imagen tiene dimensiones no válidas.");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen en el JPanel si está cargada
        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        // Devolver un tamaño predeterminado para el JPanel
        return new Dimension(400, 300);
    }
}
