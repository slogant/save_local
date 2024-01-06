/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.matis.bonito.validador;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {

    public ResultSetTableModel(ResultSet unResulSet) {
        this.rs = unResulSet;
        try {
            this.rsmd = this.rs.getMetaData();
        } catch (SQLException var3) {
            System.out.println("Error al traer los metadados" + var3.getLocalizedMessage());
        }
    }

    @Override
    public String getColumnName(int c) {
        try {
            return this.rsmd.getColumnName(c + 1);
        } catch (SQLException var3) {
            System.out.println("Error al traer los nombres de columnas" + var3.getLocalizedMessage());
            return "";
        }
    }

    @Override
    public int getRowCount() {
        try {
            this.rs.last();
            return this.rs.getRow();
        } catch (SQLException var2) {
            System.out.println("Error al traer el número de filas" + var2.getLocalizedMessage());
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        try {
            return this.rsmd.getColumnCount();
        } catch (SQLException var2) {
            System.out.println("Error al traer el número de columnas: " + var2.getLocalizedMessage());
            return 0;
        }
    }

    @Override
    public Object getValueAt(int r, int c) {
        try {
            this.rs.absolute(r + 1);
            return this.rs.getObject(c + 1);
        } catch (SQLException e) {
            System.out.println("Error al traer los valores: " + e.getLocalizedMessage());
            return null;
        }
    }
    
    /**
     * Don't need to implement this method unless your table's editable.
     * @param row
     * @param col
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        return (col >= 1);
    }
    
    private ResultSet rs;
    private ResultSetMetaData rsmd;
}