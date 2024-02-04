package org.matis.bonito.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

@Entity
@Table(name = "piso")
@NamedQueries({
        @NamedQuery(name = "Piso.findAll", query = "select p from Piso p"),
        @NamedQuery(name = "Piso.findCodigoPiso", query = "select p from Piso p where p.codigo_piso = ?1"),
        @NamedQuery(name = "Piso.findLastCodigoPiso", query = "select p from Piso p order by p.codigo_piso DESC"),
        @NamedQuery(name = "Piso.findByCodigoPiso_pisolike", query = "select p from Piso p where p.codigo_piso like ?1"),
        @NamedQuery(name = "Piso.findByCodigo_pisolike", query = "select p from Piso p where p.codigo_piso like ?1"),
        @NamedQuery(name = "Piso.findByNombre_piso", query = "select p from Piso p where p.nombre_piso = ?1"),
})
public class Piso implements Serializable {
    public Piso() {
    }

    public Piso(Long id_piso, String nombre_piso, String codigo_piso) {
        this.id_piso = id_piso;
        this.nombre_piso = nombre_piso;
        this.codigo_piso = codigo_piso;
    }

    public Piso(String nombre_piso, String codigo_piso) {
        this.nombre_piso = nombre_piso;
        this.codigo_piso = codigo_piso;
    }

    public Long getId() {
        return id_piso;
    }

    public void setId(Long id_piso) {
        this.id_piso = id_piso;
    }

    public String getNombre_piso() {
        return nombre_piso;
    }

    public void setNombre_piso(String nombre_piso) {
        this.nombre_piso = nombre_piso;
    }

    public String getCodigo_piso() {
        return codigo_piso;
    }

    public void setCodigo_piso(String codigo_piso) {
        this.codigo_piso = codigo_piso;
    }
    @Override
    public String toString() {
        return STR."\{nombre_piso} \{codigo_piso}";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_piso", nullable = false)
    private Long id_piso;
    @Column(name = "nombre_piso", nullable = false, length = 200, unique = true)
    private String nombre_piso;
    @Size(min = 4, max = 100)
    @NotNull
    @Column(name = "codigo_piso", nullable = false, unique = true)
    private String codigo_piso;

}

