package org.matis.bonito.impl;

import org.matis.bonito.model.IngenieroSoporte;

import java.util.List;
import java.util.stream.Stream;

public interface IngSopImpl {
    boolean crearIngSop(IngenieroSoporte ing);
    boolean eliminarIngsop(String numeroEmp);
    boolean actualizaIngSop(String numeroEmp, IngenieroSoporte ingenieroSoporte);
    Stream<IngenieroSoporte> obtenerIngSop();
    Stream<IngenieroSoporte> otenerIngSopNumEmp(String numeroEmp);
}
