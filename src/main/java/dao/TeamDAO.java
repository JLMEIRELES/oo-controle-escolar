package dao;

import model.Student;
import model.Teacher;
import model.Team;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public class TeamDAO {

    private final EntityManager entityManager;

    public TeamDAO() {
        this.entityManager = JPAUtil.getEntityManager();
    }

    public Teacher getTeacher(Team team){
        String jpql = "SELECT t FROM Teacher t WHERE t.id = :id";
        List<Teacher> teacherList = entityManager.createQuery(jpql,Teacher.class).setParameter("id", team.getTeacher().getId()).getResultList();
        Optional<Teacher> teacher = teacherList.stream().findFirst();
        return teacher.orElse(null);
    }

    public void createTeam(Team team) {
        this.entityManager.persist(team);
    }
    public List<Team> list() {
        Query q = entityManager.createQuery("SELECT s FROM teams s");
        List<Team> teams = q.getResultList();
        return teams;
    }
}
