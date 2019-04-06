package psklab1.persistence;

import psklab1.entities.Worker;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class WorkersDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Worker> loadAll() {
        return em.createNamedQuery("Worker.findAll", Worker.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Worker worker){
        this.em.persist(worker);
    }
}
