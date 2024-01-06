/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.matis.bonito.validador;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author olopez
 */
public class LimitandorTexto extends PlainDocument {

    public LimitandorTexto(JTextField mijtext, int nroMaxCaract) {
        miJTextField = mijtext;
        nroMaxCaracteres = nroMaxCaract;
    }

    @Override
    public void insertString(int arg0, String arg1, AttributeSet arg2) throws BadLocationException {
        this.arg1 = arg1;
        for (int i = 0; i < arg1.length(); i++) {
            if ((miJTextField.getText().length() + arg1.length()) > nroMaxCaracteres) {
                return;
            } else if (!Character.isLetter(arg1.charAt(i)) && !Character.isSpaceChar(arg1.charAt(i))) {
                return;
            }
        }
        super.insertString(arg0, arg1, arg2);
    }
    private static final long serialVersionUID = 1016258660184807214L;
    private final JTextField miJTextField;
    private final int nroMaxCaracteres;
    private String arg1;
}
