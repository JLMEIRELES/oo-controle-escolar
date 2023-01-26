package dao;

import model.Student;
import model.Teacher;

import javax.persistence.EntityManager;

public class TeacherDAO {
    private final EntityManager entityManager;

    public TeacherDAO(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void createTeacher(Teacher teacher){
        this.entityManager.persist(teacher);
    }
}
