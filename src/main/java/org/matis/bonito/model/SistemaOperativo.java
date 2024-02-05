package org.matis.bonito.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "sistema_operativo")
@NamedQueries({
        @NamedQuery(name = "SistemaOperativo.findAll", query = "select s from SistemaOperativo s"),
        @NamedQuery(name = "SistemaOperativo.countBy", query = "select count(s) from SistemaOperativo s"),
        @NamedQuery(name = "SistemaOperativo.deleteById_sistema", query = "delete from SistemaOperativo s where s.id_sistema = :id_sistema"),
        @NamedQuery(name = "SistemaOperativo.findByCodigo_sislike", query = "select s from SistemaOperativo s where s.codigo_so like ?1"),
        @NamedQuery(name = "SistemaOperativo.findLast", query = "select s from SistemaOperativo s order by s.id_sistema DESC"),
        @NamedQuery(name = "SistemaOperativo.findByNombre_so", query = "select s from SistemaOperativo s where s.nombre_so = ?1")
})

public class SistemaOperativo implements Serializable {

    public SistemaOperativo() {
    }
    public SistemaOperativo(String nombre_so, String bits_so) {
        this.nombre_so = nombre_so;
        this.bits_so = bits_so;
    }

    public SistemaOperativo(String nombre_so, String bits_so, String codigo_so) {
        this.nombre_so = nombre_so;
        this.bits_so = bits_so;
        this.codigo_so = codigo_so;
    }

    public SistemaOperativo(Long id_sistema, String nombre_so, String bits_so) {
        this.id_sistema = id_sistema;
        this.nombre_so = nombre_so;
        this.bits_so = bits_so;
    }

    public Long getId_sistema() {
        return id_sistema;
    }

    public void setId_sistema(Long id_sistema) {
        this.id_sistema = id_sistema;
    }

    public String getNombre_so() {
        return nombre_so;
    }

    public void setNombre_so(String nombre_so) {
        this.nombre_so = nombre_so;
    }

    public String getBits_so() {
        return bits_so;
    }

    public void setBits_so(String bits_so) {
        this.bits_so = bits_so;
    }

    public String getCodigo_so() {
        return codigo_so;
    }
    public void setCodigo_so(String codigo_so) {
        this.codigo_so = codigo_so;
    }

    @Override
    public String toString() {
        return STR."\{nombre_so} \{bits_so}";
    }

    @Id
    @Column(name = "id_sistema",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_sistema;
    @Column(name = "nombre_so",nullable = false,length = 80)
    private String nombre_so;
    @Column(name = "bits_so",unique = true,length = 60)
    private String bits_so;
    @Size(min = 4, max = 100)
    @NotNull
    @Column(name = "codigo_so", unique = true)
    private String codigo_so;
}