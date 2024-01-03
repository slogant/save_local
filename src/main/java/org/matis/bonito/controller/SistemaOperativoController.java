package org.matis.bonito.controller;

import org.matis.bonito.impl.SistemaOperativoImpl;
import org.matis.bonito.model.SistemaOperativo;

import java.io.Serializable;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Objects.requireNonNull;
import static org.matis.bonito.db.ConectaEntityDB.obtenerEntityManager;
import static org.matis.bonito.db.ConectaEntityDB.obtenerEntityManagerFactory;

public class SistemaOperativoController implements Serializable, SistemaOperativoImpl {
    /**
     * @param sistemaOperativo 
     * @return
     */
    @Override
    public boolean crearSistemaOperativo(SistemaOperativo sistemaOperativo) {
        var em = obtenerEntityManagerFactory();
        var emf = obtenerEntityManager(em);
        try {
            requireNonNull(emf).getTransaction().begin();
            emf.persist(sistemaOperativo);
            requireNonNull(emf).getTransaction().commit();
            return emf.contains(sistemaOperativo);
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            if(requireNonNull(emf).getTransaction().isActive()) {
                requireNonNull(emf).getTransaction().rollback();
            }
            return false;
        } finally {
            if(requireNonNull(emf).isOpen()) {
                emf.clear();
                emf.close();
            }
            if(requireNonNull(em).isOpen()) {
                em.close();
            }
        }
    }

    /**
     * @param id_sistema 
     * @return
     */
    @Override
    public boolean EliminarSistemaOperativo(Long id_sistema) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            var encontrado = requireNonNull(emfc).find(SistemaOperativo.class,id_sistema);
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
     * @param sistemaOperativo
     * @return
     */
    @Override
    public boolean actualizaSistemaOperativo(SistemaOperativo sistemaOperativo) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            emfc.merge(sistemaOperativo);
            requireNonNull(emfc).getTransaction().commit();
            return emfc.contains(sistemaOperativo);
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
     * @return sistemaOperativoTypedQuery
     */
    @Override
    public Stream<SistemaOperativo> obtenerSistemaOperativo() {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            var sistemaOperativoTypedQuery = requireNonNull(emfa).createNamedQuery("SistemaOperativo.findAll",SistemaOperativo.class);
            return sistemaOperativoTypedQuery.getResultStream();
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