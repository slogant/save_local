package org.matis.bonito.impl;

import org.matis.bonito.model.IngenieroSoporte;
import org.matis.bonito.model.TipoEquipo;

import java.util.stream.Stream;

public interface TipoEquipoImpl {

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

    default IngenieroSoporte obtenerIngenieroSoporteActivo(String numeroEmpleado) {
        return null;
    }
}
