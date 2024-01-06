package org.matis.bonito.db;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.io.Serializable;

import static jakarta.persistence.Persistence.*;
import static java.util.Objects.requireNonNull;

public final class ConectaEntityDB implements Serializable {
    static public EntityManager obtenerEntityManager(EntityManagerFactory entityManagerFactory) {
        if ((entityManagerFactory != null) || !requireNonNull(entityManagerFactory.isOpen())) {
            return entityManagerFactory.createEntityManager();
        } else {
            return null;
        }
    }
    static public EntityManagerFactory obtenerEntityManagerFactory() {
        var entityManagerFactory = createEntityManagerFactory(MATIS);
        if ((entityManagerFactory != null || !requireNonNull(entityManagerFactory.isOpen()))) {
            return entityManagerFactory;
        } else {
            return null;
        }
    }
    static final private String MATIS;

    static {
        MATIS = "bonitomatis";
    }
}
