package org.matis.bonito.controller;

import org.matis.bonito.impl.IngSopImpl;
import org.matis.bonito.model.IngenieroSoporte;

import java.io.Serializable;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.Objects.requireNonNull;
import static org.matis.bonito.db.ConectaEntityDB.obtenerEntityManager;
import static org.matis.bonito.db.ConectaEntityDB.obtenerEntityManagerFactory;

/**
 *
 * @author oscar
 */
public class IngSopController implements Serializable, IngSopImpl {

    public IngSopController() {}

    @Override
    public boolean crearIngSop(IngenieroSoporte ing) {
        var em = obtenerEntityManagerFactory();
        var emf = obtenerEntityManager(em);
        try {
        requireNonNull(emf).getTransaction().begin();
        emf.persist(ing);
        requireNonNull(emf).getTransaction().commit();
        return emf.contains(ing);
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

    @Override
    public boolean eliminarIngsop(String numeroEmp) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            var soloIngeSop = requireNonNull(emfc).createNamedQuery("IngenieroSoporte.findByNumero_Empleado",IngenieroSoporte.class);
            soloIngeSop.setParameter(1,numeroEmp);
            var ingeniero = soloIngeSop.setMaxResults(1).getSingleResult();
            requireNonNull(emfc).getTransaction().commit();
            requireNonNull(emfc).getTransaction().begin();
            emfc.remove(ingeniero);
            requireNonNull(emfc).getTransaction().commit();
            return !emfc.contains(ingeniero);
        } catch (Exception e) {
            out.printf("Error en: %s%n", e.getLocalizedMessage());
            if(requireNonNull(emfc).getTransaction().isActive()) {
                requireNonNull(emfc).getTransaction().rollback();
            }
            return false;
        } finally {
            if(requireNonNull(emfc).isOpen()) {
                emfc.clear();
                emfc.close();
            }
            if (emt != null || requireNonNull(emt).isOpen()) {
                emt.close();
            }
        }
    }

    @Override
    public boolean actualizaIngSop(String numeroEmp, IngenieroSoporte ingenieroSoporte) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
            try {
                assert emfc != null;
                requireNonNull(emfc).getTransaction().begin();
                var soloIngeSop = requireNonNull(emfc).createNamedQuery("IngenieroSoporte.findByNumero_Empleado",IngenieroSoporte.class);
                soloIngeSop.setParameter(1,numeroEmp);
                var ingeniero = soloIngeSop.setMaxResults(1).getSingleResult();
                requireNonNull(emfc).getTransaction().commit();
                requireNonNull(emfc).getTransaction().begin();
                ingeniero.setNombre_ing(ingenieroSoporte.getNombre_ing());
                ingeniero.setApellido_pat(ingenieroSoporte.getApellido_pat());
                ingeniero.setApellido_mat(ingenieroSoporte.getApellido_mat());
                ingeniero.setNumero_empleado(ingenieroSoporte.getNumero_empleado());
                emfc.merge(ingeniero);
                out.println(STR."\{ingeniero}---------------------------------------------------------");
                requireNonNull(emfc).getTransaction().commit();
                out.println(emfc.contains(ingeniero));
                return emfc.contains(ingeniero);
            } catch (Exception e) {
                out.printf("Error en: %s%n", e.getLocalizedMessage());
                if(requireNonNull(emfc).getTransaction().isActive()) {
                    requireNonNull(emfc).getTransaction().rollback();
                }
                return false;
            } finally {
                if(requireNonNull(emt).isOpen()) {
                    emt.close();
                }
                if(requireNonNull(emfc).isOpen()) {
                    emfc.clear();
                    emfc.close();
                }
            }
        }

    @Override
    public Stream<IngenieroSoporte> obtenerIngSop() {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            var ingenieroSoporteTypedQuery = requireNonNull(emfa).createNamedQuery("All.Ing",IngenieroSoporte.class);
            return ingenieroSoporteTypedQuery.getResultStream();
        } catch (Exception e) {
            out.println(STR."\{e.getLocalizedMessage()}");
            return null;
        } finally {
            if(requireNonNull(emfa).isOpen()) {
                emfa.clear();
                emfa.close();
            }
            if(requireNonNull(emt).isOpen()) {
                emt.close();
            }
        }
    }

    @Override
    public Stream<IngenieroSoporte> otenerIngSopNumEmp(String numeroEmp) {
        var emt = obtenerEntityManagerFactory();
        var emfa = obtenerEntityManager(emt);
        try {
            assert emfa != null;
            requireNonNull(emfa).getTransaction().begin();
            var soloIngeSop = requireNonNull(emfa).createNamedQuery("FindBy.NumeroEmp",IngenieroSoporte.class);
            soloIngeSop.setParameter(1,"%"+ numeroEmp + "%");
            requireNonNull(emfa).getTransaction().commit();
            return soloIngeSop.getResultStream();
        } catch (Exception e) {
            out.println(STR."\{e.getLocalizedMessage()}");
            return null;
        } finally {
            if(requireNonNull(emfa).isOpen()) {
                emfa.clear();
                emfa.close();
            }
            if(requireNonNull(emt).isOpen()) {
                emt.close();
            }
        }
    }

    @Override
    public IngenieroSoporte obtenerIngenieroSoporteActivo(String numeroEmpleado) {
        var emt = obtenerEntityManagerFactory();
        var emfc = obtenerEntityManager(emt);
        try {
            assert emfc != null;
            requireNonNull(emfc).getTransaction().begin();
            var soloIngeSopNum = requireNonNull(emfc).createNamedQuery("IngenieroSoporte.findByNumero_Empleado",IngenieroSoporte.class);
            soloIngeSopNum.setParameter(1,numeroEmpleado);
            var ingeniero = soloIngeSopNum.setMaxResults(1).getSingleResult();
            requireNonNull(emfc).getTransaction().commit();
            out.println(emfc.contains(ingeniero));
            return ingeniero;
        } catch (Exception e) {
            out.println(STR."\{e.getLocalizedMessage()}");
            if(requireNonNull(emfc).getTransaction().isActive()) {
                requireNonNull(emfc).getTransaction().rollback();
            }
           return null;
        } finally {
            if(requireNonNull(emfc).isOpen()) {
                emfc.clear();
                emfc.close();
            }
            if (emt != null || requireNonNull(emt).isOpen()) {
                emt.close();
            }
        }
    }
}