/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.matis.bonito.validador;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 */
public class ImageIconPanel extends JPanel {
    private ImageIcon icon;

    public ImageIconPanel(ImageIcon icon) {
        this.icon = icon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (icon != null) {
            int x = (getWidth() - icon.getIconWidth()) / 2;
            int y = (getHeight() - icon.getIconHeight()) / 2;
            icon.paintIcon(this, g, x, y);
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Dimension getPreferredSize() {
        if (icon != null) {
            return new Dimension(icon.getIconWidth(), icon.getIconHeight());
        } else {
            return super.getPreferredSize();
        }
    }

    public void setIcon(ImageIcon icon) {
        this.icon = icon;
        revalidate(); // Vuelve a calcular el diseño del contenedor
        repaint();
    }
}

