package org.example.ejb;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

@ApplicationScoped
public class ProducerResources {

    @PersistenceUnit(unitName = "ejemploJPA")
    private EntityManagerFactory emf;

    @Produces
    @RequestScoped
    private EntityManager getEmf() {
        return emf.createEntityManager();
    }

    public void closeEmf(@Disposes EntityManager em ) {
        if (em.isOpen()) {
            em.close();
            System.out.println("Cerrando EntityManager");
        }
    }


}
