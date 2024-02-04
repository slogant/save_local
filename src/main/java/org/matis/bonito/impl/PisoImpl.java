package org.matis.bonito.impl;

import org.matis.bonito.model.Piso;

import java.util.Optional;
import java.util.stream.Stream;

public interface PisoImpl {
    default boolean crearPiso(Piso piso) {
        return false;
    }

    default boolean EliminarPiso(String codigo_piso) {
        return false;
    }

    default boolean actualizaPiso(String codigo_piso, Piso piso) {
        return false;
    }

    default Stream<Piso> obtenerPiso() {
        return null;
    }

    default Piso obtenerUltimoFolio(String nombrePiso) {
        return null;
    }

    default Piso obtenerPiso(String folio) {
        return null;
    }

    default Piso obtenerPisoActivo(String piso) { return null; }

    default Optional<Piso> obtenerUltimoPisoRegistro() { return null; }
}
