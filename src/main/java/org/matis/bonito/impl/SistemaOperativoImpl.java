package org.matis.bonito.impl;

import org.matis.bonito.model.SistemaOperativo;

import java.util.stream.Stream;

public interface SistemaOperativoImpl {
    default boolean crearSistemaOperativo(SistemaOperativo sistemaOperativo) {
        return false;
    }

    default boolean EliminarSistemaOperativo(Long id_sistema) {
        return false;
    }

    default boolean actualizaSistemaOperativo(SistemaOperativo sistemaOperativo) {
        return false;
    }

    default Stream<SistemaOperativo> obtenerSistemaOperativo() {
        return null;
    }
}
