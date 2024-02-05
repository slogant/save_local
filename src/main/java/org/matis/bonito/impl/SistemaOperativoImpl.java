package org.matis.bonito.impl;

import org.matis.bonito.model.SistemaOperativo;

import java.util.Optional;
import java.util.stream.Stream;

public interface SistemaOperativoImpl {
    default boolean crearSisOpe(SistemaOperativo sistemaOperativo) {
        return false;
    }

    default boolean EliminarSisOpe(String codigo_so) {
        return false;
    }

    default boolean actualizaSistemaOpe(String codigo_so, SistemaOperativo sistemaOperativo) {
        return false;
    }

    default Stream<SistemaOperativo> obtenerSistemaOperativoStream() {
        return null;
    }

    default SistemaOperativo obtenerUltimoFolio(String sistemaOperativo) {
        return null;
    }
    default SistemaOperativo obtenerSistemaOpe(String folio) {
        return null;
    }

    default SistemaOperativo obtenerSistemaOperativoActivo(String sisOpe) { return null; }

    default Optional<SistemaOperativo> obtenerUltimoRegistro() { return null; }
}
