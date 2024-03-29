package org.matis.bonito.controller;

import org.matis.bonito.impl.SedesImpl;
import org.matis.bonito.model.Sedes;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Objects.requireNonNull;
import static org.matis.bonito.db.ConectaEntityDB.obtenerEntityManager;
import static org.matis.bonito.db.ConectaEntityDB.obtenerEntityManagerFactory;

public class SedeController implements Serializable, SedesImpl {

    @Override
    public boolean crearSede(Sedes sedes) {
        var em = obtenerEntityManagerFactory();
        var emf = obtenerEntityManager(em);
        try {
            requireNonNull(emf).getTransaction().begin();
            emf.persist(sedes);
            requireNonNull(emf).getTransaction().commit();
            return emf.contains(sedes);
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            if (requireNonNull(emf).getTransaction().isActive()) {
                requireNonNull(emf).getTransaction().rollback();
            }
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

    @Override
    public boolean EliminarSede(String codigo_sede) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            var sedesTypedQuery = requireNonNull(emfc).createNamedQuery("Sedes.findByCodigo_sedelike", Sedes.class);
            sedesTypedQuery.setParameter(1,codigo_sede);
            var sedes = sedesTypedQuery.setMaxResults(1).getSingleResult();
            requireNonNull(emfc).getTransaction().commit();
            requireNonNull(emfc).getTransaction().begin();
            emfc.remove(sedes);
            requireNonNull(emfc).getTransaction().commit();
            return !emfc.contains(sedes);
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
     * @param sedes 
     * @return
     */
    @Override
    public boolean actualizaSede(String codigo_sede,Sedes sedes) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            var sedesTypedQuery = requireNonNull(emfc).createNamedQuery("Sedes.findByCodigo_sedelike", Sedes.class);
            sedesTypedQuery.setParameter(1,codigo_sede);
            var sedes1 = sedesTypedQuery.setMaxResults(1).getSingleResult();
            requireNonNull(emfc).getTransaction().commit();
            requireNonNull(emfc).getTransaction().begin();
            sedes1.setNombre_sede(sedes.getNombre_sede());
            sedes1.setCodigo_sede(sedes.getCodigo_sede());
            emfc.merge(sedes1);
            requireNonNull(emfc).getTransaction().commit();
            return emfc.contains(sedes1);
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
     * @return 
     */
    @Override
    public Stream<Sedes> obtenerSedes() {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            var sedesTypedQuery = requireNonNull(emfa).createNamedQuery("Sedes.findAll",Sedes.class);
            return sedesTypedQuery.getResultStream();
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

    @Override
    public Sedes obtenerSedeActivo(String sede) {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            assert emfa != null;
            requireNonNull(emfa).getTransaction().begin();
            var sedesTypedQuery = requireNonNull(emfa).createNamedQuery("Sedes.findByNombre_sede",Sedes.class);
            sedesTypedQuery.setParameter(1,sede);
            var misSedes = sedesTypedQuery.getSingleResult();
            requireNonNull(emfa).getTransaction().commit();
            out.println(emfa.contains(misSedes));
            return misSedes;
        } catch (Exception e) {
            out.printf(STR."\{e.getLocalizedMessage()}");
            if(requireNonNull(emfa).getTransaction().isActive()) {
                requireNonNull(emfa).getTransaction().rollback();
            }
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
    @Override
    public Optional<Sedes> obtenerUltimoRegistro() {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            assert emfa != null;
            requireNonNull(emfa).getTransaction().begin();
            var sedesUltimoTypeQuery = requireNonNull(emfa).createNamedQuery("Sedes.findLastCodigoSede",Sedes.class);
            var miUltimo = sedesUltimoTypeQuery.setMaxResults(1).getResultList().stream().filter(Objects::nonNull).findFirst();
            requireNonNull(emfa).getTransaction().commit();
            if(miUltimo.isPresent()) {
                return miUltimo;
            } else {
                out.println("No existe registro de codigo sede");
                return Optional.empty();
            }
        } catch (Exception e) {
            out.printf(STR."\{e.getLocalizedMessage()}");
            if(requireNonNull(emfa).getTransaction().isActive()) {
                requireNonNull(emfa).getTransaction().rollback();
            }
            return Optional.empty();
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
