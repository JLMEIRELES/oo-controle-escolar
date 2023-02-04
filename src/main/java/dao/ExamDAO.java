package dao;

import model.Exam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ExamDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public ExamDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(Exam _exam) {
        em.getTransaction().begin();
        em.merge(_exam);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(Exam _exam) {
        em.getTransaction().begin();
        em.merge(_exam);
        em.getTransaction().commit();
        emf.close();
    }

//    public void delete(Exam _exam) {
//        em.getTransaction().begin();
//        Query q = em.createNativeQuery("DELETE FROM exam WHERE id = " + _exam.getId());
//        q.executeUpdate();
//        em.getTransaction().commit();
//        emf.close();
//    }

}