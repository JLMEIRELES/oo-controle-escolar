package dao;

import model.Records;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class RecordsDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public RecordsDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(Records _records) {
        em.getTransaction().begin();
        em.merge(_records);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(Records _records) {
        em.getTransaction().begin();
        em.merge(_records);
        em.getTransaction().commit();
        emf.close();
    }

    public void delete(Records _records) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM records WHERE id = " + _records.getId());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }
}
