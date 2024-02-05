package org.matis.bonito.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "marcaequipo")
@NamedQueries({
    @NamedQuery(name = "MarcaEquipo.findAll", query = "select m from MarcaEquipo m"),
    @NamedQuery(name = "MarcaEquipo.findBycodigo_marca", query = "select m from MarcaEquipo m where m.codigo_marca = ?1"),
    @NamedQuery(name = "MarcaEquipo.findLastcodigo_marca", query = "select m from MarcaEquipo m order by m.id_laptop desc"),
    @NamedQuery(name = "MarcaEquipo.findByMarcaEquipolike", query = "select m from MarcaEquipo m where m.codigo_marca like ?1"),
    @NamedQuery(name = "MarcaEquipo.findByNombre_marca", query = "select m from MarcaEquipo m where m.nombre_marca = ?1")
})
public class MarcaEquipo implements Serializable {

    public MarcaEquipo() {
    }

    public MarcaEquipo(String nombre_marca, String descripcion) {
        this.nombre_marca = nombre_marca;
        this.descripcion = descripcion;
    }

    public MarcaEquipo(Long id_laptop, String nombre_marca, String descripcion) {
        this.id_laptop = id_laptop;
        this.nombre_marca = nombre_marca;
        this.descripcion = descripcion;
    }

    public MarcaEquipo(String nombre_marca, String codigo_marca, String descripcion) {
        this.nombre_marca = nombre_marca;
        this.codigo_marca = codigo_marca;
        this.descripcion = descripcion;
    }

    public Long getId_laptop() {
        return id_laptop;
    }

    public void setId_laptop(Long id_laptop) {
        this.id_laptop = id_laptop;
    }

    public String getNombre_marca() {
        return nombre_marca;
    }

    public void setNombre_marca(String nombre_marca) {
        this.nombre_marca = nombre_marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return nombre_marca;
    }

    public String getCodigo_marca() {
        return codigo_marca;
    }

    public void setCodigo_marca(String codigo_marca) {
        this.codigo_marca = codigo_marca;
    }

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laptop", nullable = false)
    private Long id_laptop;
    @NotEmpty
    @Column(name = "nombre_marca", nullable = false, length = 200, unique = true)
    private String nombre_marca;
    @NotEmpty
    @Column(name = "codigo_marca", nullable = false, length = 200, unique = true)
    private String codigo_marca;
    @NotEmpty
    @Column(name = "descripcion", nullable = true, length = 200)
    private String descripcion;
}
