package dao;

import model.ClassAttendance;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClassAttendanceDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public ClassAttendanceDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(ClassAttendance _classattendance) {
        em.getTransaction().begin();
        em.merge(_classattendance);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(ClassAttendance _classattendance) {
        em.getTransaction().begin();
        em.merge(_classattendance);
        em.getTransaction().commit();
        emf.close();
    }

    public void delete(ClassAttendance _classattendance) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM class_attendance WHERE id = " + _classattendance.getId());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }

}