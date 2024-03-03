/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.matis.bonito.validador;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.SpinnerDateModel;

import static java.time.ZoneId.systemDefault;
import static java.util.Calendar.SECOND;
import static java.util.Date.from;

/**
 *
 * @author oscar
 */
public class LocalDateTimeSpinnerModel extends SpinnerDateModel {
    
        public LocalDateTimeSpinnerModel(LocalDateTime value) {
            super(from(value.atZone(systemDefault()).toInstant()), null, null, SECOND);
        }

        @Override
        public Object getNextValue() {
            var current = ((Date) getValue()).toInstant().atZone(systemDefault()).toLocalDateTime();
            return from(current.plusSeconds(1).atZone(systemDefault()).toInstant());
        }

        @Override
        public Object getPreviousValue() {
            var current = ((Date) getValue()).toInstant().atZone(systemDefault()).toLocalDateTime();
            return from(current.minusSeconds(1).atZone(systemDefault()).toInstant());
        }
    }