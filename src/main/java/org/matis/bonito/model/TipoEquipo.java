package org.matis.bonito.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
@Entity
@Table(name = "tipoequipo")
@NamedQueries({
        @NamedQuery(name = "TipoEquipo.findAll", query = "select t from TipoEquipo t"),
        @NamedQuery(name = "TipoEquipo.findByCodigo_tipó", query = "select t from TipoEquipo t where t.codigo_tipo = ?1"),
        @NamedQuery(name = "TipoEquipo.findLastCodigoSede", query = "select t from TipoEquipo t  order by t.id_tipo desc")
})

public class TipoEquipo implements Serializable {
    public TipoEquipo() {
    }
    public TipoEquipo(String nombre_tipo, String codigo_sede) {
        this.nombre_tipo = nombre_tipo;
        this.codigo_sede = codigo_sede;
    }

    public long getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(long id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getNombre_tipo() {
        return nombre_tipo;
    }

    public void setNombre_tipo(String nombre_tipo) {
        this.nombre_tipo = nombre_tipo;
    }

    public String getCodigo_tipo() {
        return codigo_tipo;
    }

    public void setCodigo_tipo(String codigo_tipo) {
        this.codigo_tipo = codigo_tipo;
    }
    @Override
    public String toString() {
        return STR."\{nombre_tipo} \{codigo_tipo}";
    }

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_tipo;
    @Column(name = "nombre_tipo",nullable = false,length = 200, unique = true)
    private String nombre_tipo;
    @Size(min = 4, max = 100)
    @NotNull
    @Column(name = "codigo_tipo", unique = true)
    private String codigo_tipo;
}
