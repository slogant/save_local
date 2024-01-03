package org.matis.bonito.impl;

import org.matis.bonito.model.Sedes;

import java.util.List;
import java.util.stream.Stream;

public interface SedesImpl {

    public boolean crearSede(Sedes sedes);
    public boolean EliminarSede(String codigo_sede);
    public boolean actualizaSede(String codigo_sede,Sedes sedes);
    public Stream<Sedes> obtenerSedes();
}
