package org.matis.bonito.impl;

import org.matis.bonito.model.MarcaEquipo;

import java.util.stream.Stream;

public interface MarcaEquipoImpl {
    public boolean crearMarcaEquipo(MarcaEquipo marcaEquipo);
    public boolean EliminarMarcaEquipo(Long id_marca);
    public boolean actualizaMarcaEquipo(MarcaEquipo marcaEquipo);
    public Stream<MarcaEquipo> obtenerMarcaEquipo();
}
