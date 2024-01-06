package org.matis.bonito.impl;

import org.matis.bonito.model.MarcaEquipo;

import java.util.stream.Stream;

public interface MarcaEquipoImpl {
    boolean crearMarcaEquipo(MarcaEquipo marcaEquipo);
    boolean EliminarMarcaEquipo(Long id_marca);
    boolean actualizaMarcaEquipo(MarcaEquipo marcaEquipo);
    Stream<MarcaEquipo> obtenerMarcaEquipo();
}
