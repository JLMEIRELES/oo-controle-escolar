package dao;

import model.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;


public class StudentDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public StudentDAO () {
        emf = Persistence.createEntityManagerFactory("controle-escolar");
        em = emf.createEntityManager();
    }

    public void insert(Student _student) {
        em.getTransaction().begin();
        em.merge(_student);
        em.getTransaction().commit();
        emf.close();
    }

    public void update(Student _student) {
        em.getTransaction().begin();
        em.merge(_student);
        em.getTransaction().commit();
        emf.close();
    }

    public void delete(Student _student) {
        em.getTransaction().begin();
        Query q = em.createNativeQuery("DELETE FROM students WHERE id = " + _student.getId());
        q.executeUpdate();
        em.getTransaction().commit();
        emf.close();
    }
    public List<Student> list() {
        Query q = em.createQuery("SELECT s FROM Student s");
        List<Student> students = q.getResultList();
        return students;
    }
}
