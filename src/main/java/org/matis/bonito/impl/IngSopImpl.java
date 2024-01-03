package org.matis.bonito.impl;

import org.matis.bonito.model.IngenieroSoporte;

import java.util.List;
import java.util.stream.Stream;

public interface IngSopImpl {
    public boolean crearIngSop(IngenieroSoporte ing);
    public boolean eliminarIngsop(String numeroEmp);
    public boolean actualizaIngSop(String numeroEmp,IngenieroSoporte ingenieroSoporte);
    public Stream<IngenieroSoporte> obtenerIngSop();
    public Stream<IngenieroSoporte> otenerIngSopNumEmp(String numeroEmp);
}
