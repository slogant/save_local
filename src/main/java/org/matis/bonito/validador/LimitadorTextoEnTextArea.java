/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.matis.bonito.validador;

import javax.swing.JTextArea;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author slogant
 */
public class LimitadorTextoEnTextArea extends DocumentFilter {

    public LimitadorTextoEnTextArea(JTextArea area, int max) {
        this.area = area;
        this.max = max;
    }
    @Override
    public void replace(FilterBypass fb, int offset, int length,
            String text, AttributeSet attrs) throws BadLocationException {
        super.replace(fb, offset, length, text, attrs);
        int lines = area.getLineCount();
        if (lines > max) {
            int linesToRemove = lines - max - 1;
            int lengthToRemove = area.getLineStartOffset(linesToRemove);
            remove(fb, 0, lengthToRemove);
        }
    }
    private JTextArea area;
    private int max;
}
