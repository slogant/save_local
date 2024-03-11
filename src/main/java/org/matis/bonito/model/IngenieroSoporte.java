package org.matis.bonito.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import static java.lang.StringTemplate.STR;

/**
 * This class represents an Engineer Support entity.
 */
@Entity
@Table(name = "ingeniero_soporte")
@NamedQueries({
        @NamedQuery(name = "All.Ing", query = "select i from IngenieroSoporte i"),
        @NamedQuery(name = "IngenieroSoporte.countBy", query = "select count(i) from IngenieroSoporte i"),
        @NamedQuery(name = "FindBy.NumeroEmp", query = "select i from IngenieroSoporte i where i.numero_empleado like ?1"),
        @NamedQuery(name = "IngenieroSoporte.countByNumero_empleado", query = "select count(i) from IngenieroSoporte i where i.numero_empleado = ?1"),
        @NamedQuery(name = "IngenieroSoporte.findByNumero_Empleado", query = "select  i from IngenieroSoporte i where i.numero_empleado = ?1"),
        @NamedQuery(name = "Find.IngNum", query = "select i from IngenieroSoporte i where i.numero_empleado = :numero_empleado")
})
public class IngenieroSoporte implements Serializable {

    public IngenieroSoporte() {
    }
    public IngenieroSoporte(String nombre_ing, String apellido_pat, String apellido_mat) {
        this.nombre_ing = nombre_ing;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
    }

    public IngenieroSoporte(String nombre_ing, String apellido_pat, String apellido_mat, String numero_empleado) {
        this.nombre_ing = nombre_ing;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
        this.numero_empleado = numero_empleado;
    }

    public IngenieroSoporte(Long id_ing_soporte, String nombre_ing, String apellido_pat, String apellido_mat, String numero_empleado) {
        this.id_ing_soporte = id_ing_soporte;
        this.nombre_ing = nombre_ing;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
        this.numero_empleado = numero_empleado;
    }

    public IngenieroSoporte(Long id_ing_soporte, String nombre_ing, String apellido_pat, String apellido_mat) {
        this.id_ing_soporte = id_ing_soporte;
        this.nombre_ing = nombre_ing;
        this.apellido_pat = apellido_pat;
        this.apellido_mat = apellido_mat;
    }

    public Long getId_ing_soporte() {
        return id_ing_soporte;
    }

    public void setId_ing_soporte(Long id_ing_soporte) {
        this.id_ing_soporte = id_ing_soporte;
    }

    public String getNombre_ing() {
        return nombre_ing;
    }

    public void setNombre_ing(String nombre_ing) {
        this.nombre_ing = nombre_ing;
    }

    public String getApellido_pat() {
        return apellido_pat;
    }

    public void setApellido_pat(String apellido_pat) {
        this.apellido_pat = apellido_pat;
    }

    public String getApellido_mat() {
        return apellido_mat;
    }

    public void setApellido_mat(String apellido_mat) {
        this.apellido_mat = apellido_mat;
    }

    public String getNumero_empleado() {
        return numero_empleado;
    }

    public void setNumero_empleado(String numero_empleado) {
        this.numero_empleado = numero_empleado;
    }

    @Override
    public String toString() {
        return STR."\{nombre_ing} \{apellido_pat} \{apellido_mat} \{numero_empleado}";
    }

    @NotNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ing_soporte;
    @Size(min = 9, max = 250)
    @NotNull(message = "El campo nombre  no puede ser vacio")
    @Column(name = "nombre_ing",nullable = false)
    private String nombre_ing;
    @NotNull
    @Column(name = "apellido_pat",nullable = false,length = 80)
    private String apellido_pat;
    @NotNull
    @Column(name = "apellido_mat",nullable = false,length = 80)
    private String apellido_mat;
    @NotNull
    @Column(name = "numero_empleado", length = 180, unique = true)
    private String numero_empleado;
}
