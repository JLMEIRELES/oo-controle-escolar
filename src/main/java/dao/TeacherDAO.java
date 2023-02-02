package dao;

import model.Teacher;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TeacherDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public TeacherDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(Teacher _teacher) {
        em.getTransaction().begin();
        em.merge(_teacher);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(Teacher _teacher) {
        em.getTransaction().begin();
        em.merge(_teacher);
        em.getTransaction().commit();
        emf.close();
    }

    public void delete(Teacher _teacher) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM teachers WHERE id = " + _teacher.getId());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }
}
