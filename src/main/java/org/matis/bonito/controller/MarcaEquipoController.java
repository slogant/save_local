package org.matis.bonito.controller;

import org.matis.bonito.impl.MarcaEquipoImpl;
import org.matis.bonito.model.MarcaEquipo;

import java.io.Serializable;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Objects.requireNonNull;
import static org.matis.bonito.db.ConectaEntityDB.obtenerEntityManager;
import static org.matis.bonito.db.ConectaEntityDB.obtenerEntityManagerFactory;

public class MarcaEquipoController implements Serializable, MarcaEquipoImpl {
    /**
     * @param marcaEquipo
     * @return
     */
    @Override
    public boolean crearMarcaEquipo(MarcaEquipo marcaEquipo) {
        var em = obtenerEntityManagerFactory();
        var emf = obtenerEntityManager(em);
        try {
            requireNonNull(emf).getTransaction().begin();
            emf.persist(marcaEquipo);
            requireNonNull(emf).getTransaction().commit();
            return emf.contains(marcaEquipo);
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            requireNonNull(emf).getTransaction().rollback();
            return false;
        } finally {
            if(requireNonNull(emf).isOpen()) {
                emf.clear();
                emf.close();
            }
            if(requireNonNull(em).isOpen()){
                em.close();
            }
        }
    }

    /**
     * @param id_marca
     * @return
     */
    @Override
    public boolean EliminarMarcaEquipo(Long id_marca) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            var encontrado = requireNonNull(emfc).find(MarcaEquipo.class,id_marca);
            requireNonNull(emfc).getTransaction().commit();
            requireNonNull(emfc).getTransaction().begin();
            emfc.remove(encontrado);
            requireNonNull(emfc).getTransaction().commit();
            return !emfc.contains(encontrado);
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            requireNonNull(emfc).getTransaction().rollback();
            return false;
        } finally {
            if(requireNonNull(emfc).isOpen()) {
                emfc.clear();
                emfc.close();
            }
            if (emt != null && emt.isOpen()) {
                emt.close();
            }
        }
    }

    /**
     * @param marcaEquipo
     * @return
     */
    @Override
    public boolean actualizaMarcaEquipo(MarcaEquipo marcaEquipo) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            emfc.merge(marcaEquipo);
            requireNonNull(emfc).getTransaction().commit();
            return emfc.contains(marcaEquipo);
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            requireNonNull(emfc).getTransaction().rollback();
            return false;
        } finally {
            if(requireNonNull(emt).isOpen()) {
                emt.close();
            }
            if(requireNonNull(emfc).isOpen()){
                emfc.clear();
                emfc.close();
            }
        }
    }

    /**
     * @return marcaEquipoTypedQuery
     */
    @Override
    public Stream<MarcaEquipo> obtenerMarcaEquipo() {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            var marcaEquipoTypedQuery = requireNonNull(emfa).createNamedQuery("MarcaEquipo.findAll",MarcaEquipo.class);
            return marcaEquipoTypedQuery.getResultStream();
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            return null;
        } finally {
            if(requireNonNull(emfa).isOpen()) {
                emfa.clear();
                emfa.close();
            }
            if(requireNonNull(emt).isOpen()){
                emt.close();
            }
        }
    }
}
