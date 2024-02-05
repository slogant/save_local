package org.matis.bonito.controller;

import org.matis.bonito.impl.TipoEquipoImpl;
import org.matis.bonito.model.TipoEquipo;

import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Objects.requireNonNull;
import static java.util.Optional.empty;
import static org.matis.bonito.db.ConectaEntityDB.obtenerEntityManager;
import static org.matis.bonito.db.ConectaEntityDB.obtenerEntityManagerFactory;

public class TipoEquipoController implements Serializable, TipoEquipoImpl {
    @Override
    public boolean crearTipoEquipo(TipoEquipo tipoEquipo) {
        var em = obtenerEntityManagerFactory();
        var emf = obtenerEntityManager(em);
        try {
            requireNonNull(emf).getTransaction().begin();
            emf.persist(tipoEquipo);
            requireNonNull(emf).getTransaction().commit();
            return emf.contains(tipoEquipo);
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
    public boolean eliminarTipoEquipo(String codigoTipo) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            var tipoEquipoTypedQuery = requireNonNull(emfc).createNamedQuery("TipoEquipo.findByCodigo_tipEqulike", TipoEquipo.class);
            tipoEquipoTypedQuery.setParameter(1, codigoTipo);
            var tipoEquipo = tipoEquipoTypedQuery.setMaxResults(1).getSingleResult();
            requireNonNull(emfc).getTransaction().commit();
            requireNonNull(emfc).getTransaction().begin();
            emfc.remove(tipoEquipo);
            requireNonNull(emfc).getTransaction().commit();
            return !emfc.contains(tipoEquipo);
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

    @Override
    public boolean actualizaTipoEquipo(String codigoTipo, TipoEquipo tipoEquipo) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            var sisOpeTypedQuery = requireNonNull(emfc).createNamedQuery("TipoEquipo.findByCodigo_tipEqulike", TipoEquipo.class);
            sisOpeTypedQuery.setParameter(1, codigoTipo);
            var tipoEquipo1 = sisOpeTypedQuery.setMaxResults(1).getSingleResult();
            requireNonNull(emfc).getTransaction().commit();
            requireNonNull(emfc).getTransaction().begin();
            tipoEquipo1.setNombre_tipo(tipoEquipo.getNombre_tipo());
            tipoEquipo1.setCodigo_tipo(tipoEquipo.getCodigo_tipo());
            emfc.merge(tipoEquipo1);
            requireNonNull(emfc).getTransaction().commit();
            return emfc.contains(tipoEquipo1);
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

    @Override
    public Stream<TipoEquipo> obtenerTipoEquipos() {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            var tipoEquipoTypedQuery = requireNonNull(emfa).createNamedQuery("TipoEquipo.findAll", TipoEquipo.class);
            return tipoEquipoTypedQuery.getResultStream();
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            return Stream.empty();
        } finally {
            if (requireNonNull(emfa).isOpen()) {
                emfa.clear();
                emfa.close();
                out.println("Cerrando entitymanagerfactory.............");
            }
            if (requireNonNull(emt).isOpen()) {
                emt.close();
                out.println("Cerrando entitymanager.............");
            }
        }
    }

    @Override
    public TipoEquipo obtenerTipoEquipoActivo(String codigoTipo) {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            assert emfa != null;
            requireNonNull(emfa).getTransaction().begin();
            var tipoEquipoTypedQuery = requireNonNull(emfa).createNamedQuery("TipoEquipo.findByNombre_tipo", TipoEquipo.class);
            tipoEquipoTypedQuery.setParameter(1, codigoTipo);
            var miTipoEquipo = tipoEquipoTypedQuery.getSingleResult();
            requireNonNull(emfa).getTransaction().commit();
            out.println(emfa.contains(miTipoEquipo));
            return miTipoEquipo;
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
    public Optional<TipoEquipo> obtenerUltimoTipoEquipoRegistro() {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            assert emfa != null;
            requireNonNull(emfa).getTransaction().begin();
            var tipoEquipoTypedQuery = requireNonNull(emfa).createNamedQuery("TipoEquipo.findLastTipoCodigo", TipoEquipo.class);
            var miUltimoTipoEquipo = tipoEquipoTypedQuery.setMaxResults(1).getResultList().stream().filter(Objects::nonNull).findFirst();
            requireNonNull(emfa).getTransaction().commit();
            if (miUltimoTipoEquipo.isPresent()) {
                return miUltimoTipoEquipo;
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
