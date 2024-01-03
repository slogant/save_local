package org.matis.bonito.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
@Entity
@Table(name = "marcaequipo")
@NamedQueries({
        @NamedQuery(name = "MarcaEquipo.findAll", query = "select m from MarcaEquipo m")
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

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laptop", nullable = false)
    private Long id_laptop;
    @NotEmpty
    @Column(name = "nombre_marca", nullable = false,length = 200)
    private String nombre_marca;
    @NotEmpty
    @Column(name = "descripcion", nullable = false,length = 200)
    private String descripcion;
}