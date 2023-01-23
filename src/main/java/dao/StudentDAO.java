package dao;

import model.Student;
import javax.persistence.EntityManager;


public class StudentDAO {

    private final EntityManager entityManager;

    public StudentDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void createStudent(Student student){
        this.entityManager.persist(student);
    }

}
