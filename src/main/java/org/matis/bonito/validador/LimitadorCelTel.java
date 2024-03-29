/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.matis.bonito.validador;

import javax.swing.JFormattedTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author oscar
 */
public class LimitadorCelTel extends PlainDocument {

    public LimitadorCelTel(JFormattedTextField field, int max) {
        fields = field;
        maxi = max;
    }

    @Override
    public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
        arg1 = arg1.toUpperCase();
        for (var i = 0; i < arg1.length(); i++) {
            if ((fields.getValue().toString().length() + arg1.length()) > maxi) {
                return;
            } else if (!Character.isDigit(arg1.charAt(i))) {
                return;
            }
        }
        super.insertString(arg0, arg1, arg2);
    }
    private static final long serialVersionUID = -3936120631727937165L;
    private final JFormattedTextField fields;
    private final int maxi;
}