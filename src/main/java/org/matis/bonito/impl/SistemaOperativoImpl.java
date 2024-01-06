package org.matis.bonito.impl;

import org.matis.bonito.model.Sedes;
import org.matis.bonito.model.SistemaOperativo;

import java.util.List;
import java.util.stream.Stream;

public interface SistemaOperativoImpl {
    public default boolean crearSistemaOperativo(SistemaOperativo sistemaOperativo) {
        return false;
    }

    public default boolean EliminarSistemaOperativo(Long id_sistema) {
        return false;
    }

    public default boolean actualizaSistemaOperativo(SistemaOperativo sistemaOperativo) {
        return false;
    }

    public default Stream<SistemaOperativo> obtenerSistemaOperativo() {
        return null;
    }
}
