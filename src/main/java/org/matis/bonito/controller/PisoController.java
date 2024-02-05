package org.matis.bonito.controller;

import org.matis.bonito.impl.PisoImpl;
import org.matis.bonito.model.Piso;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Objects.requireNonNull;
import static java.util.Optional.empty;
import static org.matis.bonito.db.ConectaEntityDB.obtenerEntityManager;
import static org.matis.bonito.db.ConectaEntityDB.obtenerEntityManagerFactory;

public final class PisoController implements Serializable, PisoImpl {
    
    @Override
    public boolean crearPiso(Piso piso) {
        var em = obtenerEntityManagerFactory();
        var emf = obtenerEntityManager(em);
        try {
            requireNonNull(emf).getTransaction().begin();
            emf.persist(piso);
            requireNonNull(emf).getTransaction().commit();
            return emf.contains(piso);
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
            }
            if (requireNonNull(em).isOpen()) em.close();
        }
    }

    @Override
    public boolean EliminarPiso(String codigo_piso) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            var pisoTypedQuery = requireNonNull(emfc).createNamedQuery("Piso.findByCodigoPiso_pisolike", Piso.class);
            pisoTypedQuery.setParameter(1, codigo_piso);
            var pisos = pisoTypedQuery.setMaxResults(1).getSingleResult();
            requireNonNull(emfc).getTransaction().commit();
            requireNonNull(emfc).getTransaction().begin();
            emfc.remove(pisos);
            requireNonNull(emfc).getTransaction().commit();
            return !emfc.contains(pisos);
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            requireNonNull(emfc).getTransaction().rollback();
            return false;
        } finally {
            if (requireNonNull(emfc).isOpen()) {
                emfc.clear();
                emfc.close();
            }
            if (emt != null && emt.isOpen()) emt.close();
        }
    }

    /**
     * @param codigo_piso
     * @param piso
     * @return
     */
    @Override
    public boolean actualizaPiso(String codigo_piso, Piso piso) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            var pisoTypedQuery = requireNonNull(emfc).createNamedQuery("Piso.findByCodigo_pisolike", Piso.class);
            pisoTypedQuery.setParameter(1, codigo_piso);
            var piso1 = pisoTypedQuery.setMaxResults(1).getSingleResult();
            requireNonNull(emfc).getTransaction().commit();
            requireNonNull(emfc).getTransaction().begin();
            piso1.setNombre_piso(piso.getNombre_piso());
            piso1.setCodigo_piso(piso.getCodigo_piso());
            emfc.merge(piso1);
            requireNonNull(emfc).getTransaction().commit();
            return emfc.contains(piso1);
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            requireNonNull(emfc).getTransaction().rollback();
            return false;
        } finally {
            if (requireNonNull(emt).isOpen()) emt.close();
            if (requireNonNull(emfc).isOpen()) {
                emfc.clear();
                emfc.close();
            }
        }
    }

    @Override
    public Stream<Piso> obtenerPiso() {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            var sedesTypedQuery = requireNonNull(emfa).createNamedQuery("Piso.findAll", Piso.class);
            return sedesTypedQuery.getResultStream();
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            return null;
        } finally {
            if (requireNonNull(emfa).isOpen()) {
                emfa.clear();
                emfa.close();
            }
            if (requireNonNull(emt).isOpen()) emt.close();
        }
    }
    @Override
    public Piso obtenerPisoActivo(String piso) {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            assert emfa != null;
            requireNonNull(emfa).getTransaction().begin();
            var pisosTypedQuery = requireNonNull(emfa).createNamedQuery("Piso.findByNombre_piso", Piso.class);
            pisosTypedQuery.setParameter(1, piso);
            var miPiso = pisosTypedQuery.getSingleResult();
            requireNonNull(emfa).getTransaction().commit();
            out.println(emfa.contains(miPiso));
            return miPiso;
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
            }
            if (requireNonNull(emt).isOpen()) emt.close();
        }
    }

    @Override
    public Optional<Piso> obtenerUltimoPisoRegistro() {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            assert emfa != null;
            requireNonNull(emfa).getTransaction().begin();
            var pisosUltimoTypeQuery = requireNonNull(emfa).createNamedQuery("Piso.findLastCodigoPiso", Piso.class);
            var miUltimo = pisosUltimoTypeQuery.setMaxResults(1).getResultList().stream().filter(Objects::nonNull).findFirst();
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
            }
            if (requireNonNull(emt).isOpen()) emt.close();
        }
    }
}