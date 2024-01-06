/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.matis.bonito.validador;

import javax.swing.ImageIcon;

/**
 *
 * @author slogant
 */
final public class Utils {
     public static ImageIcon createIcon(String path) {
        var url = System.class.getResource(path);
        if(url == null) {
                System.err.println("Unable to load image: " + path);
        }
        var icon = new ImageIcon(url);
        return icon;
    }
}
