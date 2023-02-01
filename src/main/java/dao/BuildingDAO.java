package dao;

import model.Building;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BuildingDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public BuildingDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(Building _building) {
        em.getTransaction().begin();
        em.merge(_building);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(Building _building) {
        em.getTransaction().begin();
        em.merge(_building);
        em.getTransaction().commit();
        emf.close();
    }

    public void delete(Building _building) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM building WHERE id = " + _building.getId());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

}