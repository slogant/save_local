package org.matis.bonito.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "sedes")
@NamedQueries({
        @NamedQuery(name = "Sedes.findAll", query = "select s from Sedes s"),
        @NamedQuery(name = "Sedes.findByCodigo_sede", query = "select s from Sedes s where s.codigo_sede = ?1"),
        @NamedQuery(name = "Sedes.findByNombre_sede", query = "select s from Sedes s where s.nombre_sede = ?1"),
        @NamedQuery(name = "Sedes.findLast", query = "select s from Sedes s where s.nombre_sede = ?1 order by s.id_sede desc"),
        @NamedQuery(name = "Sedes.findByCodigo_sedelike", query = "select s from Sedes s where s.codigo_sede like ?1")
})

public class Sedes implements Serializable {

    public Sedes() {
    }

    public Sedes(String codigo_sede) {
        this.codigo_sede = codigo_sede;
    }

    public Sedes(long id_sede, String nombre_sede) {
        this.id_sede = id_sede;
        this.nombre_sede = nombre_sede;
    }

    public Sedes(String nombre_sede, String codigo_sede) {
        this.nombre_sede = nombre_sede;
        this.codigo_sede = codigo_sede;
    }

    public long getId_sede() {
        return id_sede;
    }

    public void setId_sede(long id_sede) {
        this.id_sede = id_sede;
    }

    public String getNombre_sede() {
        return nombre_sede;
    }

    public void setNombre_sede(String nombre_sede) {
        this.nombre_sede = nombre_sede;
    }

    public String getCodigo_sede() {
        return codigo_sede;
    }

    public void setCodigo_sede(String codigo_sede) {
        this.codigo_sede = codigo_sede;
    }

    @Override
    public String toString() {
        return STR."\{nombre_sede} \{codigo_sede}";
    }

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_sede;
    @Column(name = "nombre_sede",nullable = false,length = 200)
    private String nombre_sede;
    @Size(min = 4, max = 100)
    @NotNull
    @Column(name = "codigo_sede", unique = true)
    private String codigo_sede;
}
