package psklab1.persistence;

import lombok.Setter;
import psklab1.entities.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class TeamsDAO {
    @PersistenceContext
    @Setter
    private EntityManager em;

    public List<Team> loadAll() {
        return em.createNamedQuery("Team.getAll", Team.class).getResultList();
    }

    public String persist(Team team){
        this.em.persist(team);

        return "success";
    }
}
