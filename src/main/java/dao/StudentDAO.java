package dao;

import model.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class StudentDAO {
    private final EntityManager entityManager;

    public StudentDAO() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("controle-escolar");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void createStudent(Student student){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }
    public List<Student> list() {
        Query q = entityManager.createQuery("SELECT s FROM Student s");
        List<Student> students = q.getResultList();
        return students;
    }

}
