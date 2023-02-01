package dao;

import model.Team;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TeamDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public TeamDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(Team _team) {
        em.getTransaction().begin();
        em.merge(_team);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(Team _team) {
        em.getTransaction().begin();
        em.merge(_team);
        em.getTransaction().commit();
        emf.close();
    }

    public void delete(Team _team) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM team WHERE id = " + _team.getId());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

}