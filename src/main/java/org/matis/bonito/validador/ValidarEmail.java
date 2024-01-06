/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.matis.bonito.validador;

import java.util.regex.Pattern;

/**
 *
 * @author olopez
 */
public class ValidarEmail {

    /**
     * Validate given email with regular expression.
     *
     * @param email email for validation
     * @return true valid email, otherwise false
     */
    static public boolean validaEmail(String email) {

        // Compiles the given regular expression into a pattern.
        var pattern = Pattern.compile(PATTERN_EMAIL);

        // Match the given input against this pattern
        var matcher = pattern.matcher(email);
        return matcher.matches();

    }
    static final private String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
}
