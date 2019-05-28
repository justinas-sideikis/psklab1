package psklab1.persistence;

import lombok.Getter;
import lombok.Setter;
import psklab1.entities.Team;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
@Getter@Setter
public class TeamsDAO {
    @PersistenceContext
    private EntityManager em;

    public List<Team> loadAll() {
        return em.createNamedQuery("Team.getAll", Team.class).getResultList();
    }

    public Team load(Integer id) {
        return em.find(Team.class, id);
    }

    public Team update(Team team) {
        return this.em.merge(team);
    }

    public String persist(Team team){
        this.em.persist(team);

        return "success";
    }
}
