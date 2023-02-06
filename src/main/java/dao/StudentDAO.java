package dao;

import model.Student;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

}
