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
public class LimitadorJTextArea extends DocumentFilter {

    public LimitadorJTextArea(JTextArea area, int max) {
        this.area = area;
        this.max = max;
    }
    @Override
    public void replace(FilterBypass fb, int offset, int length,
            String text, AttributeSet attrs) throws BadLocationException {
        super.replace(fb, offset, length, text, attrs);
        var lines = area.getLineCount();
        if (lines > max) {
            var linesToRemove = lines - max - 1;
            var lengthToRemove = area.getLineStartOffset(linesToRemove);
            remove(fb, 0, lengthToRemove);
        }
    }
    private JTextArea area;
    private int max;
}
