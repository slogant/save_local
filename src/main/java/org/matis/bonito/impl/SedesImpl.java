package org.matis.bonito.impl;

import org.matis.bonito.model.Sedes;

import java.util.List;
import java.util.stream.Stream;

public interface SedesImpl {

    public default boolean crearSede(Sedes sedes) {
        return false;
    }

    public default boolean EliminarSede(String codigo_sede) {
        return false;
    }

    public default boolean actualizaSede(String codigo_sede, Sedes sedes) {
        return false;
    }

    public default Stream<Sedes> obtenerSedes() {
        return null;
    }
}
