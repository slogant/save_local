package org.matis.bonito.impl;

import org.matis.bonito.model.Sedes;
import org.matis.bonito.model.SistemaOperativo;

import java.util.List;
import java.util.stream.Stream;

public interface SistemaOperativoImpl {
    public boolean crearSistemaOperativo(SistemaOperativo sistemaOperativo);
    public boolean EliminarSistemaOperativo(Long id_sistema);
    public boolean actualizaSistemaOperativo(SistemaOperativo sistemaOperativo);
    public Stream<SistemaOperativo> obtenerSistemaOperativo();
}
