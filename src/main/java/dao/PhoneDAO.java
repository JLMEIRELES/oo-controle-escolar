package dao;

import model.Phone;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PhoneDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public PhoneDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(Phone _phone) {
        em.getTransaction().begin();
        em.merge(_phone);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(Phone _phone) {
        em.getTransaction().begin();
        em.merge(_phone);
        em.getTransaction().commit();
        emf.close();
    }

    public void delete(Phone _phone) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM phones WHERE id = " + _phone.getId());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

}
