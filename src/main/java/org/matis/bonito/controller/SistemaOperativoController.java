package org.matis.bonito.controller;

import org.matis.bonito.impl.SistemaOperativoImpl;
import org.matis.bonito.model.Piso;
import org.matis.bonito.model.SistemaOperativo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Objects.requireNonNull;
import static java.util.Optional.empty;
import static org.matis.bonito.db.ConectaEntityDB.obtenerEntityManager;
import static org.matis.bonito.db.ConectaEntityDB.obtenerEntityManagerFactory;

public class SistemaOperativoController implements Serializable, SistemaOperativoImpl {
    /**
     * @param sistemaOperativo 
     * @return
     */
    @Override
    public boolean crearSisOpe(SistemaOperativo sistemaOperativo) {
        var em = obtenerEntityManagerFactory();
        var emf = obtenerEntityManager(em);
        try {
            requireNonNull(emf).getTransaction().begin();
            emf.persist(sistemaOperativo);
            requireNonNull(emf).getTransaction().commit();
            return emf.contains(sistemaOperativo);
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            if (requireNonNull(emf).getTransaction().isActive()) {
                requireNonNull(emf).getTransaction().rollback();
            }
            return false;
        } finally {
            if (requireNonNull(emf).isOpen()) {
                emf.clear();
                emf.close();
                out.println("Cerrando entitymanagerfactory.............");
            }
            if (requireNonNull(em).isOpen()) em.close();
            out.println("Cerrando entitymanager.............");
        }
    }

    @Override
    public boolean EliminarSisOpe(String codigo_so) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            var sisOpTypedQuery = requireNonNull(emfc).createNamedQuery("SistemaOperativo.findByCodigo_sislike", SistemaOperativo.class);
            sisOpTypedQuery.setParameter(1, codigo_so);
            var sos = sisOpTypedQuery.setMaxResults(1).getSingleResult();
            requireNonNull(emfc).getTransaction().commit();
            requireNonNull(emfc).getTransaction().begin();
            emfc.remove(sos);
            requireNonNull(emfc).getTransaction().commit();
            return !emfc.contains(sos);
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            requireNonNull(emfc).getTransaction().rollback();
            return false;
        } finally {
            if (requireNonNull(emfc).isOpen()) {
                emfc.clear();
                emfc.close();
                out.println("Cerrando entitymanagerfactory.............");
            }
            if (emt != null && emt.isOpen()) emt.close();
            out.println("Cerrando entitymanager.............");
        }
    }

    /**
     * @param sistemaOperativo
     * @return
     */
    @Override
    public boolean actualizaSistemaOpe(String codigo_so, SistemaOperativo sistemaOperativo) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            var sisOpeTypedQuery = requireNonNull(emfc).createNamedQuery("SistemaOperativo.findByCodigo_sislike", SistemaOperativo.class);
            sisOpeTypedQuery.setParameter(1, codigo_so);
            var sisOpe = sisOpeTypedQuery.setMaxResults(1).getSingleResult();
            requireNonNull(emfc).getTransaction().commit();
            requireNonNull(emfc).getTransaction().begin();
            sisOpe.setNombre_so(sisOpe.getNombre_so());
            sisOpe.setBits_so(sisOpe.getBits_so());
            sisOpe.setCodigo_so(sisOpe.getCodigo_so());
            emfc.merge(sisOpe);
            requireNonNull(emfc).getTransaction().commit();
            return emfc.contains(sisOpe);
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            requireNonNull(emfc).getTransaction().rollback();
            return false;
        } finally {
            if (requireNonNull(emt).isOpen()) emt.close();
            out.println("Cerrando entitymanager.............");
            if (requireNonNull(emfc).isOpen()) {
                emfc.clear();
                emfc.close();
                out.println("Cerrando entitymanagerfactory.............");
            }
        }
    }

    /**
     * @return sistemaOperativoTypedQuery
     */
    @Override
    public Stream<SistemaOperativo> obtenerSistemaOperativoStream() {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            var sistemaOperativoTypedQuery = requireNonNull(emfa).createNamedQuery("SistemaOperativo.findAll",SistemaOperativo.class);
            return sistemaOperativoTypedQuery.getResultStream();
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            return Stream.empty();
        } finally {
            if(requireNonNull(emfa).isOpen()) {
                emfa.clear();
                emfa.close();
                out.println("Cerrando entitymanagerfactory.............");
            }
            if(requireNonNull(emt).isOpen()){
                emt.close();
                out.println("Cerrando entitymanager.............");
            }
        }
    }

    @Override
    public SistemaOperativo obtenerSistemaOperativoActivo(String sistemaOperativo) {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            assert emfa != null;
            requireNonNull(emfa).getTransaction().begin();
            var sisOpeTypedQuery = requireNonNull(emfa).createNamedQuery("SistemaOperativo.findByNombre_so", SistemaOperativo.class);
            sisOpeTypedQuery.setParameter(1, sistemaOperativo);
            var miSO = sisOpeTypedQuery.getSingleResult();
            requireNonNull(emfa).getTransaction().commit();
            out.println(emfa.contains(miSO));
            return miSO;
        } catch (Exception e) {
            out.printf(STR."\{e.getLocalizedMessage()}");
            if (requireNonNull(emfa).getTransaction().isActive()) {
                requireNonNull(emfa).getTransaction().rollback();
            }
            return null;
        } finally {
            if (requireNonNull(emfa).isOpen()) {
                emfa.clear();
                emfa.close();
                out.println("Cerrando entitymanagerfactory.............");
            }
            if (requireNonNull(emt).isOpen()) emt.close();
            out.println("Cerrando entitymanager.............");
        }
    }

    @Override
    public Optional<SistemaOperativo> obtenerUltimoRegistro() {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            assert emfa != null;
            requireNonNull(emfa).getTransaction().begin();
            var sosUltimoTypeQuery = requireNonNull(emfa).createNamedQuery("SistemaOperativo.findLast", SistemaOperativo.class);
            var miUltimo = sosUltimoTypeQuery.setMaxResults(1).getResultList().stream().filter(Objects::nonNull).findFirst();
            requireNonNull(emfa).getTransaction().commit();
            if (miUltimo.isPresent()) {
                return miUltimo;
            } else {
                out.println("No existe registro de codigo piso");
                return empty();
            }
        } catch (Exception e) {
            out.printf(STR."\{e.getLocalizedMessage()}");
            if (requireNonNull(emfa).getTransaction().isActive()) {
                requireNonNull(emfa).getTransaction().rollback();
            }
            return empty();
        } finally {
            if (requireNonNull(emfa).isOpen()) {
                emfa.clear();
                emfa.close();
                out.println("Cerrando entitymanagerfactory.............");
            }
            if (requireNonNull(emt).isOpen()) emt.close();
            out.println("Cerrando entitymanager.............");
        }
    }
}