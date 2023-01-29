package dao;

import model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public UserDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(User _user) {
        em.getTransaction().begin();
        em.merge(_user);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(User _user) {
        em.getTransaction().begin();
        em.merge(_user);
        em.getTransaction().commit();
        emf.close();
    }

    public void delete(User _user) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM users WHERE id = " + _user.getId());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

}
