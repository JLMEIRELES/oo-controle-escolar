package dao;

import model.Subject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SubjectDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public SubjectDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(Subject _subject) {
        em.getTransaction().begin();
        em.merge(_subject);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(Subject _subject) {
        em.getTransaction().begin();
        em.merge(_subject);
        em.getTransaction().commit();
        emf.close();
    }

//    public void delete(Subject _subject) {
//        em.getTransaction().begin();
//        Query q = em.createNativeQuery("DELETE FROM subject WHERE id = " + _subject.getId());
//        q.executeUpdate();
//        em.getTransaction().commit();
//        emf.close();
//    }

}