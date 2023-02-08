package dao;

import model.Teacher;
import model.User;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;



public class TeacherDAO {

    private final EntityManager entityManager;

    public TeacherDAO() {
        this.entityManager = JPAUtil.getEntityManager();
    }

    public Teacher getTeacherByMatricula(String matricula){
        String jpql = "SELECT t FROM Teacher t WHERE t.matricula = :matricula";
        List<Teacher> teacherList = entityManager.createQuery(jpql, Teacher.class).setParameter("matricula", matricula).getResultList();
        Optional<Teacher> teacher = teacherList.stream().findFirst();
        return teacher.orElse(null);
    }

    public User getUser(Teacher teacher){
        BigInteger userID = (BigInteger) entityManager.createNativeQuery("SELECT t.user_id FROM teachers t WHERE t.matricula = ?").setParameter(1, teacher.getMatricula()).getSingleResult();
        Long longUserId = userID.longValue();
        String jpql_user = "SELECT u FROM User u where u.id = :userId";
        List<User> userList = entityManager.createQuery(jpql_user, User.class).setParameter("userId", longUserId).getResultList();
        Optional<User> user = userList.stream().findFirst();
        return user.orElse(null);
    }

    public Teacher createTeacher(Teacher teacher){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(teacher);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return teacher;
    }
}
