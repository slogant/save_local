package org.matis.bonito.validador;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RandomGradientPanelThread extends JPanel {


    public RandomGradientPanelThread() {
        generateRandomGradient();
        startGradientTimer();
    }

    private void generateRandomGradient() {
        Random random = new Random();
        startColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        endColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    private void startGradientTimer() {
        timer = new Timer(1000, e -> {
            generateRandomGradient();
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        // Crear y aplicar gradiente
        GradientPaint gradient = new GradientPaint(0, 0, startColor, getWidth(), getHeight(), endColor);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
    }
    private Color startColor;
    private Color endColor;
    private Timer timer;
}
