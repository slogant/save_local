package org.matis.bonito.impl;

import org.matis.bonito.model.IngenieroSoporte;

import java.util.stream.Stream;

public interface IngSopImpl {
    
    default boolean crearIngSop(IngenieroSoporte ing) {
        return false;
    }

    default boolean eliminarIngsop(String numeroEmp) {
        return false;
    }

    default boolean actualizaIngSop(String numeroEmp, IngenieroSoporte ingenieroSoporte) {
        return false;
    }

    default Stream<IngenieroSoporte> obtenerIngSop() {
        return null;
    }


    default Stream<IngenieroSoporte> otenerIngSopNumEmp(String numeroEmp) {
        return null;
    }

    /**
     * @param numeroEmpleado
     * @return
     */
    default IngenieroSoporte obtenerIngenieroSoporteActivo(String numeroEmpleado) {
        return null;
    }
}
