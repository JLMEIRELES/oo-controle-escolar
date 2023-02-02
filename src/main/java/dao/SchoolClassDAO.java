package dao;

import model.SchoolClass;
import model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SchoolClassDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public SchoolClassDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(SchoolClass _schoolclass) {
        em.getTransaction().begin();
        em.merge(_schoolclass);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(SchoolClass _schoolclass) {
        em.getTransaction().begin();
        em.merge(_schoolclass);
        em.getTransaction().commit();
        emf.close();
    }

    public void delete(SchoolClass _schoolclass) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM schoolclass WHERE id = " + _schoolclass.getId());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

}
