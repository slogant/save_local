package org.matis.bonito.impl;

import org.matis.bonito.model.MarcaEquipo;

import java.util.stream.Stream;

public interface MarcaEquipoImpl {
    default boolean crearMarcaEquipo(MarcaEquipo marcaEquipo) {
        return false;
    }

    default boolean EliminarMarcaEquipo(Long id_marca) {
        return false;
    }

    default boolean actualizaMarcaEquipo(MarcaEquipo marcaEquipo) {
        return false;
    }

    default Stream<MarcaEquipo> obtenerMarcaEquipo() {
        return null;
    }
}
