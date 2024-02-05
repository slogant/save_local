package org.matis.bonito.impl;

import org.matis.bonito.model.TipoEquipo;

import java.util.Optional;
import java.util.stream.Stream;

public interface TipoEquipoImpl {

    /**
     *
     * @param tipoEquipo
     * @return
     */
    default boolean crearTipoEquipo(TipoEquipo tipoEquipo) { return false; }

    default boolean eliminarTipoEquipo(String codigoTipo) {
        return false;
    }

    default boolean actualizaTipoEquipo(String codigoTipo, TipoEquipo tipoEquipo) {
        return false;
    }

    default Stream<TipoEquipo> obtenerTipoEquipos() {
        return null;
    }

    default Stream<TipoEquipo> obtenerTipoEquipoCodigo(String codigoTipo) {
        return null;
    }

    default TipoEquipo obtenerTipoEquipoActivo(String codigoTipo) { return null; }

    default Optional<TipoEquipo> obtenerUltimoTipoEquipoRegistro() { return null; }
}
