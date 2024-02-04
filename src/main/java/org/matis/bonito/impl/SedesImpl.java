package org.matis.bonito.impl;

import org.matis.bonito.model.Sedes;

import java.util.Optional;
import java.util.stream.Stream;

public interface SedesImpl {

    default boolean crearSede(Sedes sedes) {
        return false;
    }

    default boolean EliminarSede(String codigo_sede) {
        return false;
    }

    default boolean actualizaSede(String codigo_sede, Sedes sedes) {
        return false;
    }

    default Stream<Sedes> obtenerSedes() {
        return null;
    }

    default Sedes obtenerUltimoFolio(String nombreSede) {
        return null;
    }
    default Sedes obtenerSede(String folio) {
        return null;
    }
    
    default Sedes obtenerSedeActivo(String sede) { return null; }

    default Optional<Sedes> obtenerUltimoRegistro() { return null; }
}
