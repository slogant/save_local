package org.matis.bonito.impl;

import java.util.Optional;
import org.matis.bonito.model.MarcaEquipo;

import java.util.stream.Stream;

public interface MarcaEquipoImpl {

    default boolean crearMarcaEquipo(MarcaEquipo marcaEquipo) { return false; }

    default boolean eliminarMarcaEquipo(String codigoMarca) { return false; }

    default boolean actualizaMarcaEquipo(String codigoMarca, MarcaEquipo marcaEquipo) { return false; }

    default Stream<MarcaEquipo> obtenerMarcaEquipos() { return null; }

    default Stream<MarcaEquipo> obtenerCodigoMarca(String codigoMarca) { return null; }

    default MarcaEquipo obtenerMarcaActivo(String codigoMarca) { return null; }

    default Optional<MarcaEquipo> obtenerUltimoRegistroMarca() { return null; }
}
