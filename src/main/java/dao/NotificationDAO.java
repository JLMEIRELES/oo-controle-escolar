package dao;

import model.Notification;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NotificationDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public NotificationDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(Notification _notification) {
        em.getTransaction().begin();
        em.merge(_notification);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(Notification _notification) {
        em.getTransaction().begin();
        em.merge(_notification);
        em.getTransaction().commit();
        emf.close();
    }

//    public void delete(Notification _notification) {
//        em.getTransaction().begin();
//        Query q = em.createNativeQuery("DELETE FROM notification WHERE id = " + _notification.getId());
//        q.executeUpdate();
//        em.getTransaction().commit();
//        emf.close();
//    }

}