package psklab1.persistence;


import psklab1.entities.Stage;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class StagesDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Stage> loadAll() {
        return em.createNamedQuery("Stage.getAll", Stage.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Stage stage){
        this.em.persist(stage);
    }
}
