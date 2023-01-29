package dao;

import model.Parents;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ParentsDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public ParentsDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(Parents _parents) {
        em.getTransaction().begin();
        em.merge(_parents);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(Parents _parents) {
        em.getTransaction().begin();
        em.merge(_parents);
        em.getTransaction().commit();
        emf.close();
    }

    public void delete(Parents _parents) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM parents WHERE id = " + _parents.getId());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

}
