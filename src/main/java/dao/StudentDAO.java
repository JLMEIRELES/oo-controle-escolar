package dao;

import model.Student;
import model.Note;
import model.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import util.JPAUtil;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public class StudentDAO {
    private final EntityManager entityManager;

    public StudentDAO() {
        this.entityManager = JPAUtil.getEntityManager();
    }

    public Student getStudentByMatricula(String matricula){
        String jpql = "SELECT s FROM Student s WHERE s.matricula = :matricula";
        List<Student> studentList = entityManager.createQuery(jpql, Student.class).setParameter("matricula", matricula).getResultList();
        Optional<Student> student = studentList.stream().findFirst();
        return student.orElse(null);
    }

    public User getUser(Student student){
        BigInteger userID = (BigInteger) entityManager.createNativeQuery("SELECT s.user_id FROM students s WHERE s.matricula = ?").setParameter(1, student.getMatricula()).getSingleResult();
        Long longUserId = userID.longValue();
        String jpql_user = "SELECT u FROM User u where u.id = :userId";
        List<User> userList = entityManager.createQuery(jpql_user, User.class).setParameter("userId", longUserId).getResultList();
        Optional<User> user = userList.stream().findFirst();
        return user.orElse(null);
    }

    public Student createStudent(Student student){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return student;
    }
    public List<Student> list() {
        Query q = entityManager.createQuery("SELECT s FROM Student s");
        List<Student> students = q.getResultList();
        return students;
    }

}
