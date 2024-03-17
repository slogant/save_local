/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.matis.bonito.validador;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 */
public class ImagenEnPanel extends JPanel {

    private BufferedImage image;

    public ImagenEnPanel() {
        // Inicializa el JPanel con un tamaño predeterminado
        setPreferredSize(new Dimension(400, 300));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (image != null) {
            // Escala la imagen al tamaño del JPanel
            Image scaledImage = image.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            // Dibuja la imagen
            g.drawImage(scaledImage, 0, 0, null);
        }
    }

    public void setImage(BufferedImage newImage) {
        this.image = newImage;
        repaint(); // Vuelve a dibujar el JPanel con la nueva imagen
    }
}
