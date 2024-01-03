/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.matis.bonito.init;

import org.matis.bonito.vista.InitForm;

import javax.swing.UnsupportedLookAndFeelException;

import static java.awt.EventQueue.invokeLater;
import static java.util.logging.Level.*;
import static java.util.logging.Logger.*;
import static javax.swing.UIManager.getInstalledLookAndFeels;
import static javax.swing.UIManager.setLookAndFeel;

/**
 *
 * @author oscar
 */
public class Inicia {
    
    public static void main(String... args) {
        try {
            for (var info : getInstalledLookAndFeels()) {
                if (info.getName().equals("Metal")) {
                    setLookAndFeel(info.getClassName());
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            getLogger(InitForm.class.getName()).log(SEVERE, null, ex);
        }
        /* Create and display the form */
        invokeLater(() -> new InitForm().setVisible(true));
    }
}
