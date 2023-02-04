package dao;

import model.Classroom;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ClassroomDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public ClassroomDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(Classroom _classroom) {
        em.getTransaction().begin();
        em.merge(_classroom);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(Classroom _classroom) {
        em.getTransaction().begin();
        em.merge(_classroom);
        em.getTransaction().commit();
        emf.close();
    }

//    public void delete(Classroom _classroom) {
//        em.getTransaction().begin();
//        Query q = em.createNativeQuery("DELETE FROM classroom WHERE id = " + _classroom.getId());
//        q.executeUpdate();
//        em.getTransaction().commit();
//        emf.close();
//    }

}