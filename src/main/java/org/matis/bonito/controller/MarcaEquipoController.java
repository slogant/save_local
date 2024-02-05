package org.matis.bonito.controller;

import org.matis.bonito.impl.MarcaEquipoImpl;
import org.matis.bonito.model.MarcaEquipo;

import java.io.Serializable;
import static java.lang.System.out;
import static java.util.Objects.requireNonNull;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Optional.empty;
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

    /**
     * @param codigoMarca
     * @return
     */
    @Override
    public boolean eliminarMarcaEquipo(String codigoMarca) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            var marcaTypedQuery = requireNonNull(emfc).createNamedQuery("MarcaEquipo.findByMarcaEquipolike", MarcaEquipo.class);
            marcaTypedQuery.setParameter(1, codigoMarca);
            var marcaEquipo = marcaTypedQuery.setMaxResults(1).getSingleResult();
            requireNonNull(emfc).getTransaction().commit();
            requireNonNull(emfc).getTransaction().begin();
            emfc.remove(marcaEquipo);
            requireNonNull(emfc).getTransaction().commit();
            return !emfc.contains(marcaEquipo);
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
     * @param codigoMarca
     * @param marcaEquipo
     * @return
     */
    @Override
    public boolean actualizaMarcaEquipo(String codigoMarca, MarcaEquipo marcaEquipo) {
          var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            var marcaEquipoTypedQuery = requireNonNull(emfc).createNamedQuery("MarcaEquipo.findByMarcaEquipolike", MarcaEquipo.class);
            marcaEquipoTypedQuery.setParameter(1, codigoMarca);
            var marcaEquipo1 = marcaEquipoTypedQuery.setMaxResults(1).getSingleResult();
            requireNonNull(emfc).getTransaction().commit();
            requireNonNull(emfc).getTransaction().begin();
            marcaEquipo1.setNombre_marca(marcaEquipo.getNombre_marca());
            marcaEquipo1.setCodigo_marca(marcaEquipo.getCodigo_marca());
            emfc.merge(marcaEquipo1);
            requireNonNull(emfc).getTransaction().commit();
            return emfc.contains(marcaEquipo1);
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
    public Stream<MarcaEquipo> obtenerMarcaEquipos() {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            var marcaEquipoTypedQuery = requireNonNull(emfa).createNamedQuery("MarcaEquipo.findAll", MarcaEquipo.class);
            return marcaEquipoTypedQuery.getResultStream();
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
    public MarcaEquipo obtenerMarcaActivo(String codigoMarca) {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            assert emfa != null;
            requireNonNull(emfa).getTransaction().begin();
            var marcaEquipoTypedQuery = requireNonNull(emfa).createNamedQuery("MarcaEquipo.findByNombre_marca", MarcaEquipo.class);
            marcaEquipoTypedQuery.setParameter(1, codigoMarca);
            var miMarcaEquipo = marcaEquipoTypedQuery.getSingleResult();
            requireNonNull(emfa).getTransaction().commit();
            out.println(emfa.contains(miMarcaEquipo));
            return miMarcaEquipo;
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
    public Optional<MarcaEquipo> obtenerUltimoRegistroMarca() {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            assert emfa != null;
            requireNonNull(emfa).getTransaction().begin();
            var marcaEquipoTypedQuery = requireNonNull(emfa).createNamedQuery("MarcaEquipo.findLastcodigo_marca", MarcaEquipo.class);
            var miUltimoMarcaEquipo = marcaEquipoTypedQuery.setMaxResults(1).getResultList().stream().filter(Objects::nonNull).findFirst();
            requireNonNull(emfa).getTransaction().commit();
            if (miUltimoMarcaEquipo.isPresent()) {
                return miUltimoMarcaEquipo;
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
